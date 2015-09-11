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
import com.yilinker.core.model.TransactionDetails;
import com.yilinker.core.model.seller.Reason;
import com.yilinker.core.model.seller.TransactionList;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jaybr_000 on 9/2/2015.
 */
public class SellerTransactionApi {

    static int socketTimeout = 300000;
    static RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    public static Request getTransactionList(final int requestCode, String accessToken, String type, int page, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN,APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_LIST_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        if (type == null)
            endpoint = String.format("%s&%s=%s", endpoint, APIConstants.SELLER_TRANSACTION_LIST_PARAMS_TYPE, type);

        if (page > 0)
            endpoint = String.format("%s&%s=%s", endpoint, APIConstants.SELLER_TRANSACTION_LIST_PARAMS_PAGE, page);

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

    public static Request getTransaction(final int requestCode, String accessToken, String transactionId, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.SELLER_TRANSACTION_API, APIConstants.ACCESS_TOKEN, accessToken,
                APIConstants.SELLER_TRANSACTION_PARAMS_TRANSACTION_ID, transactionId);

        url = url.replace(" ", "%20");

        Request request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(TransactionDetails.class, new TransactionDetails.TransactionDetailsInstance()).create();
                    String jsonString = gson.toJson(apiResponse.getData());
                    TransactionDetails transactionDetails = gson.fromJson(jsonString, TransactionDetails.class);

                    responseHandler.onSuccess(requestCode, transactionDetails);

                } else {

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

    public static Request getCancellationReasons(final int requestCode, String accessToken, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.CANCELLATION_API, APIConstants.SELLER_TRANSACTION_REASONS_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

//                if (apiResponse.isSuccessful()) {
//
//                    gson = GsonUtility.createGsonBuilder(Reason.class, new Reason.ReasonsInstance()).create();
//                    String jsonString = gson.toJson(apiResponse.getData());
//                    Reason reason = gson.fromJson(jsonString, Reason.class);
//
//                    responseHandler.onSuccess(requestCode, reason);
//
//
//                } else {
//
//                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
//
//                }

                gson = GsonUtility.createGsonBuilder(Reason.class, new Reason.ReasonInstance()).create();
                String jsonString = gson.toJson(apiResponse.getData());
                Type listType = new TypeToken<ArrayList<Reason>>(){}.getType();
                List<Reason> reasons = gson.fromJson(jsonString, listType);

                responseHandler.onSuccess(requestCode, reasons);

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


    public static Request cancelTransactionRequest(final int requestCode, String accessToken, String transactionId,
                                                   String reasonId, String remark, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.TRANSACTION_API, APIConstants.SELLER_TRANSACTION_CANCEL_API);

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.SELLER_TRANSACTION_CANCEL_PARAMS_TRANSACTION_ID, transactionId);
        params.put(APIConstants.SELLER_TRANSACTION_CANCEL_PARAMS_REASON_ID, reasonId);
        params.put(APIConstants.SELLER_TRANSACTION_CANCEL_PARAMS_REMARK, remark);

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


    public static Request scheduleForPickup(final int requestCode, String accessToken, String transactionId,
                                            String pickupSchedule, String pickupRemark, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s&%s=%s&%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.TRANSACTION_API, APIConstants.SELLER_TRANSACTION_PICKUP_API,
                APIConstants.ACCESS_TOKEN, accessToken,
                APIConstants.SELLER_TRANSACTION_PICKUP_PARAMS_TRANSACTION_ID, transactionId,
                APIConstants.SELLER_TRANSACTION_PICKUP_PARAMS_PICKUP_SCHEDULE, pickupSchedule,
                APIConstants.SELLER_TRANSACTION_PICKUP_PARAMS_PICKUP_REMARK, pickupRemark);

        endpoint = endpoint.replaceAll(" ", "%20");

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
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
