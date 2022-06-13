package cn.cpoet.mt.model.constant;

import cn.cpoet.mt.api.exception.EnumUndefinedException;
import cn.cpoet.mt.api.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.ebean.annotation.DbEnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 比较式
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum AclFormulaSymbol {
    /**
     * 等于
     */
    EQ(1),

    /**
     * 小于
     */
    LT(2),

    /**
     * 大于
     */
    GT(3),

    /**
     * 小于等于
     */
    LE(4),

    /**
     * 大于
     */
    GE(5),

    /**
     * 包含
     */
    IN(6);

    @Getter(onMethod_ = {@JsonValue, @DbEnumValue})
    private final int code;

    @JsonCreator
    private static AclFormulaSymbol ofCode(int code) {
        return EnumUtil.valueSafeOf(values(), AclFormulaSymbol::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
