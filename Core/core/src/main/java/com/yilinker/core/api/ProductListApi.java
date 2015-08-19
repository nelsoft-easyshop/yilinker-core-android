package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Cart;
import com.yilinker.core.model.FilterGroup;
import com.yilinker.core.model.ProductList;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Patrick on 8/13/2015.
 */
public class ProductListApi {

    public static Request getProductList(final int requestCode, String target,final ResponseHandler responseHandler) {
        String url= String.format("%s/%s" ,
                    APIConstants.DOMAIN,
                    target);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                ProductList obj = gson.fromJson(response.toString(), ProductList.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        return request;

    }
}
