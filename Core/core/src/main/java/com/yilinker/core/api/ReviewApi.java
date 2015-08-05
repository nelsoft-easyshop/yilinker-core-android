package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.Product;
import com.yilinker.core.model.Review;
import com.yilinker.core.model.SellerReview;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;

/**
 * Created by Adur Urbano on 8/5/2015.
 */
public class ReviewApi {

    public static Request getReview(final int requestCode, String id, final ResponseHandler responseHandler) {

        Request request = new JsonObjectRequest("https://restcountries.eu/rest/v1/currency/eur", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(SellerReview.class, new SellerReview.SellerReviewInstance()).create();
                SellerReview sellerReview = gson.fromJson("{'rating':5,'reviews':[{'name':'Sir Edyuward','imageUrl':'https://www.edyuward.com','rating':5,'message':'How do I get you alone.'},{'name':'Mayordoma','imageUrl':'https://www.anglakingbaso.com','rating':0,'message':'Ehh kasi po Sir nagready na po ako ng 10 pork chop doon. Ehh hindi po naibigay ni Jona.'},{'name':'Alvin Garcia','imageUrl':'https://www.hindikomakitabaso.com','rating':5,'message':'Ate, san po yung baso?'}]}", SellerReview.class);

                responseHandler.onSuccess(requestCode, sellerReview);
                
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return request;

    }

}