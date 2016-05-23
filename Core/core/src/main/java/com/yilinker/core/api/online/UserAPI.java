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
import com.yilinker.core.model.Login;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by J.Bautista on 5/11/16.
 */
public class UserAPI {

    /**
     * API key email also accept mobile number value
     * @param requestCode
     * @param responseHandler
     * @param errorListener
     * @return
     */
    public static Request login (final int requestCode, com.yilinker.core.model.request.Login login, final ResponseHandler responseHandler, final Response.ErrorListener errorListener){

        String url = String.format("%s/%s",
                BaseApplication.getDomainURL(),
                APIConstants.LOGIN_API);

//        //TODO Add setting of language and country code in the app project
//        String url = String.format("%s/v3/EN/PH/%s",
//                BaseApplication.getDomainURL(),
//                APIConstants.LOGIN_API);
//
//        url = url.replace("/v1", "");

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.LOGIN_PARAM_CLIENT_ID, login.getClientId());
        params.put(APIConstants.LOGIN_PARAM_CLIENT_SECRET, login.getClientSecret());
        params.put(APIConstants.LOGIN_PARAM_GRANT_TYPE, login.getGrantType());
        params.put(APIConstants.LOGIN_PARAM_EMAIL, login.getLoginId());
        params.put(APIConstants.LOGIN_PARAM_PASSWORD, login.getPassword());


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                Login obj = gson.fromJson(response.toString(), Login.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }
}
