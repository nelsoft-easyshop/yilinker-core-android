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
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.CustomizedCategory;
import com.yilinker.core.model.seller.Points;
import com.yilinker.core.model.seller.PointsDateAdded;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bryan on 9/7/2015.
 */
public class PointsApi {

    public static Request getPoints(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", BaseApplication.getDomainURL(),
                APIConstants.AUTH_API, APIConstants.USER_API, APIConstants.GET_POINTS);

        Map<String, String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper request =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

/*
                gson = GsonUtility.createGsonBuilder(Points.class, new Points.PointsInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Points obj = gson.fromJson(jsonString, Points.class);
*/

                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                }else{
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
                } else if (error instanceof NetworkError) {
                    message = "Network Error.";
                } else if (error instanceof ParseError) {
                    message = "Parse error.";
                }
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request getPointsHistory(final int requestCode, String token, int pageNo, int perPage, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", BaseApplication.getDomainURL(),
                APIConstants.AUTH_API, APIConstants.USER_API, APIConstants.GET_POINT_HISTORY);

        Map<String, String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.GET_POINTS_PARAMS_PAGE, String.valueOf(pageNo));
        params.put(APIConstants.GET_POINTS_PARAMS_PER_PAGE, String.valueOf(perPage));

        VolleyPostHelper request =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);


                gson = GsonUtility.createGsonBuilder(Points.class, new Points.PointsInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                JSONArray jsonObject = null;
                String json = null;
                try {
                    jsonObject = new JSONArray(jsonString);
                    json = jsonObject.getJSONObject(0).getJSONArray("points").toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Points[] obj = gson.fromJson(json, Points[].class);




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

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

}
