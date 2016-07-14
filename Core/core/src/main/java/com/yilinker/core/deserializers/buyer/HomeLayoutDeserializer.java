package com.yilinker.core.deserializers.buyer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.yilinker.core.constants.HomeAPIConstants;
import com.yilinker.core.model.buyer.home.FlashHomeLayout;
import com.yilinker.core.model.buyer.home.HomeData;
import com.yilinker.core.model.buyer.home.HomeLayout;
import com.yilinker.core.utility.GsonUtility;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 7/4/16.
 */
public class HomeLayoutDeserializer implements JsonDeserializer<HomeLayout> {

    @Override
    public HomeLayout deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject object = json.getAsJsonObject();

        int layoutId = object.get(HomeAPIConstants.KEY_LAYOUT_ID).getAsInt();
        Gson gson = GsonUtility.createGsonBuilder(HomeData.class, new HomeDataDeserializer(layoutId)).create();

        switch (layoutId) {
            case 2:
                return gson.fromJson(json, FlashHomeLayout.class);
            default:
                return gson.fromJson(json, HomeLayout.class);
        }

    }

}
