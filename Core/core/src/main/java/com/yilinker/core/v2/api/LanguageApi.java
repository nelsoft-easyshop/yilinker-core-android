package com.yilinker.core.v2.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;
import com.yilinker.core.v2.model.countryselection.Language;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bryan on 4/18/2016.
 */
public class LanguageApi {

    public static Request getLanguage(final int requestCode, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s", APIConstants.DOMAIN.replace("v1","v3"), com.yilinker.core.v2.constants.APIConstants.LANGUAGE_API);

        Map<String, String> params = new HashMap<String,String>();

        VolleyPostHelper getLanguages =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Language.class, new Language.LanguageInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Language[] obj = gson.fromJson(jsonString, Language[].class);


                responseHandler.onSuccess(requestCode, obj);
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

        getLanguages.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getLanguages;
    }
}
