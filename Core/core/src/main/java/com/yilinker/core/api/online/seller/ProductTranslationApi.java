package com.yilinker.core.api.online.seller;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import static com.yilinker.core.v2.constants.APIConstants.*;

import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.seller.Language;
import com.yilinker.core.model.seller.ProductTranslation;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jaybryantc on 5/18/16.
 */
public class ProductTranslationApi {

    public static Request getTranslation(final int requestCode, int productId, String countryCode, String languageCode, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s/%s/%s?%s=%s&%s=%s",
                APIConstants.DOMAIN.substring(0, APIConstants.DOMAIN.indexOf("3")+1),
                countryCode,
                languageCode,
                APIConstants.AUTH_API,
                PRODUCT_API,
                GET_TRANSLATION,
                APIConstants.ACCESS_TOKEN,
                BaseApplication.getInstance().getAccessToken(),
                PRODUCT_PARAM_ID,
                String.valueOf(productId));

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(ProductTranslation.class, new ProductTranslation.ProductTranslationInstance()).create();
                    handler.onSuccess(requestCode, gson.fromJson(gson.toJson(apiResponse.getData()),ProductTranslation.class));
                } else {
                    handler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request translateProduct(final int requestCode, com.yilinker.core.model.seller.request.ProductTranslation product,
                                           final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN.substring(0, APIConstants.DOMAIN.indexOf("3")+1),
                product.getCountryCode(),
                product.getLanguageCode(), APIConstants.AUTH_API, PRODUCT_API, TRANSLATE,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken());

        Map<String,String> params = new HashMap<>();
        params.put(PRODUCT_PARAM_ID, String.valueOf(product.getId()));
        params.put(PRODUCT_PARAM_NAME, product.getProductName());
        params.put(PRODUCT_PARAM_SHORT_DESCRIPTION, product.getShortDescription());
        params.put(PRODUCT_PARAM_COMPLETE_DESCRIPTION, product.getCompleteDescription());
//        params.put(PRODUCT_PARAM_BRAND, product.getBrand());
//        params.put(PRODUCT_PARAM_GROUPS, product.getProductGroups());
        params.put(PRODUCT_PARAM_IMAGES, product.getProductImages());
        params.put(PRODUCT_PARAM_VARIANTS, product.getProductVariants());

        Request request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance<>()).create();

                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    handler.onSuccess(requestCode, null);

                } else {

                    handler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request getLanguages(final int requestCode, int productId, final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                PRODUCT_API, GET_LANGUAGES,
                APIConstants.ACCESS_TOKEN, BaseApplication.getInstance().getAccessToken(),
                PRODUCT_PARAM_ID, String.valueOf(productId));

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance<>()).create();

                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Language.class, new Language.LanguageInstance()).create();

                    handler.onSuccess(requestCode, gson.fromJson(gson.toJson(apiResponse.getData()), new TypeToken<List<Language>>(){}.getType()));

                } else {

                    handler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;


    }

}
