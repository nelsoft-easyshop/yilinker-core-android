package com.yilinker.core.model;

import java.util.Date;

/**
 * Created by Jeico on 8/21/2015.
 */
public class ConversationHead
{
    private Integer userId;
    private Integer isOnline;
    private Integer sender;
    private String profileImageUrl;
    private String fullName;
    private String lastMessage;
    private Integer hasUnreadMessage;
    private Date lastMessageDate;
    private Date lastLoginDate;

    public ConversationHead()
    {
        // Do nothing
    }

    public ConversationHead(Integer userId, Integer isOnline, Integer sender, String profileImageUrl, String fullName, String lastMessage, Integer hasUnreadMessage, Date lastMessageDate,
                            Date lastLoginDate)
    {
        this.userId = userId;
        this.isOnline = isOnline;
        this.sender = sender;
        this.profileImageUrl = profileImageUrl;
        this.fullName = fullName;
        this.lastMessage = lastMessage;
        this.hasUnreadMessage = hasUnreadMessage;
        this.lastMessageDate = lastMessageDate;
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getIsOnline()
    {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline)
    {
        this.isOnline = isOnline;
    }

    public Integer getSender()
    {
        return sender;
    }

    public void setSender(Integer sender)
    {
        this.sender = sender;
    }

    public String getProfileImageUrl()
    {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl)
    {
        this.profileImageUrl = profileImageUrl;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getLastMessage()
    {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage)
    {
        this.lastMessage = lastMessage;
    }

    public Integer getHasUnreadMessage()
    {
        return hasUnreadMessage;
    }

    public void setHasUnreadMessage(Integer hasUnreadMessage)
    {
        this.hasUnreadMessage = hasUnreadMessage;
    }

    public Date getLastMessageDate()
    {
        return lastMessageDate;
    }

    public void setLastMessageDate(Date lastMessageDate)
    {
        this.lastMessageDate = lastMessageDate;
    }

    public Date getLastLoginDate()
    {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate)
    {
        this.lastLoginDate = lastLoginDate;
    }
}
