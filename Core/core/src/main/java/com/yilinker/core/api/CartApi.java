package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Cart;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adur Urbano on 8/9/2015.
 */
public class CartApi {

    public static Request getCart(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.CART_API, APIConstants.CART_GET_ITEMS,
                APIConstants.ACCESS_TOKEN, token);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Cart.class, new Cart.CartInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Cart obj = gson.fromJson(jsonString, Cart.class);

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

    public static Request getWishList(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.CART_API, APIConstants.CART_GET_ITEMS,
                APIConstants.ACCESS_TOKEN, token,
                APIConstants.WISH_LIST_GET_ITEMS, true);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Cart.class, new Cart.CartInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Cart obj = gson.fromJson(jsonString, Cart.class);

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

    public static Request updateCartItems (final int requestCode, String token, int productId, int unitId, int quantity, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.CART_API, APIConstants.CART_UPDATE_DETAILS);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.PRODUCT_GET_DETAILS_PARAM_ID, String.valueOf(productId));
        params.put(APIConstants.CART_UNIT_ID, String.valueOf(unitId));
        params.put(APIConstants.CART_QUANTITY, String.valueOf(quantity));

        VolleyPostHelper requestUpdateCart = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Cart.class, new Cart.CartInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Cart obj = gson.fromJson(jsonString, Cart.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestUpdateCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestUpdateCart;
    }

}