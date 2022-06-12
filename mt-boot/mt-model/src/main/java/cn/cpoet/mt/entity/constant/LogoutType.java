package cn.cpoet.mt.entity.constant;

import cn.cpoet.mt.api.exception.EnumUndefinedException;
import cn.cpoet.mt.api.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.ebean.annotation.DbEnumValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 登出类型
 *
 * @author CPoet
 */
@Getter
@RequiredArgsConstructor
public enum LogoutType {
    /**
     * 自动退出，身份认证到期等
     */
    AUTO(1, "自动退出"),

    /**
     * 管理员强制
     */
    FORCE(2, "强制退出"),

    /**
     * 用户自行退出
     */
    MANUAL(3, "用户操作");

    @Getter(onMethod_ = {@DbEnumValue, @JsonValue})
    private final int code;
    private final String desc;

    @JsonCreator
    public static LogoutType ofCode(int code) {
        return EnumUtil.valueSafeOf(values(), LogoutType::getCode, code)
            .orElseThrow(() -> EnumUndefinedException.DEFAULT);
    }
}
