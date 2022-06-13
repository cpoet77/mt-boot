package cn.cpoet.mt.entity.constant;

import cn.cpoet.mt.api.exception.EnumUndefinedException;
import cn.cpoet.mt.api.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.ebean.annotation.DbEnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 用户组类型
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum GroupType {
    /**
     * 普通组
     */
    GROUP(1, "普通组"),

    /**
     * 组织
     */
    ORGANIZATION(2, "组织"),

    /**
     * 单位
     */
    UNIT(3, "单位"),

    /**
     * 部门
     */
    DEPARTMENT(4, "部门");

    @Getter(onMethod_ = {@DbEnumValue, @JsonValue})
    private final int code;
    private final String name;

    @JsonCreator
    public static GroupType ofCode(int code) {
        return EnumUtil.valueSafeOf(values(), GroupType::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
