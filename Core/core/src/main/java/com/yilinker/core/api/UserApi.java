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

import org.json.JSONObject;

import java.util.List;

/**
 * Created by rlcoronado on 8/8/15.
 */
public class UserApi {

    public static Request Register (final int requestCode, JSONObject obj, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.USER_API, APIConstants.REG_API);

        Request request = new JsonObjectRequest(url, obj, new Response.Listener<JSONObject>() {
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

    public static Request Login (final int requestCode, JSONObject obj, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.USER_API, APIConstants.TOKEN_API);

        Request request = new JsonObjectRequest(url, obj, new Response.Listener<JSONObject>() {
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
