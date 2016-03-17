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
 * Created by bryan on 3/17/2016.
 */
public class SendFeedbackApi {

    public static Request sendFeedback (final int requestCode, String accessToken, String title,
                                             String description, String phoneModel, String osVersion, String osName,
                                             final ResponseHandler responseHandler){

        String url;
                if(!accessToken.isEmpty()) {
                    url = String.format("%s/%s/%s/%s",
                            APIConstants.DOMAIN.replace("v1", "v2"), APIConstants.AUTH_API, APIConstants.MOBILE_FEEDBACK,
                            APIConstants.SEND_FEEDBACK_API);
                }else{
                    url = String.format("%s/%s/%s",
                            APIConstants.DOMAIN.replace("v1", "v2"), APIConstants.MOBILE_FEEDBACK,
                            APIConstants.SEND_FEEDBACK_API);
                }


        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_TITLE, title);
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_DESCRIPTION, description);
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_PHONE_MODEL, phoneModel);
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_OS_VERSION, osVersion);
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_OS_NAME, osName);

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
                        JSONArray var = jsonObject.getJSONArray("error");
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
