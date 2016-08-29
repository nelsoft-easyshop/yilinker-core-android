package com.yilinker.core.deserializers.buyer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.HomeAPIConstants;
import com.yilinker.core.model.buyer.home.FlashHomeLayout;
import com.yilinker.core.model.buyer.home.HomeData;
import com.yilinker.core.model.buyer.home.HomeLayout;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
            case 4:
                return gson.fromJson(json, FlashHomeLayout.class);
            case 12:
                HomeLayout<HomeLayout<HomeData>> homeLayout = gson.fromJson(object.toString(), new TypeToken<HomeLayout<HomeLayout<HomeData>>>(){}.getType());
                setPromoData(object,homeLayout);
                return homeLayout;
            default:
                return gson.fromJson(json, new TypeToken<HomeLayout<HomeData>>(){}.getType());
        }

    }

    private void setPromoData(JsonObject object, HomeLayout<HomeLayout<HomeData>> homeLayout) {

        JsonArray array = object.get("data").getAsJsonArray();
        List<HomeLayout<HomeData>> homeData = new ArrayList<>();
        for (JsonElement element : array) {
            int layoutId = element.getAsJsonObject().get(HomeAPIConstants.KEY_LAYOUT_ID).getAsInt();
            Gson gson = GsonUtility.createGsonBuilder(HomeData.class, new HomeDataDeserializer(layoutId)).create();
            homeData.add((HomeLayout<HomeData>) gson.fromJson(element, new TypeToken<HomeLayout<HomeData>>() {}.getType()));
        }
        homeLayout.setData(homeData);

    }


}
