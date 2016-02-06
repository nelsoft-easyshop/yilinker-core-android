package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
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
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.ManufacturerProduct;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jaybr_000 on 9/17/2015.
 */
public class ResellerApi {

    static int socketTimeout = 300000;
    static RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    public static Request getManufacurerProductList(final int requestCode, String accessToken, int categoryId, int page, String query, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.RESELLER_API, APIConstants.GET_MANUFACTURER_PRODUCTS_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        if (categoryId > 0) {

            endpoint = String.format("%s&%s=%s", endpoint, APIConstants.GET_MANUFACTURER_PRODUCTS_PARAMS_CATEGORY_ID, categoryId);

        }

        if (page > 0) {

            endpoint = String.format("%s&%s=%s", endpoint, APIConstants.GET_MANUFACTURER_PRODUCTS_PARAMS_PAGE, page);


        }

        if (query != null) {

            endpoint = String.format("%s&%s=%s", endpoint, APIConstants.GET_MANUFACTURER_PRODUCTS_PARAMS_QUERY, query);

        }

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ManufacturerProduct.class, new ManufacturerProduct.ManufacturerProductInstance()).create();
                    Type listType = new TypeToken<ArrayList<ManufacturerProduct>>(){}.getType();
                    List<ManufacturerProduct> manufacturerProduct = gson.fromJson(gson.toJson(apiResponse.getData()), listType);

                    responseHandler.onSuccess(requestCode, manufacturerProduct);

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

        request.setRetryPolicy(policy);

        return request;
    }

    public static Request upload(final int requestCode, String accessToken ,ArrayList<Integer> productIds, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.RESELLER_API,
                APIConstants.RESELLER_UPLOAD_API);

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);

        for (int i = 0; i < productIds.size(); i++) {

            params.put(String.format("productIds[%d]",i), String.valueOf(productIds.get(i)));

        }

        Request request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, apiResponse);

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

        request.setRetryPolicy(policy);

        return request;
    }


    private static void sendErrorMessage(int requestCode, VolleyError error, ResponseHandler responseHandler) {

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

        responseHandler.onFailed(requestCode, message);

    }


}
