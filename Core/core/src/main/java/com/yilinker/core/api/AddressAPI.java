package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Address;
import com.yilinker.core.model.AddressList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 8/14/2015.
 */
public class AddressAPI {

    public static Request addAddress (final int requestCode, String token,
                                      String addressTitle, String unitNumber,
                                      String buildingName, String streetNumber,
                                      String streetName, String barangay,
                                      String subdivision, String city,
                                      String province, String zipCode,
                                      String additionalInfo,
                                      final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.ADDRESS_API, APIConstants.STORE_ADDRESS_ADD);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAMS_TITLE, addressTitle);
        params.put(APIConstants.ADDRESS_PARAMS_UNIT_NUMBER, unitNumber);
        params.put(APIConstants.ADDRESS_PARAMS_BUILDING_NAME, buildingName);
        params.put(APIConstants.ADDRESS_PARAMS_STREET_NUMBER, streetNumber);
        params.put(APIConstants.ADDRESS_PARAMS_STREET_NAME, streetName);
        params.put(APIConstants.ADDRESS_PARAMS_BARANGAY, barangay);
        params.put(APIConstants.ADDRESS_PARAMS_SUBDIVISION, subdivision);
        params.put(APIConstants.ADDRESS_PARAMS_CITY, city);
        params.put(APIConstants.ADDRESS_PARAMS_PROVINCE, province);
        params.put(APIConstants.ADDRESS_PARAMS_ZIPCODE, zipCode);
        params.put(APIConstants.ADDRESS_PARAMS_ADDITIONAL_INFO, additionalInfo);

        VolleyPostHelper requestAddStoreAddress = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Address.class, new Address.StoreAddressInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Address obj = gson.fromJson(jsonString, Address.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestAddStoreAddress.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestAddStoreAddress;
    }

    public static Request getAddresses(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.ADDRESS_API, APIConstants.ADDRESS_GET_ADDRESSES);

        Map<String, String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(AddressList.class, new AddressList.AddressListInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Address[] obj = gson.fromJson(jsonString, Address[].class);

                responseHandler.onSuccess(requestCode, obj);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        getAddresses.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getAddresses;
    }

    public static Request requestSetAddress(final int requestCode, String token, String addressId, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.ADDRESS_API, APIConstants.ADDRESS_SET_ADDRESS);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAM_ID, addressId);

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

    public static Request deleteAddress(final int requestCode, String token, int userAddressId, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.ADDRESS_API, APIConstants.ADDRESS_DELETE_ADDRESS, APIConstants.ACCESS_TOKEN, token);

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.ADDRESS_PARAM_ID, String.valueOf(userAddressId));

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

}
