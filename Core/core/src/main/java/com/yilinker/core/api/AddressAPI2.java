package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.BaranggayAddress;
import com.yilinker.core.model.CityAddress;
import com.yilinker.core.model.CountryAddress;
import com.yilinker.core.model.ProvinceAddress;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by J.Bautista on 5/12/16.
 */
public class AddressAPI2 {

    public static Request getAllCountries(final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorListener) {

        String url = String.format("%s/%s/%s", BaseApplication.getDomainURL(),
                APIConstants.LOCATION_API, APIConstants.ADDRESS_GET_COUNTRY);

        //temp
        url = url.replace("v3/PH/EN", "v1");

        String token = BaseApplication.getInstance().getAccessToken();

        Map<String, String> params = new HashMap<String,String>();

        if(token!=null)
            params.put(APIConstants.ADDRESS_GET_COUNTRY_PARAM_TOKEN, token);


        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(CountryAddress.class, new CountryAddress.CountryAddressInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Type listType = new TypeToken<ArrayList<CountryAddress>>() {
                    }.getType();

                    List<CountryAddress> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorListener);

        getAddresses.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getAddresses;
    }

    public static Request getAllProvinces(final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorListener) {

        String url = String.format("%s/%s/%s", BaseApplication.getDomainURL(),
                APIConstants.LOCATION_API, APIConstants.ADDRESS_GET_ALL_PROVINCES);

        String token = BaseApplication.getInstance().getAccessToken();

        Map<String, String> params = new HashMap<String,String>();

        if(token!=null)
            params.put(APIConstants.ACCESS_TOKEN, token);


        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(ProvinceAddress.class, new ProvinceAddress.ProvinceAddressInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Type listType = new TypeToken<ArrayList<ProvinceAddress>>() {
                    }.getType();

                    List<ProvinceAddress> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorListener);

        getAddresses.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getAddresses;
    }

    public static Request getChildProvinces(final int requestCode, int countryId,final ResponseHandler responseHandler, final Response.ErrorListener errorListener) {

        String url = String.format("%s/%s/%s", BaseApplication.getDomainURL(),
                APIConstants.LOCATION_API, APIConstants.ADDRESS_GET_CHILD_PROVINCES);

        //temp
        url = url.replace("v3/PH/EN", "v1");

        String token = BaseApplication.getInstance().getAccessToken();

        Map<String, String> params = new HashMap<String,String>();

        if(token!=null)
            params.put(APIConstants.ACCESS_TOKEN, token);

        params.put(APIConstants.ADDRESS_GET_CHILD_PROVINCES_PARAM_REGIONID, String.valueOf(countryId));


        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(ProvinceAddress.class, new ProvinceAddress.ProvinceAddressInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Type listType = new TypeToken<ArrayList<ProvinceAddress>>() {
                    }.getType();

                    List<ProvinceAddress> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorListener);

        getAddresses.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getAddresses;
    }

    public static Request getChildCities(final int requestCode,
                                         int provinceId, final ResponseHandler responseHandler, final Response.ErrorListener errorListener) {

        String url = String.format("%s/%s/%s", BaseApplication.getDomainURL(),
                APIConstants.LOCATION_API, APIConstants.ADDRESS_GET_CHILD_CITIES);

        //temp
        url = url.replace("v3/PH/EN", "v1");

        String token = BaseApplication.getInstance().getAccessToken();

        Map<String, String> params = new HashMap<String,String>();

        if(token!=null)
            params.put(APIConstants.ACCESS_TOKEN, token);

        params.put(APIConstants.ADDRESS_PARAMS_PROVINCE_ID, String.valueOf(provinceId));

        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(CityAddress.class, new CityAddress.CityAddressInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<CityAddress>>() {
                    }.getType();

                    List<CityAddress> obj = gson.fromJson(jsonString, listType);


                    responseHandler.onSuccess(requestCode, obj);

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }
            }
        }, errorListener);

        getAddresses.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getAddresses;
    }

    public static Request getChildBaranggay(final int requestCode,
                                            int cityId, final ResponseHandler responseHandler, final Response.ErrorListener errorListener) {

        String url = String.format("%s/%s/%s", BaseApplication.getDomainURL(),
                APIConstants.LOCATION_API, APIConstants.ADDRESS_GET_CHILD_BARANGGAY);

        //temp
        url = url.replace("v3/PH/EN", "v1");

        String token = BaseApplication.getInstance().getAccessToken();

        Map<String, String> params = new HashMap<String,String>();

        if(token!=null)
            params.put(APIConstants.ACCESS_TOKEN, token);

        params.put(APIConstants.ADDRESS_PARAMS_CITY_ID, String.valueOf(cityId));

        VolleyPostHelper getAddresses =  new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(BaranggayAddress.class, new BaranggayAddress.BaranggayAddressInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<BaranggayAddress>>() {
                    }.getType();

                    List<BaranggayAddress> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorListener);

        getAddresses.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return getAddresses;
    }
}
