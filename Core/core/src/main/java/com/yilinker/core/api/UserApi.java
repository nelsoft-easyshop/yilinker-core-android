package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Login;
import com.yilinker.core.model.Register;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by rlcoronado on 8/8/15.
 */
public class UserApi {

    public static Request register (final int requestCode, String firstName, String lastName, String email, String password, String referral, final ResponseHandler responseHandler){

        String url = String.format("%s/%s?%s=%s&%s=%s&%s=%s&%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.LOGIN_API,
                APIConstants.REG_PARAM_FIRSTNAME, firstName,
                APIConstants.REG_PARAM_LASTNAME, lastName,
                APIConstants.REG_PARAM_EMAIL, email,
                APIConstants.REG_PARAM_PASSWORD, password,
                APIConstants.REG_PARAM_REFERRAL, referral);

        JSONObject regParams = new JSONObject();
        try {
            regParams.put(APIConstants.REG_PARAM_FIRSTNAME,firstName);
            regParams.put(APIConstants.REG_PARAM_LASTNAME, lastName);
            regParams.put(APIConstants.REG_PARAM_EMAIL, email);
            regParams.put(APIConstants.REG_PARAM_PASSWORD, password);
            regParams.put(APIConstants.REG_PARAM_REFERRAL, referral);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Request request = new JsonObjectRequest(url, regParams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Register.class, new Register.RegisterInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Register obj = gson.fromJson(jsonString, Register.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return request;
    }

    public static Request login (final int requestCode, String grantType, String email, String password, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s?%s=%s&%s=%s&%s=%s&%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.USER_API, APIConstants.TOKEN_API,
                APIConstants.LOGIN_PARAM_CLIENT_ID, APIConstants.API_CLIENT_ID,
                APIConstants.LOGIN_PARAM_CLIENT_SECRET, APIConstants.API_CLIENT_SECRET,
                APIConstants.LOGIN_PARAM_GRANT_TYPE, grantType,
                APIConstants.LOGIN_PARAM_EMAIL, email,
                APIConstants.LOGIN_PARAM_PASSWORD, password);
        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Login obj = gson.fromJson(jsonString, Login.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return request;
    }
}
