package cn.cpoet.mt.model.constant;

import cn.cpoet.mt.api.exception.EnumUndefinedException;
import cn.cpoet.mt.api.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.ebean.annotation.DbEnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 租户使用数据源类型
 *
 * @author CPoet
 */
@RequiredArgsConstructor
public enum TenantDSType {
    /**
     * 共享主数据源
     */
    MAIN(1),

    /**
     * 使用其它数据库
     */
    EXT(2),

    /**
     * 未定义
     */
    UNKNOWN(128);

    @Getter(onMethod_ = {@DbEnumValue, @JsonValue})
    private final int code;

    @JsonCreator
    public static TenantDSType ofCode(int code) {
        return EnumUtil.valueSafeOf(values(), TenantDSType::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
