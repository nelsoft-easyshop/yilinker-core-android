package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.Product;
import com.yilinker.core.model.buyer.ProductList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

/**
 * Created by Patrick on 8/13/2015.
 */
public class ProductListApi {

    public static Request getProductList(final int requestCode, String target,final ResponseHandler responseHandler) {
        String url= String.format("%s/product/getProductList?%s" ,
                    APIConstants.DOMAIN,
                    target);

        url = url.replaceAll(" ","%20");

        Request request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse<ProductList> apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Product.class, new ProductList.ProductListInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                ProductList obj = gson.fromJson(jsonString, ProductList.class);
                if (obj != null) {
                    if (apiResponse.isSuccessful() && obj.getProducts().size() > 0)
                        responseHandler.onSuccess(requestCode, obj);
                    else
                        responseHandler.onFailed(requestCode, "No products found.");
                } else {
                    responseHandler.onFailed(requestCode, "No more products.");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }
}
