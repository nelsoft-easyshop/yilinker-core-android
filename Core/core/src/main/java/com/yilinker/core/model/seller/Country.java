package com.yilinker.core.model.seller;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jaybryantc on 5/23/16.
 */
public class Country {

    @SerializedName("countryId")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;
    @SerializedName("image")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
