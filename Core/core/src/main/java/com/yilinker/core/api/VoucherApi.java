package com.yilinker.core.api;

import android.support.v4.app.NavUtils;

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
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.Voucher;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by jaybr_000 on 11/23/2015.
 */
public class VoucherApi {

    public static Request addVoucher(final int requestCode, String accessToken, String voucherCode, final ResponseHandler responseHandler) {

        String endpoint = null;

        if (accessToken == null) {
            endpoint = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN.replace("v1", "v2"), APIConstants.CART_API,
                    APIConstants.APPLY_VOUCHER_API,
                    APIConstants.APPLY_VOUCHER_PARAMS_VOUCHER_CODE, voucherCode);
        } else {
            endpoint = String.format("%s/%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN.replace("v1", "v2"), APIConstants.AUTH_API,
                    APIConstants.CART_API, APIConstants.APPLY_VOUCHER_API,
                    APIConstants.ACCESS_TOKEN, accessToken,
                    APIConstants.APPLY_VOUCHER_PARAMS_VOUCHER_CODE, voucherCode);
        }

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Voucher.class, new Voucher.VoucherInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Voucher voucher = gson.fromJson(jsonString, Voucher.class);

                    responseHandler.onSuccess(requestCode, voucher);

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

    private static void sendErrorMessage(int requestCode, VolleyError error, ResponseHandler responseHandler) {

        String message = "An error occured.";

        if (error != null && error.networkResponse.statusCode == 400) {
            try {
                String jsonString = new String(error.networkResponse.data,
                        HttpHeaderParser.parseCharset(error.networkResponse.headers));
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(jsonString, APIResponse.class);
                if (apiResponse != null) {
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                } else {
                    responseHandler.onFailed(requestCode,"Server Error.");
                }
                return;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

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
