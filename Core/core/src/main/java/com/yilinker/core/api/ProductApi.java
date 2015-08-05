package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Product;
import com.yilinker.core.model.ProductReview;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class ProductApi {

    public static Request getProductDetails(final int requestCode, String id, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_GET_DETAILS);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

//                Gson gson = GsonUtility.createGsonBuilder(Product.class, new Product.ProductInstance()).create();
//                Product product = gson.fromJson("{'id':1000,'title':'adur','shortDescription':'asdh asjdha lkjas','fullDescription':'uiiw kdpo aksjwi jhdu','sellerId':111004179,'attributes':[{'id':100,'name':'groupName','items':[{'id':200,'name':'Samsung'},{'id':300,'name':'Apple'},{'id':400,'name':'Blackberry'}]}],'availableAttributeCombi':[{'combination':[{'id':112233,'id2':332211},{'id':445566,'id2':665544}],'quantity':100,'images':[]}],'originalPrice':0,'newPrice':0,'discount':0.5}", Product.class);

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(GsonUtility.convertJSONObjtoJsonObj(response), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Product.class, new Product.ProductInstance()).create();
                try {

                    JSONObject obj = new JSONObject(apiResponse.getData());

                    Product product = gson.fromJson(GsonUtility.convertJSONObjtoJsonObj(obj), Product.class);

                    responseHandler.onSuccess(requestCode, product);

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

    public static Request getProductReview(final int requestCode, String id, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s", APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.PRODUCT_GET_DETAILS);

        Request request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

//                Gson gson = GsonUtility.createGsonBuilder(ProductReview.class, new ProductReview.ProductReviewInstance()).create();
//                ProductReview productReview = gson.fromJson("{'rating':5,'reviews':[{'name':'Sir Edyuward','imageUrl':'https://www.edyuward.com','rating':5,'message':'How do I get you alone.'},{'name':'Mayordoma','imageUrl':'https://www.anglakingbaso.com','rating':0,'message':'Ehh kasi po Sir nagready na po ako ng 10 pork chop doon. Ehh hindi po naibigay ni Jona.'},{'name':'Alvin Garcia','imageUrl':'https://www.hindikomakitabaso.com','rating':5,'message':'Ate, san po yung baso?'}]}", ProductReview.class);

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(GsonUtility.convertJSONObjtoJsonObj(response), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(ProductReview.class, new ProductReview.ProductReviewInstance()).create();
                try {

                    JSONObject obj = new JSONObject(apiResponse.getData());

                    ProductReview productReview = gson.fromJson(GsonUtility.convertJSONObjtoJsonObj(obj), ProductReview.class);

                    responseHandler.onSuccess(requestCode, productReview);

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