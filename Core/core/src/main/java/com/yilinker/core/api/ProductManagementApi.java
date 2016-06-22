package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.Product;
import com.yilinker.core.model.seller.CategoryProductList;
import com.yilinker.core.model.seller.ProductList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bryan on 9/2/2015.
 */
public class ProductManagementApi {

    public static Request getProductList(final int requestCode, String token, int status, String keyword,
                                         final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.PRODUCT_MANAGEMENT_API,
                APIConstants.GET_PRODUCT_LIST);

        url = url.replace("v1","v3");

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        if (status != 10) {
            params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_STATUS, String.valueOf(status));
        } else {
            params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_STATUS, "all");
        }
        if (keyword != null && !keyword.isEmpty()) {
            params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_KEYWORD, keyword);
        }

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
                if (apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(ProductList.class, new ProductList.ProductListInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    ProductList obj = gson.fromJson(jsonString, ProductList.class);
                    responseHandler.onSuccess(requestCode, obj);
                } else {
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                sendErrorMessage(requestCode, error, responseHandler);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());


        return request;
    }

    public static Request editProductStatus (final int requestCode, String token, JSONArray productId, int status,
                                            final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.PRODUCT_MANAGEMENT_API, APIConstants.UPDATE_PRODUCT_STATUS,
                APIConstants.ACCESS_TOKEN, token);

        Map<String, String> params = new HashMap<String, String>();
//        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_PRODUCT_ID, productId.toString());
        params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_STATUS, String.valueOf(status));

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                }else{
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                sendErrorMessage(requestCode, error, responseHandler);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    private static void sendErrorMessage(int requestCode, VolleyError error, ResponseHandler responseHandler) {

        if (error.networkResponse != null) {
            if (error.networkResponse.statusCode == 400) {
                try {
                    String jsonString = new String(error.networkResponse.data,
                            HttpHeaderParser.parseCharset(error.networkResponse.headers));
                    Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                    APIResponse apiResponse = gson.fromJson(jsonString, APIResponse.class);
                    if (apiResponse != null) {
                        responseHandler.onFailed(requestCode, apiResponse.getMessage());
                    } else {
                        responseHandler.onFailed(requestCode, "Server Error.");
                    }
                    return;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        String message = "An error occured.";
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            message = "No connection available.";
        } else if (error instanceof AuthFailureError) {
            message = "Authentication Failure.";
        } else if (error instanceof ServerError) {
            message = "Server error.";
        } else if (error instanceof NetworkError) {
            message = "Network Error.";
        } else if (error instanceof ParseError) {
            message = "Parse error.";
        }

        responseHandler.onFailed(requestCode,message);

    }

}
