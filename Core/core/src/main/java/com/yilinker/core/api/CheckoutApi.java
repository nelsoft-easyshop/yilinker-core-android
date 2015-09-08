package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.Cart;
import com.yilinker.core.model.buyer.CartItem2;
import com.yilinker.core.model.buyer.CheckoutOverview;
import com.yilinker.core.model.buyer.CheckoutPayment;
import com.yilinker.core.model.buyer.CheckoutTransactionOverview;
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
 * Created by rlcoronado on 8/20/15.
 */
public class CheckoutApi {

    public static Request payViaCod(final int requestCode, boolean isGuest, String token, final ResponseHandler responseHandler) {

        String url;

        if(!isGuest) {
            url = String.format("%s/%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.AUTH_API,
                    APIConstants.CHECKOUT_PAYMENT_API,
                    APIConstants.CHECKOUT_PAYMENT_COD);
        } else {
            url = String.format("%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_COD);
        }

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper payUsingCod = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CheckoutOverview.class, new CheckoutOverview.CheckoutOverviewInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                CheckoutOverview obj = gson.fromJson(jsonString, CheckoutOverview.class);
                if(apiResponse.isSuccessful()){
                    responseHandler.onSuccess(requestCode, obj);
                } else {
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


        payUsingCod.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return payUsingCod;

    }

    public static Request payViaPesoPay(final int requestCode, boolean isGuest, String token, final ResponseHandler responseHandler) {

        String url;

        if(!isGuest) {
            url = String.format("%s/%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.CHECKOUT_PAYMENT_API,
                    APIConstants.CHECKOUT_PAYMENT_PESOPAY);
        } else {
            url = String.format("%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API,
                    APIConstants.CHECKOUT_PAYMENT_PESOPAY);
        }

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper payViaPesoPay = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CheckoutPayment.class, new CheckoutPayment.CheckoutPaymentInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                if(apiResponse.isSuccessful()){
                    CheckoutPayment obj = gson.fromJson(jsonString, CheckoutPayment.class);
                    responseHandler.onSuccess(requestCode, obj);
                } else {
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


        payViaPesoPay.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return payViaPesoPay;

    }

    public static Request getCheckoutOverview(final int requestCode, boolean isGuest, String transactionId, String token, final ResponseHandler responseHandler) {

        String url;

        if(isGuest) {
            url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_OVERVIEW);
        } else {
            url = String.format("%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_OVERVIEW);
        }

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.CHECKOUT_PARAMS_TRANSACTION_ID, transactionId);

        VolleyPostHelper getCheckoutOverview = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CheckoutOverview.class,
                        new CheckoutOverview.CheckoutOverviewInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                if(apiResponse.isSuccessful()){
                    CheckoutOverview obj = gson.fromJson(jsonString, CheckoutOverview.class);
                    responseHandler.onSuccess(requestCode, obj);
                } else {
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


        getCheckoutOverview.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getCheckoutOverview;

    }

    public static Request setDefaultAddress(final int requestCode, String token, int addressId, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.USER_API, APIConstants.CHECKCOUT_ADDRESS_SET_ADDRESS);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAM_ADDRESS_ID, String.valueOf(addressId));

        VolleyPostHelper setAddress = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                } else {
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                } else {

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
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

        setAddress.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return setAddress;

    }

    public static Request selectCartItemsToCheckout(final int requestCode, String token, JSONArray itemIds, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                    APIConstants.CART_API, APIConstants.CHECKOUT_SELECT_ITEMS);

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        for(int i=0;i<itemIds.length();i++){
            try {
                params.put(String.format("%s[%d]",APIConstants.CART_API, i), itemIds.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Cart.class, new Cart.CartInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                if(apiResponse.isSuccessful()){
                    Type listType = new TypeToken<ArrayList<CartItem2>>(){}.getType();
                    List<CartItem2> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                } else {
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                } else {

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
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    public static Request requestGuestAccount(final int requestCode, String firstName,
                                              String lastName, String email, String contactNumber,
                                              String title, String unitNumber, String buildingNumber,
                                              String streetNumber, String streetName, String subdivision,

                                              final ResponseHandler responseHandler){
        String url = String.format("%s/%s/", APIConstants.DOMAIN, APIConstants.GUEST_CHECKOUT_API);

        Map<String, String> params = new HashMap<String, String>();
//        params.put(APIConstants., String.valueOf(addressId));

        VolleyPostHelper setAddress = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
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

        setAddress.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return setAddress;
    }
}
