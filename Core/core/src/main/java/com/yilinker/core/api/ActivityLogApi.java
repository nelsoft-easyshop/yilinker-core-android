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
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.ActivityLog;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

/**
 * Created by Adur Urbano on 9/7/2015.
 */
public class ActivityLogApi {

    public static Request getActivityLog(final int requestCode, String token,
                                         int pageNo, int perPage, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s&%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.PROFILE_API, APIConstants.ACTIVITY_LOG_GET_ITEMS,
                APIConstants.ACCESS_TOKEN, token,
                APIConstants.SEARCH_PAGE, String.valueOf(pageNo),
                APIConstants.SEARCH_PER_PAGE, String.valueOf(perPage));

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(ActivityLog.class, new ActivityLog.ActivityLogInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                ActivityLog obj = gson.fromJson(jsonString, ActivityLog.class);

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

        requestGetCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetCart;

    }

}