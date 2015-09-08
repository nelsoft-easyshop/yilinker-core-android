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
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.Transaction;
import com.yilinker.core.model.seller.TransactionList;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaybr_000 on 9/2/2015.
 */
public class SellerTransactionApi {

    static int socketTimeout = 300000;
    static RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    public static Request getTransactionList(final int requestCode, String accessToken, String type, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN,APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_API,
                APIConstants.ACCESS_TOKEN, accessToken, APIConstants.SELLER_TRANSACTION_PARAMS_TYPE, type);

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(TransactionList.class, new TransactionList.TransactionListInstance()).create();

                    String jsonString  = new Gson().toJson(apiResponse.getData());

                    TransactionList transactionList = gson.fromJson(jsonString, TransactionList.class);

                    responseHandler.onSuccess(requestCode, transactionList.getOrders());

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

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
        });

        request.setRetryPolicy(policy);

        return request;
    }


}
