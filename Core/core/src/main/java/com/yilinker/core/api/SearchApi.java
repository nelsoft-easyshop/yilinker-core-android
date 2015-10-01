package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Search;
import com.yilinker.core.model.TransactionList;
import com.yilinker.core.model.seller.CategoryProducts;
import com.yilinker.core.model.seller.SearchTransaction;
import com.yilinker.core.model.seller.SearchTransactionList;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 8/26/2015.
 */
public class SearchApi {

    public static Request getSearchKeywords(final int requestCode, String keyword, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.PRODUCT_API, APIConstants.GET_SEARCH_PRODUCT,
                APIConstants.SEARCH_QUERY, keyword);

        Request requestGetSearch = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Search.class, new Search.SearchInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                Type listType = new TypeToken<ArrayList<Search>>() {
                }.getType();

                List<Search> obj = gson.fromJson(jsonString, listType);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestGetSearch.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetSearch;

    }

    public static Request getSearchStore(final int requestCode, String keyword, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.STORE_API, APIConstants.GET_SEARCH,
                APIConstants.SEARCH_QUERY, keyword);

        Request requestGetSearch = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Search.class, new Search.SearchInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());

                Type listType = new TypeToken<ArrayList<Search>>() {
                }.getType();

                List<Search> obj = gson.fromJson(jsonString, listType);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        requestGetSearch.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetSearch;

    }

    public static Request searchTransaction(final int requestCode, String token, String query, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.SEARCH_TRANSACTION_API, APIConstants.SELLER_PARAMS_SEARCH_KEYWORD,
                APIConstants.ACCESS_TOKEN, token,
                APIConstants.SEARCH_QUERY_TRANSACTION, query);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(SearchTransaction.class, new SearchTransaction.SearchTransactionInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                SearchTransaction[] obj = gson.fromJson(jsonString, SearchTransaction[].class);

                responseHandler.onSuccess(requestCode, obj);

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
                responseHandler.onFailed(requestCode, message);
            }
        });

        requestGetCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetCart;

    }

    public static Request searchProductNameSuggestion(final int requestCode, String token, String query, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.PRODUCT_MANAGEMENT_API, APIConstants.PRODUCT_NAME_API,
                APIConstants.ACCESS_TOKEN, token,
                APIConstants.SEARCH_QUERY, query);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(CategoryProducts.class, new CategoryProducts.CategoryProductsInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                CategoryProducts[] obj = gson.fromJson(jsonString, CategoryProducts[].class);



                responseHandler.onSuccess(requestCode, obj);

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
                responseHandler.onFailed(requestCode, message);
            }
        });

        requestGetCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetCart;

    }

    public static Request searchRiderNameSuggestion(final int requestCode, String token,
                                                    String query, int perPage, int pageNo, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s&%s=%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.RIDER_NAME_API,
                APIConstants.ACCESS_TOKEN, token,
                APIConstants.SEARCH_QUERY, query,
                APIConstants.SEARCH_PER_PAGE, perPage,
                APIConstants.SEARCH_PAGE, pageNo);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse);
                }else{
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
                responseHandler.onFailed(requestCode, message);
            }
        });

        requestGetCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetCart;

    }

    public static Request getTransactionList(final int requestCode, String accessToken, String productName, String riderName, final ResponseHandler responseHandler) {

        String endpoint =  "";
        if(riderName.isEmpty()) {
             endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_LIST_API,
                    APIConstants.ACCESS_TOKEN, accessToken, APIConstants.PRODUCT_PARAMS_PRODUCT_NAME, productName);
        }else if(productName.isEmpty()){
            endpoint = String.format("%s/%s/%s?%s=%s&%s=%s", APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.SELLER_TRANSACTION_LIST_API,
                    APIConstants.ACCESS_TOKEN, accessToken, APIConstants.RIDER_NAME_PARAMS, riderName);
        }
        endpoint = endpoint.replace(" ", "%20");
        Request request = new JsonObjectRequest(endpoint, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(SearchTransactionList.class, new SearchTransactionList.SearchTransactionListInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    SearchTransactionList obj = gson.fromJson(jsonString, SearchTransactionList.class);

                    responseHandler.onSuccess(requestCode, obj);

                }else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String message = APIConstants.API_CONNECTION_PROBLEM;
                try {
                    String responseBody = new String(error.networkResponse.data, "utf-8" );
                    JSONObject jsonObject = new JSONObject( responseBody );
                    jsonObject = jsonObject.getJSONObject("data");
                    JSONArray errors = jsonObject.getJSONArray("errors");
                    message = errors.getString(0);

                } catch ( JSONException e ) {
                    //Handle a malformed json response
                } catch (UnsupportedEncodingException e){

                }
                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

}
