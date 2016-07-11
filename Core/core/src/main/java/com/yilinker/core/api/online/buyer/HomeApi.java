package com.yilinker.core.api.online.buyer;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.home.HomeLayout;
import com.yilinker.core.deserializers.buyer.HomeLayoutDeserializer;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaybryantc on 7/4/16.
 */
public class HomeApi {

    public static Request getHome (final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorListener) {

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.HOME_API, APIConstants.HOME_GET_ITEMS);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                String jsonString = new Gson().toJson(apiResponse.getData());
                Type listType = new TypeToken<ArrayList<HomeLayout>>(){}.getType();

                gson = GsonUtility.createGsonBuilder(HomeLayout.class, new HomeLayoutDeserializer()).create();

                List<HomeLayout> obj = gson.fromJson(jsonString, listType);

                responseHandler.onSuccess(requestCode, obj);

            }

        },errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

}
