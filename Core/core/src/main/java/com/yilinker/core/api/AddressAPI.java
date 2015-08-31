package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Address;
import com.yilinker.core.model.AddressList;
import com.yilinker.core.model.seller.BaranggayAddress;
import com.yilinker.core.model.seller.CityAddress;
import com.yilinker.core.model.seller.ProvinceAddress;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 8/14/2015.
 */
public class AddressAPI {

    public static Request addAddress (final int requestCode, String token, Address address,
                                      final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.ADDRESS_API, APIConstants.STORE_ADDRESS_ADD);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAMS_TITLE, String.valueOf(address.getAddressTitle()));
        params.put(APIConstants.ADDRESS_PARAMS_UNIT_NUMBER, String.valueOf(address.getUnitNumber()));
        params.put(APIConstants.ADDRESS_PARAMS_BUILDING_NAME, String.valueOf(address.getBuildingName()));
        params.put(APIConstants.ADDRESS_PARAMS_STREET_NUMBER, String.valueOf(address.getStreetNumber()));
        params.put(APIConstants.ADDRESS_PARAMS_STREET_NAME, String.valueOf(address.getStreetName()));
        params.put(APIConstants.ADDRESS_PARAMS_BARANGAY, String.valueOf(address.getBarangay()));
        params.put(APIConstants.ADDRESS_PARAMS_LOCATIONID, String.valueOf(address.getLocationId()));
        params.put(APIConstants.ADDRESS_PARAMS_SUBDIVISION, String.valueOf(address.getSubdivision()));
        /*params.put(APIConstants.ADDRESS_PARAMS_CITY, city);
        params.put(APIConstants.ADDRESS_PARAMS_PROVINCE, province);*/
        params.put(APIConstants.ADDRESS_PARAMS_ZIPCODE, String.valueOf(address.getZipCode()));

        VolleyPostHelper requestAddStoreAddress = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                }else{
                    responseHandler.onSuccess(requestCode, apiResponse);
                }
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

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN,
                APIConstants.AUTH_API, APIConstants.ADDRESS_API, APIConstants.GET_STORE_ADDRESS);

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

    public static Request checkoutGetAddresses(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN,
                APIConstants.AUTH_API, APIConstants.ADDRESS_API, APIConstants.GET_STORE_ADDRESS);

        Map<String, String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(AddressList.class, new AddressList.AddressListInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Type listType = new TypeToken<ArrayList<Address>>(){}.getType();
                List<Address> obj = gson.fromJson(jsonString, listType);

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

        String url = String.format("%s/%s/%s/%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.ADDRESS_API, APIConstants.ADDRESS_DELETE_ADDRESS);

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAM_ID, String.valueOf(userAddressId));

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                }else{
                    responseHandler.onSuccess(requestCode, apiResponse);
                }
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


    public static Request getAllProvinces(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN,
                 APIConstants.LOCATION_API, APIConstants.ADDRESS_GET_ALL_PROVINCES);

        Map<String, String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);

        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(ProvinceAddress.class, new ProvinceAddress.ProvinceAddressInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                ProvinceAddress[] obj = gson.fromJson(jsonString, ProvinceAddress[].class);


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

    public static Request getChildCities(final int requestCode, String token,
                                         int provinceId, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN,
                APIConstants.LOCATION_API, APIConstants.ADDRESS_GET_CHILD_CITIES);

        Map<String, String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAMS_PROVINCE_ID, String.valueOf(provinceId));

        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CityAddress.class, new CityAddress.CityAddressInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                CityAddress[] obj = gson.fromJson(jsonString, CityAddress[].class);


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

    public static Request getChildBaranggay(final int requestCode, String token,
                                         int cityId, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN,
                APIConstants.LOCATION_API, APIConstants.ADDRESS_GET_CHILD_BARANGGAY);

        Map<String, String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAMS_CITY_ID, String.valueOf(cityId));

        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(BaranggayAddress.class, new BaranggayAddress.BaranggayAddressInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                BaranggayAddress[] obj = gson.fromJson(jsonString, BaranggayAddress[].class);


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

    public static Request setAddress(final int requestCode, String token,
                                          String addressId,
                                          final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.ADDRESS_API, APIConstants.SET_DEFAULT_ADDRESS);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAMS_USER_ADDRESS_ID, addressId);


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                }

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


    public static Request editAddress (final int requestCode, String token, Address address,
                                      final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.ADDRESS_API, APIConstants.EDIT_USER_ADDRESS);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, token);
        params.put(APIConstants.ADDRESS_PARAMS_USER_ADDRESS_ID, String.valueOf(address.getUserAddressId()));
        params.put(APIConstants.ADDRESS_PARAMS_TITLE, String.valueOf(address.getAddressTitle()));
        params.put(APIConstants.ADDRESS_PARAMS_UNIT_NUMBER, String.valueOf(address.getUnitNumber()));
        params.put(APIConstants.ADDRESS_PARAMS_BUILDING_NAME, String.valueOf(address.getBuildingName()));
        params.put(APIConstants.ADDRESS_PARAMS_STREET_NUMBER, String.valueOf(address.getStreetNumber()));
        params.put(APIConstants.ADDRESS_PARAMS_STREET_NAME, String.valueOf(address.getStreetName()));
        params.put(APIConstants.ADDRESS_PARAMS_BARANGAY, String.valueOf(address.getBarangay()));
        params.put(APIConstants.ADDRESS_PARAMS_LOCATIONID, String.valueOf(address.getLocationId()));
        params.put(APIConstants.ADDRESS_PARAMS_SUBDIVISION, String.valueOf(address.getSubdivision()));
        /*params.put(APIConstants.ADDRESS_PARAMS_CITY, city);
        params.put(APIConstants.ADDRESS_PARAMS_PROVINCE, province);*/
        params.put(APIConstants.ADDRESS_PARAMS_ZIPCODE, String.valueOf(address.getZipCode()));

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                }else{
                    responseHandler.onSuccess(requestCode, apiResponse);
                }
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
