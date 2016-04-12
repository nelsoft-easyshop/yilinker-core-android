package com.yilinker.core.api.express;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Address;
import com.yilinker.core.model.express.internal.Bank;
import com.yilinker.core.model.express.internal.CashDetail;
import com.yilinker.core.model.express.internal.JobOrder;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by patrick-villanueva on 4/7/2016.
 */
public class BankInformationApi {

    public static Request getBankInformation (final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler){
//          TODO add url for get Bank Information
        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.RIDER_API);


        BaseApplication app = BaseApplication.getInstance();

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.RIDER_GET_CASHDETAILS_PARAM_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Bank.class, new Bank.BankInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<Bank>>() {
                    }.getType();

                    List<Bank> obj = gson.fromJson(jsonString, listType);

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
