package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bryan on 8/14/2015.
 */
public class MobileVerificationApi {

    public static Request requestVerificationCode (final int requestCode, String token, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.ACCESS_TOKEN, APIConstants.AUTH_API, APIConstants.GET_CODE);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper requestVerificationCode = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestVerificationCode.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestVerificationCode;
    }

    public static Request requestVerifyCode (final int requestCode, String token, String code, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.ACCESS_TOKEN, APIConstants.AUTH_API, APIConstants.VERIFY);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.VERIFY_PARAM_VERIFICATION_CODE, String.valueOf(code));

        VolleyPostHelper requestVerificationCode = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                }
                else{


                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestVerificationCode.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestVerificationCode;
    }
}
