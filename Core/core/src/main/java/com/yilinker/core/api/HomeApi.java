package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.Home;
import com.yilinker.core.model.home.v2.HomeV2APIResponse;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeApi {

    public static Request getHomeDetails (final int requestCode, String id, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.HOME_API, APIConstants.HOME_GET_ITEMS);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Home.class, new Home.HomeInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Home obj = gson.fromJson(jsonString, Home.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    public static Request getHomeDataV2 (final int requestCode, final ResponseHandler responseHandler) {

        String url = "https://demo5885209.mockable.io/getHomeDataV2";

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

//                gson = GsonUtility.createGsonBuilder(Home.class, new Home.HomeInstance()).create();
//                String jsonString = new Gson().toJson(apiResponse.getData());
//                Home obj = gson.fromJson(jsonString, Home.class);

                gson = GsonUtility.createGsonBuilder(HomeV2APIResponse.class, new HomeV2APIResponse.HomeV2APIResponseInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Type listType = new TypeToken<ArrayList<HomeV2APIResponse>>(){}.getType();
                List<HomeV2APIResponse> obj = gson.fromJson(jsonString, listType);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }



}