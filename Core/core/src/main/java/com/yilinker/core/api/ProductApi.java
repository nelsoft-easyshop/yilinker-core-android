package com.yilinker.core.api;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Product;
import com.yilinker.core.model.ProductReview;
import com.yilinker.core.model.ProductUpload;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class ProductApi {

    public static Request getProductDetails(final int requestCode, int id, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%d", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_GET_DETAILS, APIConstants.PRODUCT_GET_DETAILS_PARAM_ID, id);

        Request request = new JsonObjectRequest(url, null, new Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse<Product> apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Product.class, new Product.ProductInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Product obj = gson.fromJson(jsonString, Product.class);
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

    public static Request getProductReview(final int requestCode, int id, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s?%s=%d", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_GET_REVIEW, APIConstants.PRODUCT_GET_REVIEW_PARAM_ID, id);

        Request request = new JsonObjectRequest(url, null, new Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(ProductReview.class, new ProductReview.ProductReviewInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                ProductReview obj = gson.fromJson(jsonString, ProductReview.class);

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

    public static Request uploadProduct(final int requestCode, ProductUpload productUpload, String accessToken, final ResponseHandler responseHandler) {

        int socketTimeout = 5000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        String url = String.format("%s/%s/%s",APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_UPLOAD_API);

        JSONObject params = new JSONObject();

        try {
            params.put(APIConstants.ACCESS_TOKEN, accessToken);
            params.put(APIConstants.UPLOAD_TOKEN, "");
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_IMAGES,new Gson().toJson(productUpload.getImages()));
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CATEGORY, productUpload.getCategory());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_BRAND,productUpload.getBrand());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_TITLE,productUpload.getTitle());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DESCRIPTION,productUpload.getFullDescription());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SHORT_DESCRIPTION,productUpload.getShortDescription());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CONDITION,productUpload.getCondition());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_ISFREESHIPPING,false);
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_LENGTH,productUpload.getLength());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WEIGHT,productUpload.getWeight());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_HEIGHT,productUpload.getHeight());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WIDTH,productUpload.getWidth());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CUSTOM_BRAND,productUpload.getBrand());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_QUANTITY,productUpload.getQuantity());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRICE,productUpload.getPrice());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DISCOUNTED_PRICE,productUpload.getDiscountedPrice());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SKU,"");
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRODUCT_PROPERTIES,productUpload.getProductProperties());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Request requestUploadProduct = new JsonObjectRequest(url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestUploadProduct.setRetryPolicy(policy);

        return requestUploadProduct;
    }
}