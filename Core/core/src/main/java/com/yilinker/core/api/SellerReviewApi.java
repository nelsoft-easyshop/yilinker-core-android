package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.Product;
import com.yilinker.core.model.SellerReview;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class SellerReviewApi {

//    public static SellerReview getReviewBySellerId(int requestCode, String id){
//        Gson gson = GsonUtility.createGsonBuilder(SellerReview.class, new SellerReview.SellerReviewInstance()).create();
//        return gson.fromJson("{'rating':5,'reviews':[{'name':'Sir Edyuward','imageUrl':'https://www.edyuward.com','rating':5,'message':'How do I get you alone.'},{'name':'Mayordoma','imageUrl':'https://www.anglakingbaso.com','rating':0,'message':'Ehh kasi po Sir nagready na po ako ng 10 pork chop doon. Ehh hindi po naibigay ni Jona.'},{'name':'Alvin Garcia','imageUrl':'https://www.hindikomakitabaso.com','rating':5,'message':'Ate, san po yung baso?'}]}", SellerReview.class);
//    }

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