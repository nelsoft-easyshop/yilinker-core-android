package com.yilinker.core.deserializers.buyer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.yilinker.core.model.buyer.home.CategoryHomeData;
import com.yilinker.core.model.buyer.home.HomeData;
import com.yilinker.core.model.buyer.home.ImageHomeData;
import com.yilinker.core.model.buyer.home.ProductHomeData;
import com.yilinker.core.model.buyer.home.SellerHomeData;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 7/5/16.
 */
public class HomeDataDeserializer implements JsonDeserializer<HomeData> {

    private int layoutId;

    public HomeDataDeserializer(int layoutId) {

        this.layoutId = layoutId;

    }

    @Override
    public HomeData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();

        switch (layoutId) {
            case 1:
            case 2:
            case 3:
            case 6:
                return gson.fromJson(json, ImageHomeData.class);
            case 5:
            case 7:
            case 10:
                return gson.fromJson(json, ProductHomeData.class);
            case 8:
                return gson.fromJson(json, SellerHomeData.class);
            case 9:
                return gson.fromJson(json, CategoryHomeData.class);
            default:
                return gson.fromJson(json, HomeData.class);
        }

    }
}
