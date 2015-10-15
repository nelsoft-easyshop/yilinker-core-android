package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyErrorHelper;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Jeico on 8/14/2015.
 */
public class DeviceApi
{
    private static final Logger logger = Logger.getLogger(DeviceApi.class.getSimpleName());

    // Request Codes
    public static final int RC_ADD_REGISTRATION_ID = 1100;
    public static final int RC_DELETE_REGISTRATION_ID = 1101;
    public static final int RC_UPDATE_REGISTRATION_ID = 1102;

    /**
     * This method creates a request that will add registration id that is
     * associated with the user
     * @param accessToken
     * @param registrationId
     * @param handler
     * @return
     */
    public static Request addRegistrationId(String accessToken, String registrationId, final ResponseHandler handler)
    {
        // Build endpoint
        String endpoint = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.DEVICE_API, APIConstants.ADD_REGISTRATION_ID);

        // Build request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.DEVICE_PARAM_ACCESS_TOKEN, accessToken);
        params.put(APIConstants.DEVICE_PARAM_REGISTRATION_ID, registrationId);
        params.put(APIConstants.DEVICE_TYPE, String.valueOf(0));

        // Build request
        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                handler.onSuccess(RC_ADD_REGISTRATION_ID, response);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                handler.onFailed(RC_ADD_REGISTRATION_ID, VolleyErrorHelper.getErrorType(BaseApplication.getInstance().getApplicationContext(), error));
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    /**
     * This method creates a request that will delete registration id that is
     * associated with the user
     * @param accessToken
     * @param registrationId
     * @param handler
     * @return
     */
    public static Request deleteRegistrationId(String accessToken, String registrationId, final ResponseHandler handler)
    {
        // Build endpoint
        String endpoint = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.DEVICE_API, APIConstants.DELETE_REGISTRATION_ID);

        // Build request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.DEVICE_PARAM_ACCESS_TOKEN, accessToken);
        params.put(APIConstants.DEVICE_PARAM_REGISTRATION_ID, registrationId);

        // Build request
        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                handler.onSuccess(RC_DELETE_REGISTRATION_ID, null);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                handler.onFailed(RC_DELETE_REGISTRATION_ID, null);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    /**
     * This method creates a request that will update registration id that is associated with the user
     * @param accessToken
     * @param oldRegistrationId
     * @param newRegistrationId
     * @param isIdle
     * @param handler
     * @return
     */
    public static Request updateRegistrationId(String accessToken, String oldRegistrationId,
            String newRegistrationId, boolean isIdle, final ResponseHandler handler)
    {
        // Build endpoint
        String endpoint = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.DEVICE_API, APIConstants.UPDATE_REGISTRATION_ID);

        // Build request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.DEVICE_PARAM_ACCESS_TOKEN, accessToken);
        params.put(APIConstants.DEVICE_PARAM_OLD_REGISTRATION_ID, oldRegistrationId);
        params.put(APIConstants.DEVICE_PARAM_NEW_REGISTRATION_ID, newRegistrationId);
        params.put(APIConstants.DEVICE_IS_IDLE, String.valueOf(isIdle));

        // Build request
        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                handler.onSuccess(RC_UPDATE_REGISTRATION_ID, null);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                handler.onFailed(RC_UPDATE_REGISTRATION_ID, null);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }
}
