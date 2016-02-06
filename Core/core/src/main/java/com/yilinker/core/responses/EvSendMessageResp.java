package com.yilinker.core.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jeico on 8/22/2015.
 */
public class EvSendMessageResp extends EvBaseResp
{
    @SerializedName("data")
    public Data data;

    public class Data
    {
        public String sentTo;
        public String dateSent;
    }
}
