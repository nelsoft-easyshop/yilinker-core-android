package com.yilinker.core.model;

/**
 * Created by Jeico on 8/21/2015.
 */
public class Contact
{
    private Integer userId;
    private String fullName;
    private String profileImageUrl;
    private Integer isOnline;

    public Contact()
    {
        // Do nothing
    }

    public Contact(Integer userId, String fullName, String profileImageUrl, Integer isOnline)
    {
        this.userId = userId;
        this.fullName = fullName;
        this.profileImageUrl = profileImageUrl;
        this.isOnline = isOnline;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getProfileImageUrl()
    {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl)
    {
        this.profileImageUrl = profileImageUrl;
    }

    public Integer getIsOnline()
    {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline)
    {
        this.isOnline = isOnline;
    }
}
