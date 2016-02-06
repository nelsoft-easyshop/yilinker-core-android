package com.yilinker.core.responses;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by Jeico on 8/23/2015.
 */
public class EvImageAttachResp extends EvBaseResp
{
    @SerializedName("data")
    public Data data;

    public class Data
    {
        public String url;
        public String filesize;
    }

    public static class EvImageAttachRespInstance implements InstanceCreator<EvImageAttachResp> {

        @Override
        public EvImageAttachResp createInstance(Type type) {

            return new EvImageAttachResp();
        }
    }
}
