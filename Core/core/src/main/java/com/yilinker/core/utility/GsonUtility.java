package com.yilinker.core.utility;

import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/5/2015.
 */
public class GsonUtility {

    public static GsonBuilder createGsonBuilder(Type type, Object typeAdapter){
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping();
        gsonBuilder.registerTypeAdapter(type, typeAdapter);
        return gsonBuilder;
    }

}