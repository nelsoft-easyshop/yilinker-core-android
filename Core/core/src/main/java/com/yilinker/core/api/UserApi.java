package com.yilinker.core.api;

import android.util.Log;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Login;
import com.yilinker.core.model.Register;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rlcoronado on 8/8/15.
 */
public class UserApi {

    public static Request register (final int requestCode, String firstName, String lastName, String email, String password, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
        APIConstants.DOMAIN, APIConstants.USER_API, APIConstants.REG_API);

        //test server
//        String url = "http://online.api.easydeal.ph/api/v1/user/register";

        String fullname = String.format("%s %s",firstName,lastName);
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.REG_PARAM_FULLNAME,fullname);
        params.put(APIConstants.REG_PARAM_EMAIL, email);
        params.put(APIConstants.REG_PARAM_PASSWORD, password);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                Register obj = gson.fromJson(response.toString(), Register.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
    });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request login (final int requestCode, String grantType, String email, String password, final ResponseHandler responseHandler){

        int socketTimeout = 5000;//5 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        String url = String.format("%s/%s?%s=%s&%s=%s&%s=%s&%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.LOGIN_API,
                APIConstants.LOGIN_PARAM_CLIENT_ID, APIConstants.API_CLIENT_ID,
                APIConstants.LOGIN_PARAM_CLIENT_SECRET, APIConstants.API_CLIENT_SECRET,
                APIConstants.LOGIN_PARAM_GRANT_TYPE, grantType,
                APIConstants.LOGIN_PARAM_EMAIL, email,
                APIConstants.LOGIN_PARAM_PASSWORD, password);

//        //To test server api
//        String url = String.format("%s?%s=%s&%s=%s&%s=%s&%s=%s&%s=%s",
//                "http://online.api.easydeal.ph/api/v1/login",
//                APIConstants.LOGIN_PARAM_CLIENT_ID, APIConstants.API_CLIENT_ID,
//                APIConstants.LOGIN_PARAM_CLIENT_SECRET, APIConstants.API_CLIENT_SECRET,
//                APIConstants.LOGIN_PARAM_GRANT_TYPE, grantType,
//                APIConstants.LOGIN_PARAM_EMAIL, email,
//                APIConstants.LOGIN_PARAM_PASSWORD, password);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
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
}
