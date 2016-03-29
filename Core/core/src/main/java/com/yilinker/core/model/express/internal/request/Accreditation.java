package com.yilinker.core.model.express.internal.request;

import java.util.List;

/**
 * Created by J.Bautista on 3/18/16.
 */
public class Accreditation {

    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;
    private String requirements;
    private List<String> images;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRequirements() {
        return requirements;
    }

    /***
     * @param requirements JSON Array string in this format: ["id":"", "data":[""]]
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}

