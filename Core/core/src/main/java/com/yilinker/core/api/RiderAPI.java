package com.yilinker.core.api;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpStack;
import com.google.gson.Gson;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.constants.ErrorMessages;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Address;
import com.yilinker.core.model.Login;
import com.yilinker.core.model.express.internal.CashDetail;
import com.yilinker.core.model.express.internal.CashHistory;
import com.yilinker.core.model.express.internal.Rider;
import com.yilinker.core.model.OAuthentication;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by J.Bautista
 */
public class RiderAPI {

    /**
     *
     * @param requestCode
     * @param oAuth
     * @param responseHandler
     * @return
     */
    public static Request loginByUsername (final int requestCode, OAuthentication oAuth, final ResponseHandler responseHandler){

        String url = String.format("%s/%s",
                APIConstants.DOMAIN,
                APIConstants.RIDER_GET_TOKEN);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.LOGIN_PARAM_CLIENT_ID, oAuth.getClientId());
        params.put(APIConstants.LOGIN_PARAM_CLIENT_SECRET, oAuth.getClientSecret());
        params.put(APIConstants.LOGIN_PARAM_GRANT_TYPE, oAuth.getGrantType());
        params.put(APIConstants.LOGIN_PARAM_USERNAME, oAuth.getUsername());
        params.put(APIConstants.LOGIN_PARAM_PASSWORD, oAuth.getPassword());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                Login obj = gson.fromJson(response.toString(), Login.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof ServerError) {
                    responseHandler.onFailed(requestCode, "Wrong Email or Password");
                } else {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }

    /**
     *
     * @param requestCode
     * @param password
     * @param username
     * @param responseHandler
     * @return
     */
    public static Request logout (final int requestCode, String password, String username, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API,
                APIConstants.RIDER_LOGOUT);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.RIDER_LOGOUT_PARAM_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_LOGOUT_PARAM_USERNAME, username);
        params.put(APIConstants.RIDER_LOGOUT_PARAM_PASSWORD, password);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                Login obj = gson.fromJson(response.toString(), Login.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof ServerError) {
                    responseHandler.onFailed(requestCode, "Wrong Email or Password");
                } else {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }

    /**
     *
     * @param requestCode
     * @param oAuth
     * @param responseHandler
     * @return
     */
    public static Request refreshToken (final int requestCode, OAuthentication oAuth, final ResponseHandler responseHandler){

        String url = String.format("%s/%s",
                APIConstants.DOMAIN,
                APIConstants.RIDER_GET_TOKEN);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.LOGIN_PARAM_CLIENT_ID, oAuth.getClientId());
        params.put(APIConstants.LOGIN_PARAM_CLIENT_SECRET, oAuth.getClientSecret());
        params.put(APIConstants.LOGIN_PARAM_GRANT_TYPE, oAuth.getGrantType());
        params.put(APIConstants.LOGIN_PARAM_REFRESH_TOKEN, oAuth.getRefreshToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                Login obj = gson.fromJson(response.toString(), Login.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof ServerError) {
                    responseHandler.onFailed(requestCode, "Wrong Email or Password");
                } else {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }

    /**
     *
     * @param requestCode
     * @param responseHandler
     * @return
     */
    public static Request getRiderInfo(final int requestCode, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_GET_INFO);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_GET_INFO_PARAM_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(Address.class, new Rider.RiderInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Rider obj = gson.fromJson(jsonString, Rider.class);

                    responseHandler.onSuccess(requestCode, obj);
                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                int statusCode = error.networkResponse.statusCode;

                if(statusCode == HttpStatus.SC_UNAUTHORIZED){

                    responseHandler.onFailed(requestCode, ErrorMessages.ERR_EXPIRED_TOKEN);

                }
                else {

                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }

            }
        });

        return request;
    }

    /**
     *
     * @param requestCode
     * @param responseHandler
     * @return
     */
    public static Request getCashDetails (final int requestCode, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.RIDER_API,APIConstants.RIDER_GET_CASHDETAILS);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.RIDER_GET_CASHDETAILS_PARAM_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(Address.class, new CashDetail.CashDetailInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    CashDetail obj = gson.fromJson(jsonString, CashDetail.class);

                    responseHandler.onSuccess(requestCode, obj);
                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                int statusCode = error.networkResponse.statusCode;

                if(statusCode == HttpStatus.SC_UNAUTHORIZED){

                    responseHandler.onFailed(requestCode, ErrorMessages.ERR_EXPIRED_TOKEN);

                }
                else {

                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }

    /**
     * Request for accepting job order
     * @param requestCode
     * @param jobOrderNo
     * @param responseHandler
     * @return
     */
    public static Request acceptJobOrder(final int requestCode, String jobOrderNo ,final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_ACCEPT_JOB_ORDER);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_ACCEPT_JOB_ORDER_PARAM_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_ACCEPT_JOB_ORDER_PARAM_JONUMBER, jobOrderNo);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                }
                else{
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                int statusCode = error.networkResponse.statusCode;

                if(statusCode == HttpStatus.SC_UNAUTHORIZED){

                    responseHandler.onFailed(requestCode, ErrorMessages.ERR_EXPIRED_TOKEN);

                }
                else {

                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }

            }
        });

        return request;
    }


}
