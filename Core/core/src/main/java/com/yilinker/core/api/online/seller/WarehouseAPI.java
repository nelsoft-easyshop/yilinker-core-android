package com.yilinker.core.api.online.seller;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.constants.SellerAPIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.Warehouse;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by J.Bautista on 5/11/16.
 */
public class WarehouseAPI {

    public static Request getWarehouseList(final int requestCode, final ResponseHandler responseHandler, Response.ErrorListener errorHandler){

        String url = String.format("%s/%s",
                BaseApplication.getDomainURL(),
                SellerAPIConstants.GET_WAREHOUSE_LIST);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(SellerAPIConstants.GET_WAREHOUSE_LIST_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()){

                    gson = GsonUtility.createGsonBuilder(Warehouse.class, new Warehouse.WarehouseInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<Warehouse>>() {
                    }.getType();

                    List<Warehouse> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);

                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }


        }, errorHandler);

        return request;
    }

    public static Request deleteWarehouse(final int requestCode, final int warehouseId, final ResponseHandler responseHandler, Response.ErrorListener errorHandler){

        String url = String.format("%s/%s",
                BaseApplication.getDomainURL(),
                SellerAPIConstants.GET_WAREHOUSE_LIST);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(SellerAPIConstants.GET_WAREHOUSE_LIST_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()){

                    gson = GsonUtility.createGsonBuilder(Warehouse.class, new Warehouse.WarehouseInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<Warehouse>>() {
                    }.getType();

                    List<Warehouse> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);

                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }


        }, errorHandler);

        return request;
    }

    public static Request addWarehouse(final int requestCode, final Warehouse warehouse, final ResponseHandler responseHandler, Response.ErrorListener errorHandler){

        String url = String.format("%s/%s",
                BaseApplication.getDomainURL(),
                SellerAPIConstants.ADD_UPDATE_WAREHOUSE);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()){

                    gson = GsonUtility.createGsonBuilder(Warehouse.class, new Warehouse.WarehouseInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<Warehouse>>() {
                    }.getType();

                    List<Warehouse> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);

                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }


        }, errorHandler);

        return request;
    }

    public static Request updateWarehouse(final int requestCode, final Warehouse warehouse, final ResponseHandler responseHandler, Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%d",
                BaseApplication.getDomainURL(),
                SellerAPIConstants.ADD_UPDATE_WAREHOUSE,
                warehouse.getId());

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()){

                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());

                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }


        }, errorHandler);

        return request;
    }


}
