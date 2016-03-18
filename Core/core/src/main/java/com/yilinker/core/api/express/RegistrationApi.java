package com.yilinker.core.api.express;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.constants.ErrorMessages;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Address;
import com.yilinker.core.model.express.internal.CashDetail;
import com.yilinker.core.model.express.internal.JobOrder;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Patrick on 3/9/2016.
 */
public class RegistrationApi {

    public static Request getVerificationCode (final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler ) {

        String url = String.format("%s/%s/",
                APIConstants.DOMAIN,
                APIConstants.RIDER_API);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    responseHandler.onSuccess(requestCode, jsonString);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }

    public static Request verifyCode (final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler ) {

        String url = String.format("%s/%s/",
                APIConstants.DOMAIN,
                APIConstants.RIDER_API);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    responseHandler.onSuccess(requestCode, jsonString);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }


    public static Request submitRegistration (final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler ) {

        String url = String.format("%s/%s/",
                APIConstants.DOMAIN,
                APIConstants.RIDER_API);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    responseHandler.onSuccess(requestCode, jsonString);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }

}
