package com.yilinker.core.api.online;

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
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.MultiPartRequest;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.UploadImage;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adur Urbano on 2/19/2016.
 */
public class UploadImageApi {

    public static Request uploadImage (final int requestCode, String token, File image, String type,
                                             final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s",
                APIConstants.DOMAIN.replace("v1", "v2"), APIConstants.AUTH_API, APIConstants.IMAGE, APIConstants.UPLOAD,
                APIConstants.ACCESS_TOKEN, token);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.TYPE, type);

        MultiPartRequest multiPartRequest = new MultiPartRequest(url, image.getPath(), APIResponse.class, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(UploadImage.class, new UploadImage.UploadImageInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                UploadImage obj = gson.fromJson(jsonString, UploadImage.class);

                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, obj);

                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

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
                        String responseBody = new String(error.networkResponse.data, "utf-8");
                        JSONObject jsonObject = new JSONObject(responseBody);
                        jsonObject = jsonObject.getJSONObject("data");
                        JSONArray var = jsonObject.getJSONArray("errors");
                        message = var.get(0).toString();

                    } catch (Exception e) {
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

        multiPartRequest.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return multiPartRequest;

    }

    public static Request uploadImageV2 (final int requestCode, String token, File image, String type,
                                       final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s",
                BaseApplication.getDomainURL(), APIConstants.AUTH_API, APIConstants.IMAGE, APIConstants.UPLOAD,
                APIConstants.ACCESS_TOKEN, token);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.TYPE, type);

        MultiPartRequest multiPartRequest = new MultiPartRequest(url, image.getPath(), APIResponse.class, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, apiResponse.getData());

                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        multiPartRequest.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return multiPartRequest;

    }

}
