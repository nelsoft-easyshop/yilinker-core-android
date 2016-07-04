package com.yilinker.core.parsing;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
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

        int layoutId = object.get(APIConstants.API_HOME_V2_LAYOUT_ID).getAsInt();
        String sectionTitle = object.get(APIConstants.API_HOME_V2_SECTION_TITLE).getAsString();
        boolean viewMoreAvailable = object.get(APIConstants.API_HOME_V2_VIEW_MORE_AVAILABLE).getAsBoolean();
        HomeTarget viewMoreTarget = getViewMoreTarget(object.get(APIConstants.API_HOME_V2_VIEW_MORE_TARGET).getAsJsonObject());

        List<HomeData> homeData = getHomeData(layoutId, object.getAsJsonArray(APIConstants.API_HOME_V2_DATA));

        switch (layoutId) {

            case 4:

                String remainingTime = null;

                if (object.get(APIConstants.API_HOME_V2_REMAINING_TIME) != null) {
                    remainingTime = object.get(APIConstants.API_HOME_V2_REMAINING_TIME).getAsString();
                }

                FlashHomeLayout flashLayout = new FlashHomeLayout();
                flashLayout.setRemainingTime(remainingTime);
                flashLayout.setLayoutId(layoutId);
                flashLayout.setSectionTitle(sectionTitle);
                flashLayout.setViewMoreAvailable(viewMoreAvailable);
                flashLayout.setViewMoreTarget(viewMoreTarget);
                flashLayout.setData(homeData);
                return flashLayout;

            default:

                HomeLayout defaultLayout = new HomeLayout();
                defaultLayout.setLayoutId(layoutId);
                defaultLayout.setSectionTitle(sectionTitle);
                defaultLayout.setViewMoreAvailable(viewMoreAvailable);
                defaultLayout.setViewMoreTarget(viewMoreTarget);
                defaultLayout.setData(homeData);
                return defaultLayout;

        }

    }

    private List<HomeData> getHomeData(int layoutId, JsonArray array) {

        List<HomeData> homeData = null;

        String jsonString = new Gson().toJson(array);
        Type listType = new TypeToken<ArrayList<HomeData>>(){}.getType();
        Gson gson;

        switch (layoutId) {

            case 1:

                gson = GsonUtility.createGsonBuilder(HomeData.class, new HomeData1.HomeData1Instance()).create();
                homeData = gson.fromJson(jsonString, listType);

                break;

        }


        return homeData;
    }

    private HomeTarget getViewMoreTarget(JsonObject targetObject) {

        Gson gson = GsonUtility.createGsonBuilder(HomeTarget.class, new HomeTarget.HomeTargetInstance()).create();
        HomeTarget target = gson.fromJson(targetObject.toString(), HomeTarget.class);

        return target;

    }


}
