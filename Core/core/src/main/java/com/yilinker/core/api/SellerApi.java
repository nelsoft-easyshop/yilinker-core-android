package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Seller;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class SellerApi {

    public static Request getSellerDetails(final int requestCode, int id, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%d", APIConstants.DOMAIN, APIConstants.SELLER_API, APIConstants.SELLER_GET_DETAILS, APIConstants.SELLER_GET_DETAILS_PARAM_ID, id);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

//                Gson gson = GsonUtility.createGsonBuilder(Seller.class, new Seller.SellerInstance()).create();
//                Seller seller = gson.fromJson("{'id':1000001,'name':'Claudia Buenavista','specialty':'Pole Dancing','logoUrl':'https://www.logo.com','images':['1000000001','1000000002','1000000003'],'description':'Don\u2019t make me close one more door! I dont wanna hurt anymore. Stay in my arms if you dare, just I imagined you there.','contactNo':9101122334}", Seller.class);

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(GsonUtility.convertJSONObjtoJsonObj(response), APIResponse.class);


                gson = GsonUtility.createGsonBuilder(Seller.class, new Seller.SellerInstance()).create();
                try {

                    JSONObject obj = new JSONObject(apiResponse.getData());

                    Seller seller = gson.fromJson(GsonUtility.convertJSONObjtoJsonObj(obj), Seller.class);

                    responseHandler.onSuccess(requestCode, seller);

                } catch (JSONException e) {

                    responseHandler.onFailed(requestCode, "Invalid data");
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return request;

    }

}