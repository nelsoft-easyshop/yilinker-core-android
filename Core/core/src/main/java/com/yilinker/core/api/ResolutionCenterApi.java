package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Case;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 9/14/2015.
 */
public class ResolutionCenterApi {

    public static Request getCases(final int requestCode, String accessToken, String filter, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.RESOLUTION_CENTER_DISPUTE,APIConstants.RESOLUTION_CENTER_GET_CASES,APIConstants.ACCESS_TOKEN, accessToken);

        String finalUrl = endpoint;
        if (!filter.equals("")){
            finalUrl = String.format("%s&%s=%s",endpoint,APIConstants.RESOLUTION_CENTER_FILTER,filter);
        }

        Request request = new JsonObjectRequest(finalUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Case.class, new Case.CaseInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Type listType = new TypeToken<ArrayList<Case>>(){}.getType();

                    List<Case> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                }else{
                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        message = jsonObject.getString("message");

                    } catch ( JSONException e ) {
                        //Handle a malformed json response
                    } catch (UnsupportedEncodingException e){

                    }
                }
                responseHandler.onFailed(requestCode, message);
            }});

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

}
