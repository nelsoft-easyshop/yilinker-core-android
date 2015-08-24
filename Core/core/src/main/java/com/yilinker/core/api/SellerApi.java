package com.yilinker.core.api;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.MultiPartRequest;

import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.FollowedSellers;
import com.yilinker.core.model.Seller;
import com.yilinker.core.model.UpdateUserInfo;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class SellerApi {

    static int socketTimeout = 300000;
    static RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    public static Request getSellerDetails(final int requestCode, int id, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%d", APIConstants.DOMAIN, APIConstants.SELLER_API, APIConstants.SELLER_GET_DETAILS, APIConstants.SELLER_GET_DETAILS_PARAM_ID, id);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);


                gson = GsonUtility.createGsonBuilder(Seller.class, new Seller.SellerInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Seller obj = gson.fromJson(jsonString, Seller.class);

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

    public static Request getStoreInfo (final int requestCode, String token,  final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.STORE_INFO_MERCHANT,
                APIConstants.GET_STORE_INFO);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
        Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
        APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

        gson = GsonUtility.createGsonBuilder(UpdateUserInfo.class, new UpdateUserInfo.UpdateUserInfoInstance()).create();
        String jsonString = new Gson().toJson(apiResponse.getData());
        UpdateUserInfo obj = gson.fromJson(jsonString, UpdateUserInfo.class);
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


    public static Request updateStoreInfo(final int requestCode, UpdateUserInfo updateUserInfo, String accessToken, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.STORE_INFO_MERCHANT, APIConstants.UPDATE_STORE_INFO_API);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.STORE_NAME_PARAM, String.valueOf(updateUserInfo.getStoreName()));
        params.put(APIConstants.STORE_DESCRIPTION_PARAM, String.valueOf(updateUserInfo.getStoreDescription()));

        JSONObject jsonObject = new JSONObject(params);
        String stringJSON = jsonObject.toString();

        StringBuilder stringBuilder = new StringBuilder();

        for(String key:params.keySet()) {
            stringBuilder.append(key+"="+params.get(key)+"&");
        }

        url = String.format("%s?%s=%s",url,"access_token", accessToken);

        MultiPartRequest multiPartRequest = new MultiPartRequest(url,updateUserInfo, APIResponse.class,params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                    responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                responseHandler.onFailed(requestCode,APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        multiPartRequest.setRetryPolicy(policy);

        return multiPartRequest;
    }

    public static Request getFollowedSellers(final int requestCode, String token, int page, int limit, String keyword, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_GET_FOLLOWED_SELLERS,
                APIConstants.ACCESS_TOKEN, token);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.SELLER_PARAMS_PAGE, String.valueOf(page));
        params.put(APIConstants.SELLER_PARAMS_LIMIT, String.valueOf(limit));
        params.put(APIConstants.SELLER_PARAMS_KEYWORD, keyword);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(FollowedSellers.class, new FollowedSellers.FollowedSellersInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                FollowedSellers obj = gson.fromJson(jsonString, FollowedSellers.class);

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