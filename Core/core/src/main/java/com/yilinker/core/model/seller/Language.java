package com.yilinker.core.model.seller;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 5/23/16.
 */
public class Language implements Parcelable {

    @SerializedName("languageId")
    private int id;
    @SerializedName("languageName")
    private String name;
    @SerializedName("languageCode")
    private String code;
    @SerializedName("countryId")
    private int countryId;
    @SerializedName("countryName")
    private String countryName;
    @SerializedName("countryCode")
    private String countryCode;
    @SerializedName("isSelected")
    private boolean selected;

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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public static class LanguageInstance implements InstanceCreator<Language> {

        @Override
        public Language createInstance(Type type) {
            return new Language();
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.code);
        dest.writeInt(this.countryId);
        dest.writeString(this.countryName);
        dest.writeString(this.countryCode);
        dest.writeByte(this.selected ? (byte) 1 : (byte) 0);
    }

    public Language() {
    }

    protected Language(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.code = in.readString();
        this.countryId = in.readInt();
        this.countryName = in.readString();
        this.countryCode = in.readString();
        this.selected = in.readByte() != 0;
    }

    public static final Creator<Language> CREATOR = new Creator<Language>() {
        @Override
        public Language createFromParcel(Parcel source) {
            return new Language(source);
        }

        @Override
        public Language[] newArray(int size) {
            return new Language[size];
        }
    };

}
