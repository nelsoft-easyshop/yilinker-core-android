package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.Product;
import com.yilinker.core.model.seller.CategoryProductList;
import com.yilinker.core.model.seller.ProductList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bryan on 9/2/2015.
 */
public class ProductManagementApi {

    public static Request getProductList(final int requestCode, String token, int status, String keyword,
                                         final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.PRODUCT_MANAGEMENT_API,
                APIConstants.GET_PRODUCT_LIST);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_STATUS, String.valueOf(status));
        params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_KEYWORD, "");

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(ProductList.class, new ProductList.ProductListInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                ProductList obj = gson.fromJson(jsonString, ProductList.class);

//                gson = GsonUtility.createGsonBuilder(CategoryProducts.class, new CategoryProducts.ProductsInstance()).create();
//                try {
//                    JSONObject jsonObject = new JSONObject(jsonString);
//                    String json = jsonObject.getJSONObject("products").toString();
//                    CategoryProducts[] productsList = gson.fromJson(json, CategoryProducts[].class);
//                    obj.setProducts(productsList);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

                responseHandler.onSuccess(requestCode, obj);

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

    public static Request editProductStatus (final int requestCode, String token, int productId, int status,
                                            final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.PRODUCT_MANAGEMENT_API, APIConstants.UPDATE_PRODUCT_STATUS);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_PRODUCT_ID, String.valueOf(productId));
        params.put(APIConstants.PRODUCT_MANAGEMENT_PARAMS_STATUS, String.valueOf(status));


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                }else{
                    responseHandler.onSuccess(requestCode, apiResponse);
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
