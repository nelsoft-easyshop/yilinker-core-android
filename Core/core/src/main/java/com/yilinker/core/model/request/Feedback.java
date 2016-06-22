package com.yilinker.core.model.request;

/**
 * Created by J.Bautista on 6/21/16.
 */
public class Feedback {

    public enum UserType{

        USER_BUYER(0),
        USER_SELLER(1),
        USER_AFFILIATE(2);

        private final int userCode;

        private UserType(int userCode){

            this.userCode = userCode;
        }

        public int getValue(){
            return userCode;
        }

    }

    private int userType;
    private String title;
    private String description;
    private String phoneModel;
    private String osVersion;
    private String osName;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }
}
