package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.buyer.seller2.Seller;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;
import static com.yilinker.core.constants.SellerDetailsAPIConstants.*;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adur Urbano on 7/4/2016.
 */
public class SellerApi2 {

    public static Request getSellerDetails(final int requestCode, String id, boolean isAuthorize,
                                            final ResponseHandler handler, Response.ErrorListener errorListener) {

        String endpoint;
        String accessToken = BaseApplication.getInstance().getAccessToken();

        Map<String, String > params = new HashMap<>();

        params.put(SELLER_USER_ID, id);

        if (accessToken != null && isAuthorize) {

            endpoint = String.format("%s/%s/%s", "http://online.api.easydeal.ph/api/v3/PH/en", APIConstants.AUTH_API,
                                        SELLER_DETAIL_API);
            params.put(APIConstants.ACCESS_TOKEN, accessToken);

        } else {

            endpoint = String.format("%s/%s", "http://online.api.easydeal.ph/api/v3/PH/en", SELLER_DETAIL_API);

        }

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, endpoint, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse api = gson.fromJson(response.toString(), APIResponse.class);

                if (api.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Seller.class, new Seller.SellerInstance()).create();

                    handler.onSuccess(requestCode,
                            gson.fromJson(gson.toJson(api.getData()), Seller.class));

                } else {

                    handler.onFailed(requestCode, api.getMessage());

                }

            }

        }, errorListener);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

}
