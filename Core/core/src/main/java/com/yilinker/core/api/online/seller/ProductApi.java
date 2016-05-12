package com.yilinker.core.api.online.seller;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.ProductBrand;
import com.yilinker.core.model.seller.ProductCondition;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by jaybryantc on 5/11/16.
 */
public class ProductApi {

    /**
     * Called to get product brands
     * @param requestCode
     * @param handler
     * @return
     */
    public static Request getBrands(final int requestCode, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN,
                com.yilinker.core.v2.constants.APIConstants.PRODUCT_API, com.yilinker.core.v2.constants.APIConstants.GET_BRANDS,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        JsonObjectRequest request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ProductBrand.class, new ProductBrand.BrandInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), new TypeToken<List<ProductBrand>>(){}.getType()));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }

        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    /**
     * Called to get product conditions
     * @param requestCode
     * @param handler
     * @return
     */
    public static Request getConditions(final int requestCode, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN,
                com.yilinker.core.v2.constants.APIConstants.PRODUCT_API, com.yilinker.core.v2.constants.APIConstants.GET_PRODUCT_CONDITIONS,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        JsonObjectRequest request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ProductCondition.class, new ProductCondition.ProductConditionInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), new TypeToken<List<ProductCondition>>(){}.getType()));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }

        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    public static void getCategories() {

    }

    public static void getShippingCategories() {

    }

    public static void getProductGroups() {

    }

    public static void createProduct() {

    }

    public static void editProduct() {


    }

}
