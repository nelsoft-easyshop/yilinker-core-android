package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Cart;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONException;
import org.json.JSONObject;

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

            }
        });

        return requestGetCart;

    }

    public static Request updateCartItems (final int requestCode, String token, int productId, int unitId, int quantity, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s?%s=%s&%s=%s&%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.CART_API, APIConstants.CART_GET_ITEMS,
                APIConstants.ACCESS_TOKEN, token,
                APIConstants.PRODUCT_GET_DETAILS_PARAM_ID, productId,
                APIConstants.CART_UNIT_ID, unitId,
                APIConstants.CART_QUANTITY, quantity);

        JSONObject regParams = new JSONObject();
        try {
            regParams.put(APIConstants.ACCESS_TOKEN, token);
            regParams.put(APIConstants.PRODUCT_GET_DETAILS_PARAM_ID, productId);
            regParams.put(APIConstants.CART_UNIT_ID, unitId);
            regParams.put(APIConstants.CART_QUANTITY, quantity);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Request requestUpdateCart = new JsonObjectRequest(url, regParams, new Response.Listener<JSONObject>() {
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

            }
        });
        return requestUpdateCart;
    }

}