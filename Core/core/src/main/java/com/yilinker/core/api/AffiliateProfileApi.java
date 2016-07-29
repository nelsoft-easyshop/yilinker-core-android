package com.yilinker.core.api;

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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adur Urbano on 2/18/2016.
 */
public class AffiliateProfileApi {

    public static Request setUpStore (final int requestCode, String token, String coverPhoto, String profilePhoto, String storeSlug,
                                      String storeName, String storeDescription, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN.replace("v1", "v2"), APIConstants.AUTH_API, APIConstants.STORE_SETUP_STORE, APIConstants.STORE_SETUP_SETUP);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        if (coverPhoto != null)
            params.put(APIConstants.PROFILE_COVER_PHOTO, coverPhoto);
        if (profilePhoto != null)
            params.put(APIConstants.PROFILE_PHOTO, profilePhoto);
        params.put(APIConstants.STORE_SETUP_SLUG, storeSlug);
        params.put(APIConstants.STORE_SETUP_NAME, storeName);
        params.put(APIConstants.STORE_SETUP_DESCRIPTION, storeDescription);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

//                gson = GsonUtility.createGsonBuilder(SetupStore.class, new SetupStore.SetupStoreInstance()).create();
//                String jsonString = new Gson().toJson(apiResponse.getData());
//                SetupStore obj = gson.fromJson(jsonString, SetupStore.class);

                responseHandler.onSuccess(requestCode, apiResponse);

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

                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        jsonObject = jsonObject.getJSONObject("data");
                        JSONArray var = jsonObject.getJSONArray("errors");
                        message = var.get(0).toString();

                    } catch ( Exception e ) {
                        //Handle a malformed json response
                    }

                } else if (error instanceof NetworkError) {
                    message = "Network Error.";
                } else if (error instanceof ParseError) {
                    message = "Parse error.";
                }
                responseHandler.onFailed(requestCode, message);
            }
        });

//        requestUpdateCart.setCookie("sessionId");
        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

}
