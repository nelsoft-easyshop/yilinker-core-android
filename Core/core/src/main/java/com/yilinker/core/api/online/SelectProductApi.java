package com.yilinker.core.api.online;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.Category;
import com.yilinker.core.model.seller.ProductSelection;
import com.yilinker.core.model.seller.ProductStatusList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by jaybryantc on 2/22/16.
 */
public class SelectProductApi {

    private static final Logger logger = Logger.getLogger(SelectProductApi.class.getSimpleName());

    public static Request getProducts(final int requestCode, String accessToken, String categoryIds, String sortBy, String status, String query,
                                      int limit, int pageNo, final ResponseHandler responseHandler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.PRODUCT_API,
                APIConstants.GET_AFFILLIATE_PRODUCTS);

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        if (categoryIds != null)
            params.put(APIConstants.PARAMS_CATEGORY_IDS, categoryIds);
        if (sortBy != null)
            params.put(APIConstants.PARAMS_SORT_BY, sortBy);
        if (status != null)
            params.put(APIConstants.PARAMS_STATUS, status);
        if (query != null)
            params.put(APIConstants.PARAMS_NAME, query);
        params.put(APIConstants.PARAMS_PAGE, String.valueOf(pageNo));
        params.put(APIConstants.PARAMS_LIMIT, String.valueOf(limit));

        logger.severe("---------------------********************" + endpoint);
        logger.severe(params.toString());

        Request request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    String jsonString = gson.toJson(apiResponse.getData());

                    gson = GsonUtility.createGsonBuilder(ProductSelection.class, new ProductSelection.ProductSelectionInstance()).create();
                    ProductSelection productSelection = gson.fromJson(jsonString, ProductSelection.class);

                    responseHandler.onSuccess(requestCode, productSelection);

                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request getCategories(final int requestCode, String accessToken, final ResponseHandler responseHandler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.PRODUCT_API,
                APIConstants.GET_CATEGORIES,
                APIConstants.ACCESS_TOKEN, accessToken);

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    Type listType = new TypeToken<ArrayList<Category>>(){}.getType();
                    gson = GsonUtility.createGsonBuilder(Category.class, new Category.CategoryInstance()).create();
                    String jsonString = gson.toJson(apiResponse.getData());
                    List<Category> categories = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, categories);

                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    public static Request saveProducts(final int requestCode, String accessToken, String selectedIds, String removedIds, final ResponseHandler responseHandler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.PRODUCT_API,
                APIConstants.SAVE_AFFILIATE_PRODUCTS);

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        if (selectedIds != null)
            params.put(APIConstants.PARAMS_MANUFACTURER_PRODUCT_IDS, selectedIds);
        if (removedIds != null)
            params.put(APIConstants.PARAMS_REMOVE_MANUFACTURER_PRODUCT_IDS, removedIds);

        Request request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(ProductStatusList.class, new ProductStatusList.ProductStatusListInstance()).create();
                String jsonString = gson.toJson(apiResponse.getData());
                ProductStatusList productStatusList = gson.fromJson(jsonString, ProductStatusList.class);

                responseHandler.onSuccess(requestCode, productStatusList);

            }
        }, errorListener);

        request.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        return request;
    }

}
