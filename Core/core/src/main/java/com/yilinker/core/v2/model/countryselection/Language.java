package com.yilinker.core.v2.model.countryselection;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 4/18/2016.
 */
public class Language {

    private int languageId;
    private String name;
    private String code;

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
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

    public static class LanguageInstance implements InstanceCreator<Language> {

        @Override
        public Language createInstance(Type type) {
            return new Language();
        }
    }
}
