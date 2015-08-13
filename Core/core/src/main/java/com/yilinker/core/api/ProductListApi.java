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

    public static Request getProductList(final int requestCode, String target,
                                         int priceFrom, int priceTo,int categoryId,int sellerId,
                                         String selectedSort, String selectedDirection,List<FilterGroup> filterGroups,
                                         int brandId, int loadPage, final ResponseHandler responseHandler) {
        String url;
        if (target.equals("")){
            url = String.format("%s/%s/%s?" +
                            "%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s",
                    APIConstants.DOMAIN, APIConstants.PRODUCT_API,
                    APIConstants.PRODUCT_GET_LIST,
                    APIConstants.PRODUCT_lIST_PRICE_FROM, Integer.toString(priceFrom),
                    APIConstants.PRODUCT_LIST_PRICE_TO,Integer.toString(priceTo),
                    APIConstants.PRODUCT_LIST_CATEGORY_ID,Integer.toString(categoryId),
                    APIConstants.PRODUCT_lIST_SELLER_ID, Integer.toString(sellerId),
                    APIConstants.PRODUCT_LIST_SORT_TYPE, selectedSort,
                    APIConstants.PRODUCT_LIST_SORT_DIRECTION, selectedDirection,
                    APIConstants.PRODUCT_lIST_FILTER, filterGroups,
                    APIConstants.PRODUCT_LIST_BRAND_ID,Integer.toString(brandId),
                    APIConstants.PRODUCT_LIST_PAGE, Integer.toString(loadPage));

        }else{
            url = String.format("%s/%s/%s?" +
                            "%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s" +"&%s=%s",
                    APIConstants.DOMAIN, APIConstants.PRODUCT_API,
                    target,
                    APIConstants.PRODUCT_lIST_PRICE_FROM, Integer.toString(priceFrom),
                    APIConstants.PRODUCT_LIST_PRICE_TO,Integer.toString(priceTo),
                    APIConstants.PRODUCT_LIST_CATEGORY_ID,Integer.toString(categoryId),
                    APIConstants.PRODUCT_lIST_SELLER_ID, Integer.toString(sellerId),
                    APIConstants.PRODUCT_LIST_SORT_TYPE, selectedSort,
                    APIConstants.PRODUCT_LIST_SORT_DIRECTION, selectedDirection,
                    APIConstants.PRODUCT_lIST_FILTER, filterGroups,
                    APIConstants.PRODUCT_LIST_BRAND_ID,Integer.toString(brandId),
                    APIConstants.PRODUCT_LIST_PAGE, Integer.toString(loadPage));

        }

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(ProductList.class, new ProductList.ProductListInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Cart obj = gson.fromJson(jsonString, Cart.class);

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
