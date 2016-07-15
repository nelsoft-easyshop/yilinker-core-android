package com.yilinker.core.api.online;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.FollowedSeller;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by J.Bautista on 7/15/16.
 */
public class FollowingAPI {

    public static Request getFollowedSellers(final int requestCode, com.yilinker.core.model.request.FollowedSeller model, final ResponseHandler responseHandler, Response.ErrorListener errorListener){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_GET_FOLLOWED_SELLERS);


        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken());
        params.put(APIConstants.SELLER_PARAMS_PAGE, String.valueOf(model.getPage()));
        params.put(APIConstants.SELLER_PARAMS_LIMIT, String.valueOf(model.getLimit()));
        params.put(APIConstants.SELLER_PARAMS_KEYWORD, model.getKeyword());


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(FollowedSeller.class, new FollowedSeller.FollowedSellerInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Type listType = new TypeToken<ArrayList<FollowedSeller>>(){}.getType();

                List<FollowedSeller> obj = gson.fromJson(jsonString, listType);


                responseHandler.onSuccess(requestCode, obj);

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }
}
