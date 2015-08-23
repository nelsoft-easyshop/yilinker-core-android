package com.yilinker.core.responses;

import com.google.gson.annotations.SerializedName;

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
}
