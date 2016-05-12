package com.yilinker.core.api.online.seller;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import static com.yilinker.core.v2.constants.APIConstants.*;

import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.ProductBrand;
import com.yilinker.core.model.seller.ProductCondition;
import com.yilinker.core.model.seller.ProductShippingCategory;
import com.yilinker.core.model.seller.request.Product;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jaybryantc on 5/11/16.
 */
public class ProductApi {

    /**
     * Called to get product brands
     * @param requestCode
     * @param handler
     * @param errorListener
     * @return
     */
    public static Request getBrands(final int requestCode, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN,
                PRODUCT_API, GET_BRANDS,
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
     * @param errorListener
     * @return
     */
    public static Request getConditions(final int requestCode, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN,
                PRODUCT_API, GET_PRODUCT_CONDITIONS,
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

    /**
     * Called to get product shipping categories
     * @param requestCode
     * @param handler
     * @param errorListener
     * @return
     */
    public static Request getShippingCategories(final int requestCode, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN,
                PRODUCT_API, GET_SHIPPING_CATEGORIES,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        JsonObjectRequest request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ProductShippingCategory.class, new ProductShippingCategory.ProductShippingCategoryInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), new TypeToken<List<ProductShippingCategory>>(){}.getType()));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }

        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    public static void getProductGroups() {



    }

    public static Request createProduct(final int requestCode, Product product, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                PRODUCT_API, CREATE_PRODUCT,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        HashMap<String,String> params = new HashMap<>();
        params.put(PRODUCT_PARAM_NAME, product.getName());
        params.put(PRODUCT_PARAM_SHORT_DESCRIPTION, product.getShortDescription());
        params.put(PRODUCT_PARAM_COMPLETE_DESCRIPTION, product.getCompleteDescription());
        params.put(PRODUCT_PARAM_VIDEO_URL, product.getVideoUrl());
        params.put(PRODUCT_PARAM_CONDITION_ID, String.valueOf(product.getConditionId()));
        params.put(PRODUCT_PARAM_CATEGORY_ID, String.valueOf(product.getCategoryId()));
        params.put(PRODUCT_PARAM_SHIPPING_CATEGORY_ID, String.valueOf(product.getShippingCategoryId()));
        params.put(PRODUCT_PARAM_BRAND, product.getBrand());
        params.put(PRODUCT_PARAM_GROUPS, product.getProductGroups());
        params.put(PRODUCT_PARAM_IMAGES, product.getProductImages());
        params.put(PRODUCT_PARAM_UNITS, product.getProductUnits());
        params.put(PRODUCT_PARAM_IS_DRAFT, String.valueOf(product.isDraft()));

        Request request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject json) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();

                APIResponse response = gson.fromJson(json.toString(), APIResponse.class);

                if (response.isSuccessful()) {

                    handler.onSuccess(requestCode, null);

                } else {

                    handler.onFailed(requestCode, response.getMessage());

                }

            }
        }, errorListener);

        return request;

    }

    public static Request editProduct(final int requestCode, Product product, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                PRODUCT_API, EDIT_PRODUCT,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        HashMap<String,String> params = new HashMap<>();
        params.put(PRODUCT_PARAM_ID, String.valueOf(product.getProductId()));
        params.put(PRODUCT_PARAM_NAME, product.getName());
        params.put(PRODUCT_PARAM_SHORT_DESCRIPTION, product.getShortDescription());
        params.put(PRODUCT_PARAM_COMPLETE_DESCRIPTION, product.getCompleteDescription());
        params.put(PRODUCT_PARAM_VIDEO_URL, product.getVideoUrl());
        params.put(PRODUCT_PARAM_CONDITION_ID, String.valueOf(product.getConditionId()));
        params.put(PRODUCT_PARAM_CATEGORY_ID, String.valueOf(product.getCategoryId()));
        params.put(PRODUCT_PARAM_SHIPPING_CATEGORY_ID, String.valueOf(product.getShippingCategoryId()));
        params.put(PRODUCT_PARAM_BRAND, product.getBrand());
        params.put(PRODUCT_PARAM_GROUPS, product.getProductGroups());
        params.put(PRODUCT_PARAM_IMAGES, product.getProductImages());
        params.put(PRODUCT_PARAM_UNITS, product.getProductUnits());

        Request request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject json) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();

                APIResponse response = gson.fromJson(json.toString(), APIResponse.class);

                if (response.isSuccessful()) {

                    handler.onSuccess(requestCode, null);

                } else {

                    handler.onFailed(requestCode, response.getMessage());

                }

            }
        }, errorListener);

        return request;
    }

}
