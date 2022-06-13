package cn.cpoet.mt.core.auth;

import cn.cpoet.mt.api.auth.SubjectTypes;
import cn.cpoet.mt.api.constant.SystemConst;

/**
 * @author CPoet
 */
public class GuestSubject extends SystemSubject {
    public final static GuestSubject INSTANCE = new GuestSubject();

    @Override
    public Long getId() {
        return SystemConst.GUEST_ID;
    }

    @Override
    public SubjectTypes getType() {
        return SubjectTypes.GUEST;
    }
}
