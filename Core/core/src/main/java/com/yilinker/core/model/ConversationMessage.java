package com.yilinker.core.model;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Jeico on 8/21/2015.
 */
public class ConversationMessage
{
    private Integer senderId;
    private Integer recipientId;
    private String message;
    private Integer isImage;
    private Integer isSeen;
    private Date timeSeen;
    private Date timeSent;

    public ConversationMessage()
    {
        // Do nothing
    }

    public ConversationMessage(Integer senderId, Integer recipientId, String message, Integer isImage, Integer isSeen, Date timeSeen, Date timeSent)
    {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.message = message;
        this.isImage = isImage;
        this.isSeen = isSeen;
        this.timeSeen = timeSeen;
        this.timeSent = timeSent;
    }

    public Integer getSenderId()
    {
        return senderId;
    }

    public void setSenderId(Integer senderId)
    {
        this.senderId = senderId;
    }

    public Integer getRecipientId()
    {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId)
    {
        this.recipientId = recipientId;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Integer getIsImage()
    {
        return isImage;
    }

    public void setIsImage(Integer isImage)
    {
        this.isImage = isImage;
    }

    public Integer getIsSeen()
    {
        return isSeen;
    }

    public void setIsSeen(Integer isSeen)
    {
        this.isSeen = isSeen;
    }

    public Date getTimeSeen()
    {
        return timeSeen;
    }

    public void setTimeSeen(Date timeSeen)
    {
        this.timeSeen = timeSeen;
    }

    public Date getTimeSent()
    {
        return timeSent;
    }

    public void setTimeSent(Date timeSent)
    {
        this.timeSent = timeSent;
    }

    /**
     * Sort by time sent
     */
    public static Comparator<ConversationMessage> sortTimeSentAsc = new Comparator<ConversationMessage>()
    {
        @Override
        public int compare(ConversationMessage lhs, ConversationMessage rhs)
        {
            Date lhsDate = lhs.getTimeSent();
            Date rhsDate = rhs.getTimeSent();

            return lhsDate.compareTo(rhsDate);
        }
    };
}
