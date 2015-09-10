package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.TransactionList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Patrick on 8/28/2015.
 */
public class TransactionApi {

    public static Request addProductReview(final int requestCode, int id,String accessToken,float rating,String review, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, "auth",
                APIConstants.PRODUCT_API,APIConstants.PRODUCT_ADD_PRODUCT_REVIEW );

        Map<String, String > params = new HashMap<>();
        params.put( APIConstants.PRODUCT_ID,String.valueOf(id));
        params.put(APIConstants.PRODUCT_RATING,String.valueOf(rating));
        params.put(APIConstants.PRODUCT_REVIEW,review);
        params.put(APIConstants.ACCESS_TOKEN, accessToken);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

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

    public static Request getTransactionList(final int requestCode, String accessToken, String type, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_API,
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

        String endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_API,
                APIConstants.ACCESS_TOKEN, accessToken, APIConstants.SELLER_TRANSACTION_PARAMS_TRANSACTION_ID, transactionId);

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(TransactionList.class, new TransactionList.TransactionListInstance()).create();

                    String jsonString  = new Gson().toJson(apiResponse.getData());

                    TransactionList transactionList = gson.fromJson(jsonString, TransactionList.class);

                    responseHandler.onSuccess(requestCode, transactionList);

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
