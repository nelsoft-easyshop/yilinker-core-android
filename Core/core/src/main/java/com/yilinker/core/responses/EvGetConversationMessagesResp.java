package com.yilinker.core.responses;

import com.google.gson.annotations.SerializedName;
import com.yilinker.core.model.ConversationMessage;

import java.util.List;

/**
 * Created by Jeico on 8/21/2015.
 */
public class EvGetConversationMessagesResp extends EvBaseResp
{
    @SerializedName("data")
    public List<ConversationMessage> conversationMessageList;
}
