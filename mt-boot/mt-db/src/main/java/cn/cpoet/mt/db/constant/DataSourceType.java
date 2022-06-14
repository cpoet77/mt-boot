package cn.cpoet.mt.db.constant;

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
    MAIN_MASTER(1, "主库-主"),

    /**
     * 主库
     */
    MAIN_SLAVE(2, "主库-从"),

    /**
     * 扩展库
     */
    EXT_MASTER(3, "扩展-主"),

    /**
     * 扩展库
     */
    EXT_SLAVE(4, "扩展-从");

    @Getter(onMethod_ = {@JsonValue, @DbEnumValue})
    private final int code;

    private final String desc;

    @JsonCreator
    public static DataSourceType ofCode(int code) {
        return EnumUtil.valueSafeOf(values(), DataSourceType::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
