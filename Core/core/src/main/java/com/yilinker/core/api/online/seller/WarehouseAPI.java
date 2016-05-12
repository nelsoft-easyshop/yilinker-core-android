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
import com.yilinker.core.model.seller.Inventory;
import com.yilinker.core.model.seller.InventoryFilter;
import com.yilinker.core.model.seller.Warehouse;
import com.yilinker.core.model.seller.request.WarehouseUpdateInventory;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Case;
import com.yilinker.core.model.express.internal.Bank;
import com.yilinker.core.model.seller.InventoryProduct;
import com.yilinker.core.model.seller.request.WarehouseProductFilter;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

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


    public static Request updateInventory (final int requestCode, final WarehouseUpdateInventory inventory, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_INVENTORY_API, APIConstants.SELLER_INVENTORY_UPDATE);


        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(APIConstants.SELLER_UPDATE_INVENTORY_WAREHOUSE_ID, String.valueOf(inventory.getWarehouseId()));
        params.put(APIConstants.SELLER_UPDATE_INVENTORY_PRODUCT_UNIT, String.valueOf(inventory.getProductUnit()));
        params.put(APIConstants.SELLER_UPDATE_INVENTORY_QUANTITY, String.valueOf(inventory.getQuantity()));


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

    public static Request getInventoryProducts (final int requestCode, final WarehouseProductFilter filter, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,APIConstants.AUTH_API,
                APIConstants.SELLER_INVENTORY_API, APIConstants.SELLER_INVENTORY_UPDATE);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(APIConstants.SELLER_UPDATE_INVENTORY_WAREHOUSE_ID, String.valueOf(filter.getWarehouseId()));
        params.put(APIConstants.SELLER_INVENTORY_PAGE_ID, String.valueOf(filter.getPageId()));

        if (filter.getFilter()!=null){

            for (Map.Entry<String, String[]> entry : filter.getFilter().entrySet() ){
                params.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Inventory.class, new Inventory.InventoryInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                Inventory obj = gson.fromJson(jsonString, Inventory.class);

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

    public static Request getInventoryFilter (final int requestCode,  final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_INVENTORY_API,APIConstants.SELLER_INVENTORY_FILTER_API);


        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(InventoryFilter.class, new InventoryFilter.InventoryFilterInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                InventoryFilter obj = gson.fromJson(jsonString, InventoryFilter.class);

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
