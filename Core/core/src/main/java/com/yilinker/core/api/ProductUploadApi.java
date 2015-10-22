package com.yilinker.core.api;

import android.graphics.Bitmap;

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
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.MultiPartRequest;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.ProductBrand;
import com.yilinker.core.model.ProductCategory;
import com.yilinker.core.model.ProductCondition;
import com.yilinker.core.model.seller.ProductEditDetails;
import com.yilinker.core.model.seller.ProductUpload;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;


import java.io.UnsupportedEncodingException;
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

        String url = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.PRODUCT_API,
                productUpload.getProductId() <= 0 ? APIConstants.PRODUCT_UPLOAD_API : APIConstants.PRODUCT_EDIT_API,
                    APIConstants.ACCESS_TOKEN, accessToken);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        if (productUpload.getProductId() > 0) {
            params.put(APIConstants.PRODUCT_EDIT_PARAMS_PRODUCT_ID, String.valueOf(productUpload.getProductId()));
        }
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CATEGORY, String.valueOf(productUpload.getCategoryId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_BRAND,String.valueOf(productUpload.getBrandId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CUSTOM_BRAND, productUpload.getCustomBrand());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_TITLE,productUpload.getTitle());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DESCRIPTION,productUpload.getFullDescription());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SHORT_DESCRIPTION,productUpload.getShortDescription());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CONDITION,String.valueOf(productUpload.getConditionId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_ISFREESHIPPING, String.valueOf(false));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_LENGTH, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getLength()): "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WEIGHT, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getWeight()): "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_HEIGHT, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getHeight()) : "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WIDTH, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getWidth()) : "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_QUANTITY, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getQuantity()) : "1");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRICE, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getPrice()) : "0.00");
        if (productUpload.getDiscountedPrice() >= 0.00) {
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DISCOUNTED_PRICE, String.valueOf(productUpload.getDiscountedPrice()));
        }
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SKU, productUpload.getSku() != null ? productUpload.getSku(): "");
//        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_IMAGES, productUpload.getImageIndicesArray().toString());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRODUCT_PROPERTIES,productUpload.getProductProperties().toString());

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
                sendErrorMessage(requestCode, error, responseHandler);
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
                        sendErrorMessage(requestCode,error,responseHandler);
                    }
        });


        request.setRetryPolicy(policy);

        return request;

    }

    public static Request searchCategory(final int requestCode, String accessToken, String keyword, final ResponseHandler responseHandler) {


        String endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_UPLOAD_GET_CATEGORIES,
                APIConstants.ACCESS_TOKEN, accessToken,
                APIConstants.PRODUCT_UPLOAD_GET_CATEGORIES_PARAM_QUERY_STRING, keyword);

        if (endpoint.contains(" ")) {
            endpoint = endpoint.replaceAll(" ", "%20");
        }

        Request request = new JsonObjectRequest(endpoint,
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

                            responseHandler.onFailed(requestCode,apiResponse.getMessage());
                        }

                    }

                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        sendErrorMessage(requestCode,error,responseHandler);
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

                            responseHandler.onFailed(requestCode,apiResponse.getMessage());
                        }

                    }

                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        sendErrorMessage(requestCode,error,responseHandler);
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

                        if (apiResponse.isSuccessful()) {

                            gson = GsonUtility.createGsonBuilder(ProductCondition.class, new ProductCondition.ProductConditionInstance()).create();
                            String jsonString = new Gson().toJson(apiResponse.getData());
                            ProductCondition[] obj = gson.fromJson(jsonString, ProductCondition[].class);

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

    public static Request getProductEditDetails(final int requestCode, String accessToken,
                                                int productId, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_EDIT_DETAILS_API,
                APIConstants.ACCESS_TOKEN, accessToken, APIConstants.PRODUCT_EDIT_DETAILS_PARAMS_PRODUCT_ID, productId);


        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ProductEditDetails.class, new ProductEditDetails.ProductEditDetailsInstance()).create();
                    String jsonString = gson.toJson(apiResponse.getData());
                    ProductEditDetails productEditDetails = gson.fromJson(jsonString, ProductEditDetails.class);

                    responseHandler.onSuccess(requestCode, productEditDetails);


                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                sendErrorMessage(requestCode,error,responseHandler);
            }
        });

        request.setRetryPolicy(policy);

        return request;
    }

    public static Request draftProduct(final int requestCode, ProductUpload productUpload, String accessToken, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.PRODUCT_API,
                APIConstants.PRODUCT_UPLOAD_API, APIConstants.PRODUCT_DRAFT_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        Map<String,String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.PRODUCT_EDIT_PARAMS_PRODUCT_ID, String.valueOf(productUpload.getProductId()));
        if (productUpload.getCategoryId() != 0)
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CATEGORY, String.valueOf(productUpload.getCategoryId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_BRAND,String.valueOf(productUpload.getBrandId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CUSTOM_BRAND,productUpload.getCustomBrand());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_TITLE,productUpload.getTitle());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DESCRIPTION,productUpload.getFullDescription());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SHORT_DESCRIPTION,productUpload.getShortDescription());
        if (productUpload.getConditionId() != 0)
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CONDITION,String.valueOf(productUpload.getConditionId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_ISFREESHIPPING,String.valueOf(false));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_LENGTH, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getLength()): "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WEIGHT, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getWeight()): "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_HEIGHT, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getHeight()) : "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WIDTH, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getWidth()) : "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_QUANTITY, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getQuantity()) : "1");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRICE, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getPrice()) : "0.00");
        if (productUpload.getDiscountedPrice() > 0.00) {
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DISCOUNTED_PRICE, String.valueOf(productUpload.getDiscountedPrice()));
        }
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SKU, productUpload.getSku() != null ? productUpload.getSku(): "");
        if(productUpload.getImages().size() > 0)
//        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_IMAGES, productUpload.getImageIndicesArray().toString());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRODUCT_PROPERTIES,productUpload.getProductProperties().toString());

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
                sendErrorMessage(requestCode,error,responseHandler);
            }
        });

        multiPartRequest.setRetryPolicy(policy);

        return multiPartRequest;
    }

    public static Request editProduct(final int requestCode, ProductUpload productUpload, String imageDetails,
                                      String accessToken, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.PRODUCT_API,
                APIConstants.PRODUCT_EDIT_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        Map<String,String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.PRODUCT_EDIT_PARAMS_PRODUCT_ID, String.valueOf(productUpload.getProductId()));
        params.put(APIConstants.PRODUCT_EDIT_PARAMS_PRODUCT_UNIT_ID, productUpload.getProductUnitId() != null ? productUpload.getProductUnitId() : "");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CATEGORY, String.valueOf(productUpload.getCategoryId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_BRAND,String.valueOf(productUpload.getBrandId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CUSTOM_BRAND, productUpload.getCustomBrand());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_TITLE,productUpload.getTitle());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DESCRIPTION,productUpload.getFullDescription());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SHORT_DESCRIPTION,productUpload.getShortDescription());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CONDITION,String.valueOf(productUpload.getConditionId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_ISFREESHIPPING, String.valueOf(false));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_LENGTH, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getLength()): "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WEIGHT, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getWeight()): "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_HEIGHT, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getHeight()) : "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WIDTH, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getWidth()) : "0.00");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_QUANTITY, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getQuantity()) : "1");
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRICE, productUpload.getAttributeCombinationUploadList().size() == 0 ? String.valueOf(productUpload.getPrice()) : "0.00");
        if (productUpload.getDiscountedPrice() >= 0.00) {
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DISCOUNTED_PRICE, String.valueOf(productUpload.getDiscountedPrice()));
        }
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SKU, productUpload.getSku() != null ? productUpload.getSku(): "");
//        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_IMAGES, productUpload.getImageIndicesArray().toString());
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRODUCT_PROPERTIES,productUpload.getProductProperties().toString());
        params.put(APIConstants.PRODUCT_EDIT_PARAMS_IMAGE_DETAILS, imageDetails);

        MultiPartRequest multiPartRequest = new MultiPartRequest(url,productUpload, APIResponse.class,params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                } else {
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                sendErrorMessage(requestCode,error,responseHandler);
            }
        });

        multiPartRequest.setRetryPolicy(policy);

        return multiPartRequest;
    }

    private static void sendErrorMessage(int requestCode, VolleyError error, ResponseHandler responseHandler) {

        String message = "An error occured.";

        if (error.networkResponse.statusCode == 400) {
            try {
                String jsonString = new String(error.networkResponse.data,
                        HttpHeaderParser.parseCharset(error.networkResponse.headers));
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(jsonString, APIResponse.class);
                if (apiResponse != null) {
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                } else {
                    responseHandler.onFailed(requestCode,"Server Error.");
                }
                return;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

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

}
