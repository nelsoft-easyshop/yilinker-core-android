package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Home;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeApi {

    public static Request getHomeDetails (final int requestCode, String id, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.SELLER_API, APIConstants.SELLER_GET_DETAILS);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(GsonUtility.convertJSONObjtoJsonObj(response), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Home.class, new Home.HomeInstance()).create();
                try {

                    JSONObject obj = new JSONObject(apiResponse.getData());

                    Home home = gson.fromJson(GsonUtility.convertJSONObjtoJsonObj(obj), Home.class);

                    responseHandler.onSuccess(requestCode, home);

                } catch (JSONException e) {

                    responseHandler.onFailed(requestCode, "Invalid data");
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return request;

    }

}