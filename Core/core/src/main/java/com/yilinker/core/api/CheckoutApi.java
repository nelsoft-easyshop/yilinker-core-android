package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.MultiPartRequest;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Address;
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

import java.io.File;
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
        Map<String, String> params = new HashMap<>();
        if(!isGuest) {

            url = String.format("%s/%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.AUTH_API,
                    APIConstants.CHECKOUT_PAYMENT_API,
                    APIConstants.CHECKOUT_PAYMENT_COD);
            params.put(APIConstants.ACCESS_TOKEN, token);

        } else {

            url = String.format("%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_COD);

        }

        VolleyPostHelper payUsingCod = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CheckoutOverview.class, new CheckoutOverview.CheckoutOverviewInstance()).create();
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
                if (error.networkResponse.statusCode == 401) {
                    responseHandler.onFailed(requestCode, "Authentication Problem.");
                    return;
                }
                try {
                    String responseBody = new String(error.networkResponse.data, "utf-8" );
                    JSONObject jsonObject = new JSONObject( responseBody );
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray errors = jsonObject.getJSONArray("errors");
                    message = errors.getString(0);

                } catch ( JSONException e ) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e){

                } catch (NullPointerException npe) {
                    npe.printStackTrace();
                }
                responseHandler.onFailed(requestCode, message);
            }
        });


        payUsingCod.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return payUsingCod;

    }

    public static Request payViaPesoPay(final int requestCode, boolean isGuest, String token, final ResponseHandler responseHandler) {

        String url;
        Map<String, String> params = new HashMap<String, String>();
        if(!isGuest) {
            url = String.format("%s/%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.CHECKOUT_PAYMENT_API,
                    APIConstants.CHECKOUT_PAYMENT_PESOPAY);
            params.put(APIConstants.ACCESS_TOKEN, token);

        } else {
            url = String.format("%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API,
                    APIConstants.CHECKOUT_PAYMENT_PESOPAY);
        }

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
                if (error.networkResponse.statusCode == 401) {
                    responseHandler.onFailed(requestCode, "Authentication Problem.");
                    return;
                }
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
        Map<String, String> params = new HashMap<String, String>();

        if(!isGuest) {
            url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_OVERVIEW);
            params.put(APIConstants.ACCESS_TOKEN, token);
        } else {
            url = String.format("%s/%s/%s",
                    APIConstants.DOMAIN, APIConstants.CHECKOUT_PAYMENT_API, APIConstants.CHECKOUT_PAYMENT_OVERVIEW);
        }

        params.put(APIConstants.CHECKOUT_PARAMS_TRANSACTION_ID, transactionId);
        params.put(APIConstants.CHECKOUT_TRANSACTION_CLEAR, "true");

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
                if (error.networkResponse.statusCode == 401) {
                    responseHandler.onFailed(requestCode, "Authentication Problem.");
                    return;
                }
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

                if (error.networkResponse.statusCode == 401) {
                    responseHandler.onFailed(requestCode, "Authentication Problem.");
                    return;
                }

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

    public static Request selectCartItemsToCheckout(final int requestCode, String token, JSONArray itemIds, boolean isGuest, final ResponseHandler responseHandler){

        String url;
        Map<String, String> params = new HashMap<>();

        if(!isGuest){
            url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                    APIConstants.CART_API, APIConstants.CHECKOUT_SELECT_ITEMS);
            params.put(APIConstants.ACCESS_TOKEN, token);
        } else {
            url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.CART_API,
                    APIConstants.CHECKOUT_SELECT_ITEMS);
        }

        if(!itemIds.toString().equals("[]")){

            for(int i=0;i<itemIds.length();i++){
                try {
                    params.put(String.format("%s[%d]",APIConstants.CART_API, i), itemIds.getString(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

    public static Request requestGuestAccount(final int requestCode, Address address, String firstName,
                                              String lastName, String mobileNumber, String emailAddress,
                                              final ResponseHandler responseHandler){
        String url = String.format("%s/%s", APIConstants.DOMAIN, APIConstants.GUEST_CHECKOUT_API);

        Map<String, String> params = new HashMap<String, String>();

        params.put(String.format("%s[%s]", APIConstants.GUEST_USER_PARAMS, APIConstants.GUEST_PARAMS_FIRST_NAME), firstName);
        params.put(String.format("%s[%s]", APIConstants.GUEST_USER_PARAMS, APIConstants.GUEST_PARAMS_LAST_NAME), lastName);
//        params.put(String.format("%s[%s]", APIConstants.GUEST_USER_PARAMS, APIConstants.GUEST_PARAMS_EMAIL), emailAddress);
        params.put(String.format("%s[%s]", APIConstants.GUEST_USER_PARAMS, APIConstants.GUEST_PARAMS_CONTACT_NUMBER), mobileNumber);

//        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_TITLE), String.valueOf(address.getAddressTitle()));
//        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_UNIT_NUMBER), String.valueOf(address.getUnitNumber()));
//        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_BUILDING_NAME), String.valueOf(address.getBuildingName()));
//        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_STREET_NUMBER), String.valueOf(address.getStreetNumber()));
        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_STREET_NAME), String.valueOf(address.getStreetName()));
//        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_SUBDIVISION), String.valueOf(address.getSubdivision()));
        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_ZIPCODE), String.valueOf(address.getZipCode()));
        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_ISDEFAULT), String.valueOf("1"));
        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_LOCATION), String.valueOf(address.getLocationId()));
        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_LATITUDE),address.getLatitude());
        params.put(String.format("%s[%s]", APIConstants.GUEST_ADDRESS_PARAMS, APIConstants.ADDRESS_PARAMS_LONGITUDE),address.getLongitude());
//        JSONArray guestAddress = new JSONArray();
//        JSONArray guestDetails = new JSONArray();
//        JSONObject guestData = new JSONObject();
//
//        try {
//
//            guestData.put(APIConstants.REG_PARAM_FIRST_NAME, firstName);
//            guestData.put(APIConstants.REG_PARAM_LAST_NAME, lastName);
//            guestData.put(APIConstants.REG_PARAM_EMAIL, emailAddress);
//            guestData.put(APIConstants.REG_PARAM_MOBILE, mobileNumber);
//
//            guestDetails.put(guestData);
//
//            guestData = new JSONObject();
//
//            guestData.put(APIConstants.ADDRESS_PARAMS_TITLE, String.valueOf(address.getAddressTitle()));
//            guestData.put(APIConstants.ADDRESS_PARAMS_UNIT_NUMBER, String.valueOf(address.getUnitNumber()));
//            guestData.put(APIConstants.ADDRESS_PARAMS_BUILDING_NAME, String.valueOf(address.getBuildingName()));
//            guestData.put(APIConstants.ADDRESS_PARAMS_STREET_NUMBER, String.valueOf(address.getStreetNumber()));
//            guestData.put(APIConstants.ADDRESS_PARAMS_STREET_NAME, String.valueOf(address.getStreetName()));
//            guestData.put(APIConstants.ADDRESS_PARAMS_SUBDIVISION, String.valueOf(address.getSubdivision()));
//            guestData.put(APIConstants.ADDRESS_PARAMS_ZIPCODE, String.valueOf(address.getZipCode()));
//            guestData.put(APIConstants.ADDRESS_PARAMS_LOCATIONID, String.valueOf(address.getLocationId()));
//
//            guestAddress.put(guestData);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        params.put("user_guest", guestDetails.toString());
//        params.put("user_address", guestAddress.toString());

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

    public static Request updateBasicInfo (final int requestCode, String token, String firstName, String lastName,
                                             String contactNumber, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.CHECKOUT_UPDATE_BASIC_INFO);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.CHECKOUT_FIRST_NAME, firstName);
        params.put(APIConstants.CHECKOUT_LAST_NAME, lastName);
        params.put(APIConstants.CHECKOUT_MOBILE_PHONE, contactNumber);

        url = String.format("%s?%s=%s",url,APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

//                if (apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse.getData());
//                } else {
//                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
//                }

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
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request verifyNumber (final int requestCode, String token, String contactNumber,
                                        String verificationCode,final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.CHECKOUT_TOKEN, APIConstants.CHECKOUT_VALIDATE);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.CHECKOUT_CONTACT_NUMBER, contactNumber);
        params.put(APIConstants.CHECKOUT_VERIFICATION_CODE, verificationCode);

        url = String.format("%s?%s=%s",url,APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse.getData());
                } else {
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

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
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }
}
