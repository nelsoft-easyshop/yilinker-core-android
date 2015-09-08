package com.yilinker.core.api;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.MultiPartRequest;

import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.FollowedSeller;
import com.yilinker.core.model.Address;
import com.yilinker.core.model.Login;
import com.yilinker.core.model.Seller;
import com.yilinker.core.model.UpdateUserInfo;
import com.yilinker.core.model.seller.Bank;
import com.yilinker.core.model.seller.Followers;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.USER_API, APIConstants.SELLER_GET_STORE_INFO);

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.SELLER_USER_ID,String.valueOf(id));

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
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
    public static Request followSeller(final int requestCode, int id,String accessToken,String follow, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, "auth", follow);

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.SELLER_GET_DETAILS_PARAM_ID,String.valueOf(id));
        params.put(APIConstants.ACCESS_TOKEN, accessToken);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
//
//                gson = GsonUtility.createGsonBuilder(Seller.class, new Seller.SellerInstance()).create();
//                String jsonString = new Gson().toJson(apiResponse.getData());
//                Seller obj = gson.fromJson(jsonString, Seller.class);

                responseHandler.onSuccess(requestCode, apiResponse);

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

//    public static Request getSellerReview(final int requestCode, int id, final ResponseHandler responseHandler){
//
//        String url = String.format("%s/%s/%s?%s=%d", APIConstants.DOMAIN, APIConstants.SELLER_API, APIConstants.SELLER_GET_SELLER_REVIEWS, APIConstants.SELLER_GET_DETAILS_PARAM_ID, id);
//
//        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//
//                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
//                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
//
//                gson = GsonUtility.createGsonBuilder(ProductReview.class, new ProductReview.ProductReviewInstance()).create();
//                String jsonString = new Gson().toJson(apiResponse.getData());
//                ProductReview obj = gson.fromJson(jsonString, ProductReview.class);
//
//                responseHandler.onSuccess(requestCode, obj);
//            }
//
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
//
//            }
//        });
//
//        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
//        return request;
//
//    }

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

                gson = GsonUtility.createGsonBuilder(Bank.class, new Bank.BankInstance()).create();
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                String json = jsonObject.getJSONObject("bankAccount").toString();
                String json2 = jsonObject.getJSONObject("userAddress").toString();
                Bank bankAccount = gson.fromJson(json, Bank.class);
                Address address = gson.fromJson(json2, Address.class);
                obj.setAddress(address);
                obj.setBankAccount(bankAccount);
            } catch (JSONException e) {
                e.printStackTrace();
            }

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

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_GET_FOLLOWED_SELLERS);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.SELLER_PARAMS_PAGE, String.valueOf(page));
        params.put(APIConstants.SELLER_PARAMS_LIMIT, String.valueOf(limit));
        params.put(APIConstants.SELLER_PARAMS_KEYWORD, keyword);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(FollowedSeller.class, new FollowedSeller.FollowedSellerInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Type listType = new TypeToken<ArrayList<FollowedSeller>>(){}.getType();

                List<FollowedSeller> obj = gson.fromJson(jsonString, listType);


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

    public static Request changePasswordSeller (final int requestCode, String token, String oldPassword, String newPassword,
                                          String newPasswordConfirm, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.USER_API,
                APIConstants.CHANGE_PASSWORD_API,
                APIConstants.ACCESS_TOKEN, token);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.PROFILE_OLD_PASSWORD, oldPassword);
        params.put(APIConstants.PROFILE_NEW_PASSWORD, newPassword);
        params.put(APIConstants.PROFILE_NEW_PASSWORD_CONFIRMED, newPasswordConfirm);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof ServerError) {
                    responseHandler.onFailed(requestCode, "Wrong Email or Password");
                } else {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }



    public static Request getAllFollowers(final int requestCode, String token, int page, String keyword, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s&%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.MERCHANT_API, APIConstants.SELLER_GET_FOLLOWERS,
                APIConstants.ACCESS_TOKEN, token,
                APIConstants.SELLER_PARAMS_PAGE, page,
                APIConstants.SELLER_PARAMS_SEARCH_KEYWORD, keyword);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Followers.class, new Followers.FollowersInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Followers[] obj = gson.fromJson(jsonString, Followers[].class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestGetCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetCart;

    }

}