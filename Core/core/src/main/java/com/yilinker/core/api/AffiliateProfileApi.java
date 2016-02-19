package com.yilinker.core.api;

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
import com.yilinker.core.model.seller.SetupStore;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adur Urbano on 2/18/2016.
 */
public class AffiliateProfileApi {

    public static Request setUpStore (final int requestCode, String token, String storeSlug,
                                      String storeName, String storeDescription, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.STORE_SETUP_STORE, APIConstants.STORE_SETUP_SETUP);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.STORE_SETUP_SLUG, storeSlug);
        params.put(APIConstants.STORE_SETUP_NAME, storeName);
        params.put(APIConstants.STORE_SETUP_DESCRIPTION, storeDescription);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(SetupStore.class, new SetupStore.SetupStoreInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                SetupStore obj = gson.fromJson(jsonString, SetupStore.class);

                responseHandler.onSuccess(requestCode, obj);

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
                        JSONArray errors = jsonObject.getJSONArray("errors");
                        message = errors.getString(0);

                    } catch ( JSONException e ) {
                        //Handle a malformed json response
                    } catch (UnsupportedEncodingException e){

                    }
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

//        requestUpdateCart.setCookie("sessionId");
        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

}
