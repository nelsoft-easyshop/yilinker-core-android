package com.yilinker.core.api.online;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.request.Feedback;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bryan on 3/17/2016.
 * Updated by J.Bautista - Changed the parameters of sendFeedback method
 */
public class SendFeedbackApi {

    public static Request sendFeedback (final int requestCode, Feedback feedback,
                                        final ResponseHandler responseHandler, Response.ErrorListener errorListener){

        String accessToken = BaseApplication.getInstance().getAccessToken();

        String url;
        if(!accessToken.isEmpty()) {

            url = String.format("%s/%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.MOBILE_FEEDBACK,
                    APIConstants.SEND_FEEDBACK_API);
        }else{

            url = String.format("%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.MOBILE_FEEDBACK,
                    APIConstants.SEND_FEEDBACK_API);
        }


        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_TITLE, feedback.getTitle());
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_DESCRIPTION, feedback.getDescription());
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_PHONE_MODEL, feedback.getPhoneModel());
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_OS_VERSION, feedback.getOsVersion());
        params.put(APIConstants.SEND_FEEDBACK_PARAMS_OS_NAME, feedback.getOsName());
        //TODO include user type

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()){

                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }


            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }
}
