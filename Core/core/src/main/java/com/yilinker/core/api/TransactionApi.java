package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.CancellationReasons;
import com.yilinker.core.model.TransactionDetails;
import com.yilinker.core.model.TransactionDetailsBuyer;
import com.yilinker.core.model.TransactionList;
import com.yilinker.core.model.TransactionProduct;
import com.yilinker.core.model.buyer.CartItem2;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Patrick on 8/28/2015.
 */
public class TransactionApi {

    public static Request addProductReview(final int requestCode, int id,String accessToken,float rating,String review, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.PRODUCT_API,APIConstants.PRODUCT_ADD_PRODUCT_REVIEW );

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.PRODUCT_ID,String.valueOf(id));
        params.put(APIConstants.PRODUCT_RATING,String.valueOf(rating));
        params.put(APIConstants.PRODUCT_REVIEW,review);
        params.put(APIConstants.PRODUCT_REVIEW_TITLE,"title");
        params.put(APIConstants.ACCESS_TOKEN, accessToken);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String message = APIConstants.API_CONNECTION_PROBLEM;

                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                            message = APIConstants.API_CONNECTION_PROBLEM;

                        } else if (error instanceof AuthFailureError) {

                            message = APIConstants.API_CONNECTION_AUTH_ERROR;

                        }else{
                            try {
                                String responseBody = new String(error.networkResponse.data, "utf-8" );
                                JSONObject jsonObject = new JSONObject( responseBody );
                                JSONArray array = jsonObject.getJSONArray("data");

                                StringBuilder builder = new StringBuilder();
                                for (int i=0;i<array.length();i++){
                                    try {
                                        builder.append(array.getString(i)+"\n");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                message = builder.toString();

                            } catch ( JSONException e ) {
                                //Handle a malformed json response
                            } catch (UnsupportedEncodingException e){

                            }
                        }
                        responseHandler.onFailed(requestCode, message);
                    }});

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    public static Request addSellerReview(final int requestCode, int sellerId,int orderId,String accessToken,String rating,String review, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.PRODUCT_FEEDBACK,APIConstants.PRODUCT_ADD_SELLER_REVIEW );

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.PRODUCT_REVIEW_ORDER_ID,String.valueOf(orderId));
        params.put(APIConstants.PRODUCT_REVIEW_SELLER_ID,String.valueOf(sellerId));
        params.put(APIConstants.PRODUCT_RATINGS,rating);
        params.put(APIConstants.PRODUCT_FEEDBACK,review);
        params.put(APIConstants.PRODUCT_REVIEW_TITLE,"title");
        params.put(APIConstants.ACCESS_TOKEN, accessToken);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                }else{
                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        message = jsonObject.getString("message");

                    } catch ( JSONException e ) {
                        //Handle a malformed json response
                    } catch (UnsupportedEncodingException e){

                    }
                }
                responseHandler.onFailed(requestCode, message);
            }});

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    public static Request getTransactionList(final int requestCode, String accessToken, String type, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_LIST_API,
                APIConstants.ACCESS_TOKEN, accessToken, APIConstants.SELLER_TRANSACTION_LIST_PARAMS_TYPE, type);

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(TransactionList.class, new TransactionList.TransactionListInstance()).create();

                    String jsonString  = new Gson().toJson(apiResponse.getData());

                    TransactionList transactionList = gson.fromJson(jsonString, TransactionList.class);

                    responseHandler.onSuccess(requestCode, transactionList.getOrders());

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String message = APIConstants.API_CONNECTION_PROBLEM;
                try {
                    String responseBody = new String(error.networkResponse.data, "utf-8" );
                    JSONObject jsonObject = new JSONObject( responseBody );
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray errors = jsonObject.getJSONArray("errors");
                    message = errors.getString(0);

                } catch ( JSONException e ) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e){

                }
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request getTransactionDetails(final int requestCode, String accessToken, String transactionId, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_API,
                APIConstants.ACCESS_TOKEN, accessToken, APIConstants.SELLER_TRANSACTION_PARAMS_TRANSACTION_ID, transactionId);

        url = url.replace(" ", "%20");

        Request request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(TransactionDetailsBuyer.class, new TransactionDetailsBuyer.TransactionDetailsBuyerInstance()).create();
                    String jsonString  = new Gson().toJson(apiResponse.getData());
                    TransactionDetailsBuyer transactionDetailsBuyer = gson.fromJson(jsonString, TransactionDetailsBuyer.class);

                    responseHandler.onSuccess(requestCode, transactionDetailsBuyer);

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String message = APIConstants.API_CONNECTION_PROBLEM;
                try {
                    String responseBody = new String(error.networkResponse.data, "utf-8" );
                    JSONObject jsonObject = new JSONObject( responseBody );
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray errors = jsonObject.getJSONArray("errors");
                    message = errors.getString(0);

                } catch ( JSONException e ) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e){

                }
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }


    public static Request getOrderProductDetails(final int requestCode, String accessToken, String orderProductId, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_ORDER_PRODUCT_DETAILS_API,
                APIConstants.ACCESS_TOKEN, accessToken, APIConstants.SELLER_TRANSACTION_DELIVERY_LOGS_PARAMS_ORDER_PRODUCT_ID, orderProductId);

        url = url.replace(" ", "%20");

        Request request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(TransactionProduct.class, new TransactionProduct.TransactionProductInstance()).create();
                    String jsonString  = new Gson().toJson(apiResponse.getData());
                    TransactionProduct transactionProduct = gson.fromJson(jsonString, TransactionProduct.class);

                    responseHandler.onSuccess(requestCode, transactionProduct);

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String message = APIConstants.API_CONNECTION_PROBLEM;
                try {
                    String responseBody = new String(error.networkResponse.data, "utf-8" );
                    JSONObject jsonObject = new JSONObject( responseBody );
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray errors = jsonObject.getJSONArray("errors");
                    message = errors.getString(0);

                } catch ( JSONException e ) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e){

                }
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }


    public static Request getCancellationReasons(final int requestCode , String accessToken, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.CANCELLATION_API,APIConstants.SELLER_TRANSACTION_REASONS_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        Request request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    String jsonString  = new Gson().toJson(apiResponse.getData());
                    Type listType = new TypeToken<ArrayList<CancellationReasons>>(){}.getType();
                    List<CancellationReasons> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String message = APIConstants.API_CONNECTION_PROBLEM;
                try {
                    String responseBody = new String(error.networkResponse.data, "utf-8" );
                    JSONObject jsonObject = new JSONObject( responseBody );
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray errors = jsonObject.getJSONArray("errors");
                    message = errors.getString(0);

                } catch ( JSONException e ) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e){

                }
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request sendCancelOrder(final int requestCode , String accessToken, String reasonId, String transactionId, String remarks, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.TRANSACTION_API, APIConstants.SELLER_TRANSACTION_CANCEL_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        Map<String, String > params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.SELLER_TRANSACTION_CANCEL_PARAMS_REASON_ID, reasonId);
        params.put(APIConstants.SELLER_TRANSACTION_CANCEL_PARAMS_TRANSACTION_ID, transactionId);
        params.put(APIConstants.SELLER_TRANSACTION_CANCEL_PARAMS_REMARK, remarks);


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

//                    String jsonString  = new Gson().toJson(apiResponse.getData());
//                    Type listType = new TypeToken<ArrayList<CancellationReasons>>(){}.getType();
//                    List<CancellationReasons> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, apiResponse);

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String message = APIConstants.API_CONNECTION_PROBLEM;
                try {
                    String responseBody = new String(error.networkResponse.data, "utf-8" );
                    JSONObject jsonObject = new JSONObject( responseBody );
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray errors = jsonObject.getJSONArray("errors");
                    message = errors.getString(0);

                } catch ( JSONException e ) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e){

                }
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }


}
