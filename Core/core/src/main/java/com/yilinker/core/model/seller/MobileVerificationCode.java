package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 8/23/2015.
 */
public class MobileVerificationCode {
    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class MobileVerificationCodeInstance implements InstanceCreator<MobileVerificationCode> {

        @Override
        public MobileVerificationCode createInstance(Type type) {

            return new MobileVerificationCode();
        }
    }
}
