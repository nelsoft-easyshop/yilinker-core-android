package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.product2.Product;
import com.yilinker.core.model.buyer.product2.ProductReview;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;
import static com.yilinker.core.constants.ProductAPIConstants.*;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class ProductApi2 {

    public static Request getProductDetails(final int requestCode, String id,
                                            final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint =  String.format("%s/%s?%s=%s", BaseApplication.getDomainURL(),
                                            PRODUCT_DETAIL_API, PRODUCT_ID, id);

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Product.class, new Product.ProductInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), Product.class));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    public static Request getProductReview(final int requestCode, String id,
                                            final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s", "https://www.yilinker.com/api/v4/PH/en", PRODUCT_REVIEW_API);

        Map<String, String > params = new HashMap<>();

        params.put(PRODUCT_ID, id);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ProductReview.class, new ProductReview.ProductReviewInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), ProductReview.class));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }

        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

}
