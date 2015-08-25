package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Category;
import com.yilinker.core.model.CategoryList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 8/24/2015.
 */
public class CategoryApi {

    public static Request getCategories(final int requestCode, int id, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.GET_CATEGORY,
                APIConstants.PARENT_ID, id);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CategoryList.class, new Category.CategoryInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                Type listType = new TypeToken<ArrayList<Category>>() {
                }.getType();

                List<Category> obj = gson.fromJson(jsonString, listType);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestGetCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetCart;

    }
}
