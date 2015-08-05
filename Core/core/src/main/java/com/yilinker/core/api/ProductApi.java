package com.yilinker.core.api;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.Product;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class ProductApi {


    public static Request getProductDetails(final int requestCode, String id, final ResponseHandler responseHandler) {


        Request request = new JsonObjectRequest("https://restcountries.eu/rest/v1/currency/eur", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //Sample
                Gson gson = GsonUtility.createGsonBuilder(Product.class, new Product.ProductInstance()).create();
                Product product = gson.fromJson("{'id':1000,'title':'adur','shortDescription':'asdh asjdha lkjas','fullDescription':'uiiw kdpo aksjwi jhdu','sellerId':111004179,'attributes':[{'id':100,'name':'groupName','items':[{'id':200,'name':'Samsung'},{'id':300,'name':'Apple'},{'id':400,'name':'Blackberry'}]}],'availableAttributeCombi':[{'combination':[{'id':112233,'id2':332211},{'id':445566,'id2':665544}],'quantity':100,'images':[]}],'originalPrice':0,'newPrice':0,'discount':0.5}", Product.class);


                responseHandler.onSuccess(requestCode, product);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

        return request;
    }
}