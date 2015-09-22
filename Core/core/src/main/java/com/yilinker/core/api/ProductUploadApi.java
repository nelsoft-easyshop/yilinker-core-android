package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.MultiPartRequest;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.ProductBrand;
import com.yilinker.core.model.ProductCategory;
import com.yilinker.core.model.ProductCondition;
import com.yilinker.core.model.seller.ProductUpload;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by jaybr_000 on 8/18/2015.
 */
public class ProductUploadApi {

    static int socketTimeout = 300000;
    static RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    public static Request uploadProduct(final int requestCode, ProductUpload productUpload, String accessToken, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_UPLOAD_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CATEGORY, String.valueOf(productUpload.getCategoryId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_BRAND,String.valueOf(productUpload.getBrandId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_TITLE,productUpload.getTitle());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DESCRIPTION,productUpload.getFullDescription());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SHORT_DESCRIPTION,productUpload.getShortDescription());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CONDITION,String.valueOf(productUpload.getConditionId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_ISFREESHIPPING,String.valueOf(false));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_LENGTH,String.valueOf(productUpload.getLength()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WEIGHT,String.valueOf(productUpload.getWeight()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_HEIGHT,String.valueOf(productUpload.getHeight()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WIDTH,String.valueOf(productUpload.getWidth()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CUSTOM_BRAND,productUpload.getCustomBrand());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_QUANTITY,String.valueOf(productUpload.getQuantity()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRICE,String.valueOf(productUpload.getPrice()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DISCOUNTED_PRICE,String.valueOf(productUpload.getDiscountedPrice()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SKU,productUpload.getSku());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_IMAGES, new Gson().toJson(productUpload.getImages()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRODUCT_PROPERTIES,productUpload.getProductProperties().toString());


        JSONObject jsonObject = new JSONObject(params);
        String stringJSON = jsonObject.toString();
        System.out.print(stringJSON);

//        StringBuilder stringBuilder = new StringBuilder();
//
//        for(String key:params.keySet()) {
//            stringBuilder.append(key+"="+params.get(key)+"&");
//        }

        //url = String.format("%s?%s",url,stringBuilder.toString());


        MultiPartRequest multiPartRequest = new MultiPartRequest(url,productUpload, APIResponse.class,params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = "An error occured.";
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    message = "No connection available.";
                } else if (error instanceof AuthFailureError) {
                    message = "Authentication Failure.";
                } else if (error instanceof ServerError) {
                    message = "Server error.";
                } else if (error instanceof NetworkError) {
                    message = "Network Error.";
                } else if (error instanceof ParseError) {
                    message = "Parse error.";
                }
                responseHandler.onFailed(requestCode,message);
            }
        });

        multiPartRequest.setRetryPolicy(policy);

        return multiPartRequest;
    }

    public static Request getBrands(final int requestCode, String accessToken, String brandKeyword, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s&%s=%s",APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_UPLOAD_GET_BRAND,APIConstants.ACCESS_TOKEN,accessToken,APIConstants.PRODUCT_UPLOAD_GET_BRAND_PARAM_BRAND_KEYWORD,brandKeyword);

        Request request = new JsonObjectRequest(url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                        APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                        gson = GsonUtility.createGsonBuilder(ProductBrand.class, new ProductBrand.ProductBrandInstance()).create();
                        String jsonString = new Gson().toJson(apiResponse.getData());
                        ProductBrand[] obj = gson.fromJson(jsonString, ProductBrand[].class);

                        if (apiResponse.isSuccessful()) {

                            responseHandler.onSuccess(requestCode, obj);
                        }else{

                            responseHandler.onFailed(requestCode,apiResponse.getMessage());
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String message = "An error occured.";
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            message = "No connection available.";
                        } else if (error instanceof AuthFailureError) {
                            message = "Authentication Failure.";
                        } else if (error instanceof ServerError) {
                            message = "Server error.";
                        } else if (error instanceof NetworkError) {
                            message = "Network Error.";
                        } else if (error instanceof ParseError) {
                            message = "Parse error.";
                        }
                        responseHandler.onFailed(requestCode,message);
                    }
        });


        request.setRetryPolicy(policy);

        return request;

    }

    public static Request getCategories(final int requestCode, String accessToken, int parentId, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s&%s=%d",APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_UPLOAD_GET_CATEGORIES,APIConstants.ACCESS_TOKEN,accessToken,APIConstants.PRODUCT_UPLOAD_GET_CATEGORIES_PARAM_PARENT_ID,parentId);

        Request request = new JsonObjectRequest(url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                        APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                        gson = GsonUtility.createGsonBuilder(ProductCategory.class, new ProductCategory.ProductCategoryInstance()).create();
                        String jsonString = new Gson().toJson(apiResponse.getData());
                        ProductCategory[] obj = gson.fromJson(jsonString, ProductCategory[].class);

                        if (apiResponse.isSuccessful()) {

                            responseHandler.onSuccess(requestCode, obj);
                        }else{

                            responseHandler.onFailed(requestCode,"Error!");
                        }

                    }

                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String message = "An error occured.";
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            message = "No connection available.";
                        } else if (error instanceof AuthFailureError) {
                            message = "Authentication Failure.";
                        } else if (error instanceof ServerError) {
                            message = "Server error.";
                        } else if (error instanceof NetworkError) {
                            message = "Network Error.";
                        } else if (error instanceof ParseError) {
                            message = "Parse error.";
                        }
                        responseHandler.onFailed(requestCode,message);
                    }
                });


        request.setRetryPolicy(policy);

        return request;
    }


    public static Request getConditions(final int requestCode, String accessToken, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s",APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_UPLOAD_GET_CONDITIONS,APIConstants.ACCESS_TOKEN, accessToken);

        Request request = new JsonObjectRequest(url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                        APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                        gson = GsonUtility.createGsonBuilder(ProductCondition.class, new ProductCondition.ProductConditionInstance()).create();
                        String jsonString = new Gson().toJson(apiResponse.getData());
                        ProductCondition[] obj = gson.fromJson(jsonString, ProductCondition[].class);

                        if (apiResponse.isSuccessful()) {

                          responseHandler.onSuccess(requestCode, obj);
                        }
                        else{

                            responseHandler.onFailed(requestCode,"Unable to get conditions.");
                        }

                    }

                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String message = "An error occured.";
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            message = "No connection available.";
                        } else if (error instanceof AuthFailureError) {
                            message = "Authentication Failure.";
                        } else if (error instanceof ServerError) {
                            message = "Server error.";
                        } else if (error instanceof NetworkError) {
                            message = "Network Error.";
                        } else if (error instanceof ParseError) {
                            message = "Parse error.";
                        }
                        responseHandler.onFailed(requestCode,message);
                    }
                });


        request.setRetryPolicy(policy);

        return request;
    }
}
