package cn.cpoet.mt.entity.constant;

import cn.cpoet.mt.api.exception.EnumUndefinedException;
import cn.cpoet.mt.api.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.ebean.annotation.DbEnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 数据源类型
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum DataSourceType {
    /**
     * 主库
     */
    MASTER_MA(1, "主库-主"),

    /**
     * 主库
     */
    MASTER_VI(2, "主库-副"),

    /**
     * 副库
     */
    VICE_MA(3, "副库-主"),

    /**
     * 副库
     */
    VICE_VI(4, "副库-从");

    @Getter(onMethod_ = {@JsonValue, @DbEnumValue})
    private final int code;

    private final String desc;

    @JsonCreator
    public static DataSourceType ofCode(int code) {
        return EnumUtil.valueSafeOf(values(), DataSourceType::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
