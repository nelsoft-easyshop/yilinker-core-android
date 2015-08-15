package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Cart;
import com.yilinker.core.model.StoreAddress;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 8/14/2015.
 */
public class StoreAddressApi {

    public static Request addStoreAddress (final int requestCode, String token, String addressTitle,
                                           String addressLine1, String addressLine2, String additionalInfo, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.STORE_ADDRESS, APIConstants.STORE_ADDRESS_ADD);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_TITLE, String.valueOf(addressTitle));
        params.put(APIConstants.ADDRESS_LINE1, String.valueOf(addressLine1));
        params.put(APIConstants.ADDRESS_LINE2, String.valueOf(addressLine2));
        params.put(APIConstants.ADDRESS_ADDITIONAL_INFO, String.valueOf(additionalInfo));

        VolleyPostHelper requestAddStoreAddress = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(StoreAddress.class, new StoreAddress.StoreAddressInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                StoreAddress obj = gson.fromJson(jsonString, StoreAddress.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestAddStoreAddress.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestAddStoreAddress;
    }
}
