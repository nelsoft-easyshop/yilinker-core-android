package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.Product;
import com.yilinker.core.model.Seller;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class SellerApi {

    public static Request getSellerDetails(final int requestCode, String id, final ResponseHandler responseHandler) {

        Request request = new JsonObjectRequest("https://restcountries.eu/rest/v1/currency/eur", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(Seller.class, new Seller.SellerInstance()).create();
                Seller seller = gson.fromJson("{'id':1000001,'name':'Claudia Buenavista','specialty':'Pole Dancing','logoUrl':'https://www.logo.com','images':['1000000001','1000000002','1000000003'],'description':'Don\u2019t make me close one more door! I dont wanna hurt anymore. Stay in my arms if you dare, just I imagined you there.','contactNo':9101122334}", Seller.class);

                responseHandler.onSuccess(requestCode, seller);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return request;

    }

}