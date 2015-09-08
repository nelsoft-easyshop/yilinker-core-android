package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.SalesReport;
import com.yilinker.core.utility.GsonUtility;

import org.json.JSONObject;

/**
 * Created by jaybr_000 on 9/6/2015.
 */
public class SalesReportApi {

    static int socketTimeout = 300000;
    static RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    public static Request getSalesReport(String accessToken, String dateFrom, String dateTo, final int requestCode, final ResponseHandler responseHandler) {

        String endpoint = String.format("%s/%s/%s/%s?%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API,
                APIConstants.MERCHANT_API, APIConstants.SALES_REPORT_API,
                APIConstants.ACCESS_TOKEN, accessToken);

        if (dateFrom != null && dateTo != null) {

            endpoint = String.format("%s&%s=%s&%s=%s", endpoint, APIConstants.SALES_REPORT_PARAM_DATE_FROM, dateFrom,
                    APIConstants.SALES_REPORT_PARAM_DATE_TO, dateTo);

        }

        endpoint = endpoint.replace(" ", "%20");

        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {

                    Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                    APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                    if (apiResponse.isSuccessful()) {

                        gson = GsonUtility.createGsonBuilder(SalesReport.class, new SalesReport.SalesReportInstance()).create();
                        String jsonString = gson.toJson(apiResponse.getData());
                        SalesReport salesReport = gson.fromJson(jsonString, SalesReport.class);

                        responseHandler.onSuccess(requestCode, salesReport);
                    } else {

                        responseHandler.onFailed(requestCode, apiResponse.getMessage());

                    }


                }

            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    String message = "An error occured.";
                    if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                        message = "No connection available.";
                    } else if (error instanceof AuthFailureError) {
                        message = "Authentication Failure.";
                    } else if (error instanceof ServerError) {
                        message = "Server error.";
                    } else if (error instanceof NetworkError) {
                        message = "Network Error.";
                    } else if (error instanceof ParseError) {
                        message = "Parse error.";
                    }
                    responseHandler.onFailed(requestCode,message);

                }

            });

        request.setRetryPolicy(policy);

        return request;
    }

}
