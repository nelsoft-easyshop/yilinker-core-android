package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Profile;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

/**
 * Created by Adur Urbano on 8/26/2015.
 */
public class ProfileApi {

    public static Request getUserDetails(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.PRODUCT_API, APIConstants.PROFILE_GET_DETAILS,
                APIConstants.ACCESS_TOKEN, token);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Profile.class, new Profile.ProfileInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Profile obj = gson.fromJson(jsonString, Profile.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });


        requestGetCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetCart;

    }
}