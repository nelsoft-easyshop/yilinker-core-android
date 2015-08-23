package com.yilinker.core.responses;

import com.google.gson.annotations.SerializedName;
import com.yilinker.core.model.ConversationHead;

import java.util.List;

/**
 * Created by Jeico on 8/21/2015.
 */
public class EvGetConversationHeadResp extends EvBaseResp
{
    @SerializedName("data")
    public List<ConversationHead> conversationHeadList;
}
