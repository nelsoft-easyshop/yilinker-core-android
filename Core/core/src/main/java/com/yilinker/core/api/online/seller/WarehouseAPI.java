package com.yilinker.core.api.online.seller;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
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

    public static Request updateInventory (final int requestCode, int warehouseId,int productUnit,
                                           int quantity, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_INVENTORY_API, APIConstants.SELLER_INVENTORY_UPDATE);


        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());
        params.put(APIConstants.SELLER_UPDATE_INVENTORY_WAREHOUSE_ID, String.valueOf(warehouseId));
        params.put(APIConstants.SELLER_UPDATE_INVENTORY_PRODUCT_UNIT, String.valueOf(productUnit));
        params.put(APIConstants.SELLER_UPDATE_INVENTORY_QUANTITY, String.valueOf(quantity));


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

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Case.class, new InventoryProduct.InventoryProductInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Type listType = new TypeToken<ArrayList<InventoryProduct>>(){}.getType();

                    List<InventoryProduct> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);

                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    //TODO for revision
    public static Request getInventoryFilter (final int requestCode,  final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SELLER_INVENTORY_API);//TODO add requirement for filter


        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.ACCESS_TOKEN, app.getAccessToken());

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


}
