package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.AuthenticatedOTP;
import com.yilinker.core.model.seller.BalanceRecord;
import com.yilinker.core.model.seller.WithdrawalRequest;
import com.yilinker.core.model.seller.WithdrawalRequestList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Patrick on 1/29/2016.
 */
public class PayoutApi {

    public static Request getBalanceRecordDetails(final int requestCode, String accessToken, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,APIConstants.BANK_API,
                APIConstants.PAYOUT_BALANCE_RECORD_DETAILS);

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.ACCESS_TOKEN,String.valueOf(accessToken));

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(BalanceRecord.class, new BalanceRecord.BalanceRecordInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                BalanceRecord obj = gson.fromJson(jsonString, BalanceRecord.class);

                if (apiResponse.isSuccessful()){

                    responseHandler.onSuccess(requestCode, obj);

                }else{
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_AUTHENTICATION_ERROR;

                }else{
                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        message = jsonObject.getString("message");

                    } catch ( JSONException e ) {
                        //Handle a malformed json response
                    } catch (UnsupportedEncodingException e){

                    }
                }
                responseHandler.onFailed(requestCode, message);
            }});


        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request getWithdrawalRequestList(final int requestCode, String accessToken,int page, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.PAYOUT_WITHDRAWAL_LIST);

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.ACCESS_TOKEN,String.valueOf(accessToken));
        params.put( APIConstants.SEARCH_PAGE, String.valueOf(page));

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(WithdrawalRequestList.class, new WithdrawalRequestList.WithdrawalRequestListInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                WithdrawalRequestList obj = gson.fromJson(jsonString, WithdrawalRequestList.class);

                if (apiResponse.isSuccessful()){

                    responseHandler.onSuccess(requestCode, obj);

                }else{
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_AUTHENTICATION_ERROR;

                }else{
                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        message = jsonObject.getString("message");

                    } catch ( JSONException e ) {
                        //Handle a malformed json response
                    } catch (UnsupportedEncodingException e){

                    }
                }
                responseHandler.onFailed(requestCode, message);
            }});


        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }


    public static Request getRequestCode(final int requestCode, String accessToken, String type, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,APIConstants.SMS_API,
                APIConstants.SEND);
        //TEMP for v2
        url = url.replace("v1","v2");

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.ACCESS_TOKEN,String.valueOf(accessToken));
        params.put(APIConstants.TYPE, type);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(AuthenticatedOTP.class, new AuthenticatedOTP.AuthenticatedOTPInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                AuthenticatedOTP obj = gson.fromJson(jsonString, AuthenticatedOTP.class);

                if (apiResponse.isSuccessful()){

                    responseHandler.onSuccess(requestCode, obj);

                }else{
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_AUTHENTICATION_ERROR;

                }else{
                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        message = jsonObject.getString("message");

                    } catch ( JSONException e ) {
                        //Handle a malformed json response
                    } catch (UnsupportedEncodingException e){

                    }
                }
                responseHandler.onFailed(requestCode, message);
            }});


        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request submitWithdrawalRequest(final int requestCode, String accessToken,String amount, String withdrawalMethod, String otp, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,APIConstants.PAYOUT_WITHDRAWAL_REQUEST);

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.ACCESS_TOKEN,String.valueOf(accessToken));
        params.put( APIConstants.PAYOUT_AMOUNT, amount);
        params.put( APIConstants.PAYOUT_WITHDRAWAL_METHOD, withdrawalMethod);
        params.put( APIConstants.PAYOUT_OTP, otp);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()){

                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());

                }else{
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_AUTHENTICATION_ERROR;

                }else{
                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        message = jsonObject.getString("message");

                    } catch ( JSONException e ) {
                        //Handle a malformed json response
                    } catch (UnsupportedEncodingException e){

                    }
                }
                responseHandler.onFailed(requestCode, message);
            }});


        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }
}
