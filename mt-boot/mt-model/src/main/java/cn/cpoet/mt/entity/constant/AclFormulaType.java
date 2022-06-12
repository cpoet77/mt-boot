package cn.cpoet.mt.entity.constant;

import cn.cpoet.mt.api.exception.EnumUndefinedException;
import cn.cpoet.mt.api.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.ebean.annotation.DbEnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * ACL表达式类型
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum AclFormulaType {
    /**
     * 纯文本
     */
    TEXT(1, "文本"),

    /**
     * Spring表达式
     */
    SPEL(1 << 1, "SPRING-EL"),

    /**
     * GROOVY脚本
     */
    GROOVY(1 << 2, "GROOVY脚本"),

    /**
     * 未定义
     */
    NONE(1 << 10, "未定义");

    @Getter(onMethod_ = {@DbEnumValue, @JsonValue})
    private final int code;
    private final String desc;

    @JsonCreator
    public static AclFormulaType ofCode(int code) {
        return EnumUtil.valueSafeOf(values(), AclFormulaType::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
