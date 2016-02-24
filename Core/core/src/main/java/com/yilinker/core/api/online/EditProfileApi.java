package com.yilinker.core.api.online;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bryan on 2/19/2016.
 */
public class EditProfileApi {

    public static Request sendVerificationEmail (final int requestCode, String accessToken, String email,
                                                 final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN.replace("v1","v2"), APIConstants.AUTH_API, APIConstants.AFFILIATE_API,
                APIConstants.VERIFY_EMAIL_API);


        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.REG_PARAM_EMAIL, email);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                } else {

                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        jsonObject = jsonObject.getJSONObject("data");
                        JSONArray var = jsonObject.getJSONArray("errors");
                        message = var.get(0).toString();

                    } catch ( Exception e ) {
                        //Handle a malformed json response
                    }
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }


    public static Request updateUserProfile (final int requestCode, String accessToken, String firstName,
                                             String lastName, String tin, String email, String referralCode,
                                             boolean isSent, String validId,
                                                 final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN.replace("v1","v2"), APIConstants.AUTH_API, APIConstants.AFFILIATE_API,
                APIConstants.UPDATE_USER_PROFILE_API);


        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.REG_PARAM_FIRST_NAME, firstName);
        params.put(APIConstants.REG_PARAM_LAST_NAME, lastName);
        params.put(APIConstants.EDIT_PROFILE_PARAM_TIN, tin);
        params.put(APIConstants.EDIT_PROFILE_PARAM_IS_SENT, String.valueOf(isSent));
        params.put(APIConstants.PROFILE_REFERRAL_CODE, referralCode);
        params.put(APIConstants.REG_PARAM_EMAIL, email);
        params.put(APIConstants.EDIT_PROFILE_PARAM_VALID_ID, validId);
        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                } else {

                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        jsonObject = jsonObject.getJSONObject("data");
                        JSONArray var = jsonObject.getJSONArray("errors");
                        message = var.get(0).toString();

                    } catch ( Exception e ) {
                        //Handle a malformed json response
                    }
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }
}
