package com.yilinker.core.api.online.seller;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.CountrySetup;
import com.yilinker.core.model.seller.InventoryFilter;
import com.yilinker.core.model.seller.request.CountryStoreSaveCombination;
import com.yilinker.core.model.seller.request.CountryStoreSetInventoryLocation;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by patVillanueva on 5/17/2016.
 */
public class CountryStoreAPI {

    public static Request getCountrySetUp (final int requestCode,int productId, String code, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        //Todo to be edited
        String url = String.format("%s/ph/en/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_COUNTRY_STORE_SETUP_API);

        //Todo to be deleted
        url = url.replace("v1","v3");

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
//        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
//        params.put(APIConstants.PRODUCT_ID, String.valueOf(productId));
//        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_CODE, code);
        params.put(APIConstants.ACCESS_TOKEN, "NzFmNDJlOTcxOWY5MTE1OTc0MjlmZTQ4ZWE4MzdlYmZiMTc3ZTc4ZDJmMDgxYjdlZDUxOTljOGUzOTg2Njc5Ng");
        params.put(APIConstants.PRODUCT_ID, "30571");
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_CODE, "ph");

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CountrySetup.class, new CountrySetup.CountrySetupInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                CountrySetup obj = gson.fromJson(jsonString, CountrySetup.class);

                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, obj);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    public static Request setWarehouse(final int requestCode, final CountryStoreSetInventoryLocation location,
                                final ResponseHandler responseHandler,final Response.ErrorListener errorHandler){


        //todo to be edited
        String url = String.format("%s/ph/en/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_COUNTRY_STORE_SETUP_API,APIConstants.SELLER_COUNTRY_STORE_SET_WAREHOUSE);

        //todo to be deleted
        url = url.replace("v1","v3");

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
//        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(APIConstants.ACCESS_TOKEN, "NzFmNDJlOTcxOWY5MTE1OTc0MjlmZTQ4ZWE4MzdlYmZiMTc3ZTc4ZDJmMDgxYjdlZDUxOTljOGUzOTg2Njc5Ng");
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_CODE, location.getCode());
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_PRODUCT_ID, location.getProductId());
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_USER_WAREHOUSE, location.getUserWarehouse());
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_LOGISTICS, location.getLogistics());
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_IS_COD, String.valueOf(location.isCod()));
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_HANDLING_FEE, location.getHandlingFee());
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_PRIORITY, location.getPriority());


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    public static Request saveCombination(final int requestCode, final CountryStoreSaveCombination combination,
                                       final ResponseHandler responseHandler,final Response.ErrorListener errorHandler){


        //todo to be edited
        String url = String.format("%s/ph/en/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_COUNTRY_STORE_SETUP_API,APIConstants.SELLER_COUNTRY_STORE_SET_WAREHOUSE);

        //todo to be deleted
        url = url.replace("v1","v3");

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
//        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(APIConstants.ACCESS_TOKEN, "NzFmNDJlOTcxOWY5MTE1OTc0MjlmZTQ4ZWE4MzdlYmZiMTc3ZTc4ZDJmMDgxYjdlZDUxOTljOGUzOTg2Njc5Ng");
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_CODE, combination.getCode());
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_PRODUCT_ID, combination.getProductId());
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_PRODUCT_UNIT_ID, String.valueOf(combination.getProductUnitId()));
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_PRICE, String.valueOf(combination.getPrice()));
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_DISCOUNTED_PRICE, String.valueOf(combination.getDiscountedPrice()));
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_COMMISSION, String.valueOf(combination.getCommission()));
        params.put(APIConstants.SELLER_COUNTRY_STORE_PARAMS_STATUS, String.valueOf(combination.getStatus()));


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }


    public static Request getCountryStore (final int requestCode,int productId, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        //Todo to be edited
        String url = String.format("%s/ph/en/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_COUNTRY_STORE_SETUP_API,
                APIConstants.SELLER_COUNTRY_STORE_API);

        //Todo to be deleted
        url = url.replace("v1","v3");

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
//        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
//        params.put(APIConstants.PRODUCT_ID, String.valueOf(productId));
        params.put(APIConstants.ACCESS_TOKEN, "NzFmNDJlOTcxOWY5MTE1OTc0MjlmZTQ4ZWE4MzdlYmZiMTc3ZTc4ZDJmMDgxYjdlZDUxOTljOGUzOTg2Njc5Ng");
        params.put(APIConstants.PRODUCT_ID, "30571");

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CountrySetup.class, new CountrySetup.CountrySetupInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                CountrySetup obj = gson.fromJson(jsonString, CountrySetup.class);

                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, obj);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }


}
