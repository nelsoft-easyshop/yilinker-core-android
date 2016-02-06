package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Bryan on 10/6/2015.
 */
public class DisputeReasonList {

    private String key;
    private List<Reason> reasons;

    public DisputeReasonList(){}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Reason> getReasons() {
        return reasons;
    }

    public void setReasons(List<Reason> reasons) {
        this.reasons = reasons;
    }

    public static class DisputeReasonListInstance implements InstanceCreator<DisputeReasonList> {

        @Override
        public DisputeReasonList createInstance(Type type) {
            return new DisputeReasonList();
        }

    }
}
