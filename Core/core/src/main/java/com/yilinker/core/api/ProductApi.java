package com.yilinker.core.api;

import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.BuildConfig;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Product;
import com.yilinker.core.model.ProductReview;
import com.yilinker.core.model.ProductUpload;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class ProductApi {

    public static Request getProductDetails(final int requestCode, int id, final ResponseHandler responseHandler) {

        int socketTimeout = 5000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        String url = String.format("%s/%s/%s?%s=%d", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_GET_DETAILS, APIConstants.PRODUCT_GET_DETAILS_PARAM_ID, id);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse<Product> apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Product.class, new Product.ProductInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Product obj = gson.fromJson(jsonString, Product.class);

                responseHandler.onSuccess(requestCode, obj);


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);

            }
        });

        request.setRetryPolicy(policy);
        return request;

    }

    public static Request getProductReview(final int requestCode, int id, final ResponseHandler responseHandler){

        int socketTimeout = 5000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        String url = String.format("%s/%s/%s?%s=%d", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_GET_REVIEW, APIConstants.PRODUCT_GET_REVIEW_PARAM_ID, id);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(ProductReview.class, new ProductReview.ProductReviewInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                ProductReview obj = gson.fromJson(jsonString, ProductReview.class);

                responseHandler.onSuccess(requestCode, obj);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);

            }
        });

        request.setRetryPolicy(policy);
        return request;

    }

    public static Request uploadProduct(final int requestCode, String token, final ResponseHandler responseHandler) {

        int socketTimeout = 5000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        String url = String.format("%s/%s/%s",APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_UPLOAD_API);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);

            }
        });

        request.setRetryPolicy(policy);

        return request;
    }

}