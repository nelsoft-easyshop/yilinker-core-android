package com.yilinker.core.api.online.seller;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.constants.SellerAPIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.InventoryProductFilter;
import com.yilinker.core.model.seller.InventoryProductList;
import com.yilinker.core.model.seller.Warehouse;
import com.yilinker.core.model.seller.request.WarehouseInventory;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.model.seller.request.WarehouseProductFilter;
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

        String url = String.format("%s/%s/%s",
                BaseApplication.getDomainURL(),
                APIConstants.AUTH_API,
                SellerAPIConstants.GET_WAREHOUSE_LIST);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());

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

        String url = String.format("%s/%s/%s",
                BaseApplication.getDomainURL(),
                APIConstants.AUTH_API,
                SellerAPIConstants.DELETE_WAREHOUSE);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(SellerAPIConstants.DELETE_WAREHOUSE_PARAM_ID, String.valueOf(warehouseId));

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

    public static Request addWarehouse(final int requestCode, final com.yilinker.core.model.seller.request.Warehouse warehouse, final ResponseHandler responseHandler, Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s",
                BaseApplication.getDomainURL(),
                APIConstants.AUTH_API,
                SellerAPIConstants.ADD_UPDATE_WAREHOUSE);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_NAME, warehouse.getName());
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_ADDRESS, warehouse.getAddress());
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_LOCATION, String.valueOf(warehouse.getSelectedLocation()));
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_ZIPCODE, warehouse.getZipCode());


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

    public static Request updateWarehouse(final int requestCode, final com.yilinker.core.model.seller.request.Warehouse warehouse, final ResponseHandler responseHandler, Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s",
                BaseApplication.getDomainURL(),
                APIConstants.AUTH_API,
                SellerAPIConstants.ADD_UPDATE_WAREHOUSE);

        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_ID, String.valueOf(warehouse.getId()));
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_NAME, warehouse.getName());
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_ADDRESS, warehouse.getAddress());
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_LOCATION, String.valueOf(warehouse.getSelectedLocation()));
        params.put(SellerAPIConstants.ADD_UPDATE_WAREHOUSE_PARAM_ZIPCODE, warehouse.getZipCode());

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



    public static Request updateInventory (final int requestCode, WarehouseInventory product, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                SellerAPIConstants.UPDATE_WAREHOUSE_INVENTORY);


        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(SellerAPIConstants.UPDATE_WAREHOUSE_INVENTORY_PARAM_WAREHOUSE_ID, String.valueOf(product.getWarehouseId()));
        params.put(SellerAPIConstants.UPDATE_WAREHOUSE_INVENTORY_PARAM_PRODUCT_UNIT, String.valueOf(product.getId()));
        params.put(SellerAPIConstants.UPDATE_WAREHOUSE_INVENTORY_PARAM_QUANTITY, String.valueOf(product.getQuantity()));


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


        JsonObjectRequest request =  new JsonObjectRequest( formarGetInventoryProductURL(filter), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {


                    gson = GsonUtility.createGsonBuilder(InventoryProductList.class, new InventoryProductList.InventoryProductListInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    InventoryProductList obj = gson.fromJson(jsonString, InventoryProductList.class);


                    responseHandler.onSuccess(requestCode, obj);

                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }


    private static String formarGetInventoryProductURL(WarehouseProductFilter filter){

        String url = String.format("%s/%s/%s?",
                APIConstants.DOMAIN,APIConstants.AUTH_API,
                SellerAPIConstants.WAREHOUSE_INVENTORY_API);

        //Format GET URL
        StringBuilder builder = new StringBuilder();

        BaseApplication app = BaseApplication.getInstance();

        builder.append(url);
        builder.append(String.format("%s=%s&", APIConstants.ACCESS_TOKEN, app.getAccessToken()));
        builder.append(String.format("%s=%d&", SellerAPIConstants.GET_WAREHOUSE_INVENTORY_PARAM_ID, filter.getWarehouseId()));
        builder.append(String.format("%s=%d", SellerAPIConstants.GET_WAREHOUSE_INVENTORY_PARAM_PAGE_ID, filter.getPageId()));

        if (filter.getFilter()!=null){

            for (Map.Entry<String, Integer[]> entry : filter.getFilter().entrySet() ){

                builder.append("&");
                builder.append(String.format("%s=%s", entry.getKey(), new Gson().toJson(entry.getValue())));
            }
        }

        return builder.toString();
    }

    public static Request getInventoryFilter (final int requestCode,  final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                SellerAPIConstants.GET_WAREHOUSE_INVENTORY_FILTER);


        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(InventoryProductFilter.class, new InventoryProductFilter.InventoryProductFilterInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    InventoryProductFilter obj = gson.fromJson(jsonString, InventoryProductFilter.class);

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
