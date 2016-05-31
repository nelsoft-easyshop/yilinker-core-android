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
import com.yilinker.core.model.seller.ProductCategory;
import com.yilinker.core.model.seller.ProductCondition;
import com.yilinker.core.model.seller.ProductGroup;
import com.yilinker.core.model.seller.ProductShippingCategory;
import com.yilinker.core.model.seller.ProductUploadDetails;
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

    //temp
//    private static final String BaseApplication.getDomainURL() = String.format("%s/%s/%s", BaseApplication.getDomainURL().replace("v1", "v3"), "PH", "en");

    /**
     * Called to get product upload details
     * @param requestCode
     * @param productId
     * @param handler
     * @param errorListener
     * @return
     */
    public static Request getUploadDetails(final int requestCode, int productId, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                PRODUCT_API, GET_UPLOAD_DETAILS,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken(),
                PRODUCT_PARAM_ID, productId
        );

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ProductUploadDetails.class, new ProductUploadDetails.ProductUploadDetailsInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), ProductUploadDetails.class));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }


    /**
     * Called to get product brands
     * @param requestCode
     * @param handler
     * @param errorListener
     * @return
     */
    public static Request getBrands(final int requestCode, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", BaseApplication.getDomainURL(),
                PRODUCT_API, GET_BRANDS,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        JsonObjectRequest request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(com.yilinker.core.model.ProductBrand.class, new com.yilinker.core.model.ProductBrand.ProductBrandInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), new TypeToken<List<com.yilinker.core.model.ProductBrand>>(){}.getType()));

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

        String endpoint = String.format("%s/%s/%s?%s=%s", BaseApplication.getDomainURL(),
                PRODUCT_API, GET_PRODUCT_CONDITIONS,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        JsonObjectRequest request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(com.yilinker.core.model.ProductCondition.class, new com.yilinker.core.model.ProductCondition.ProductConditionInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), new TypeToken<List<com.yilinker.core.model.ProductCondition>>(){}.getType()));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }

        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    /**
     * Called to get product categories
     * @param requestCode
     * @param handler
     * @param errorListener
     * @return
     */
    public static Request getCategories(final int requestCode, int parentId, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s?%s=%s&%s=%d", BaseApplication.getDomainURL(),
                PRODUCT_API, GET_CATEGORIES,
                APIConstants.PRODUCT_UPLOAD_GET_CATEGORIES_PARAM_CATEGORY_ID, parentId,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        JsonObjectRequest request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ProductCategory.class, new ProductCategory.ProductCategoryInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), new TypeToken<List<ProductCategory>>(){}.getType()));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }

        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
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

    /**
     * Called to get product groups
     * @param requestCode
     * @param handler
     * @param errorListener
     * @return
     */
    public static Request getProductGroups(final int requestCode, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                PRODUCT_API, GET_PRODUCT_GROUPS,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken()
        );

        JsonObjectRequest request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ProductGroup.class, new ProductGroup.ProductGroupInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), new TypeToken<List<ProductGroup>>(){}.getType()));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }

        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    /**
     * Called to request product upload
     * @param requestCode
     * @param product
     * @param handler
     * @param errorListener
     * @return
     */
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

    /**
     * Called to request product edit
     * @param requestCode
     * @param product
     * @param handler
     * @param errorListener
     * @return
     */
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
