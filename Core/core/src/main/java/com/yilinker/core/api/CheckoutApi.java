package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.CheckoutPayment;
import com.yilinker.core.model.buyer.CheckoutTransactionOverview;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

/**
 * Created by rlcoronado on 8/20/15.
 */
public class CheckoutApi {

    public static Request payViaCod(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_COD,
                APIConstants.ACCESS_TOKEN, token);

        Request payUsingCod = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CheckoutPayment.class, new CheckoutPayment.CheckoutPaymentInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                CheckoutPayment obj = gson.fromJson(jsonString, CheckoutPayment.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof AuthFailureError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_AUTH_ERROR);
                } else if (error instanceof ServerError) {
                    //TODO
                }

            }
        });


        payUsingCod.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return payUsingCod;

    }

    public static Request payViaPesoPay(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_PESOPAY,
                APIConstants.ACCESS_TOKEN, token);

        Request payViaPesoPay = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CheckoutPayment.class, new CheckoutPayment.CheckoutPaymentInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                CheckoutPayment obj = gson.fromJson(jsonString, CheckoutPayment.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof AuthFailureError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_AUTH_ERROR);
                } else if (error instanceof ServerError) {
                    //TODO
                }

            }
        });


        payViaPesoPay.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return payViaPesoPay;

    }

    public static Request getCheckoutOverview(final int requestCode, String transactionId, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_OVERVIEW,
                APIConstants.ACCESS_TOKEN, token, APIConstants.CHECKOUT_PARAMS_TRANSACTION_ID, transactionId);

        Request getCheckoutOverview = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CheckoutTransactionOverview.class,
                        new CheckoutTransactionOverview.CheckoutTransactionOverviewInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                CheckoutTransactionOverview obj = gson.fromJson(jsonString, CheckoutTransactionOverview.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof AuthFailureError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_AUTH_ERROR);
                } else if (error instanceof ServerError) {
                    //TODO
                }

            }
        });


        getCheckoutOverview.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getCheckoutOverview;

    }
}
