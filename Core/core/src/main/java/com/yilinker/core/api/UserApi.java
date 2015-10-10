package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Login;
import com.yilinker.core.model.Register;
import com.yilinker.core.model.UpdateUserInfo;
import com.yilinker.core.model.OAuthentication;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rlcoronado on 8/8/15.
 */
public class UserApi {

    public static Request register (final int requestCode, String firstName, String lastName, String email, String password, String contactNumber, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
        APIConstants.DOMAIN, APIConstants.USER_API, APIConstants.REG_API);

        String fullname = String.format("%s %s",firstName,lastName);
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.REG_PARAM_FIRST_NAME,firstName);
        params.put(APIConstants.REG_PARAM_LAST_NAME, lastName);
        params.put(APIConstants.REG_PARAM_EMAIL, email);
        params.put(APIConstants.REG_PARAM_PASSWORD, password);
        params.put(APIConstants.REG_PARAM_MOBILE, contactNumber);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                Register obj = gson.fromJson(response.toString(), Register.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
    });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request login (final int requestCode, String grantType, String email, String password, final ResponseHandler responseHandler){

        String url = String.format("%s/%s",
                APIConstants.DOMAIN,
                APIConstants.LOGIN_API);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.LOGIN_PARAM_CLIENT_ID, APIConstants.API_CLIENT_ID);
        params.put(APIConstants.LOGIN_PARAM_CLIENT_SECRET, APIConstants.API_CLIENT_SECRET);
        params.put(APIConstants.LOGIN_PARAM_GRANT_TYPE, grantType);
        params.put(APIConstants.LOGIN_PARAM_EMAIL, email);
        params.put(APIConstants.LOGIN_PARAM_PASSWORD, password);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                Login obj = gson.fromJson(response.toString(), Login.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                } else {

                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        message = jsonObject.getString("error_description");

                    } catch ( Exception e ) {
                        //Handle a malformed json response
                    }
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request loginFacebook (final int requestCode, String grantType, String token, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.LOGIN_FACEBOOK_API, APIConstants.AUTH_API);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.LOGIN_PARAM_CLIENT_ID, APIConstants.API_CLIENT_ID);
        params.put(APIConstants.LOGIN_PARAM_CLIENT_SECRET, APIConstants.API_CLIENT_SECRET);
        params.put(APIConstants.LOGIN_PARAM_GRANT_TYPE, grantType);
        params.put(APIConstants.TOKEN_API, token);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Login obj = gson.fromJson(jsonString, Login.class);

                    responseHandler.onSuccess(requestCode, obj);

                } else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof ServerError) {
                    responseHandler.onFailed(requestCode, "Wrong Email or Password");
                } else {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request loginGoogle (final int requestCode, String grantType, String token, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.LOGIN_GOOGLE_API, APIConstants.AUTH_API);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.LOGIN_PARAM_CLIENT_ID, APIConstants.API_CLIENT_ID);
        params.put(APIConstants.LOGIN_PARAM_CLIENT_SECRET, APIConstants.API_CLIENT_SECRET);
        params.put(APIConstants.LOGIN_PARAM_GRANT_TYPE, grantType);
        params.put(APIConstants.TOKEN_API, token);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());
                    Login obj = gson.fromJson(jsonString, Login.class);

                    responseHandler.onSuccess(requestCode, obj);

                } else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof ServerError) {
                    responseHandler.onFailed(requestCode, "Wrong Email or Password");
                } else {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request refreshToken(final int requestCode, String refreshToken, final ResponseHandler responseHandler){

        String url = String.format("%s/%s", APIConstants.DOMAIN, APIConstants.LOGIN_API);

        Map<String, String> params = new HashMap<>();
        params.put(APIConstants.LOGIN_PARAM_CLIENT_ID, APIConstants.API_CLIENT_ID);
        params.put(APIConstants.LOGIN_PARAM_CLIENT_SECRET, APIConstants.API_CLIENT_SECRET);
        params.put(APIConstants.LOGIN_PARAM_GRANT_TYPE, APIConstants.API_GRANT_TYPE);
        params.put(APIConstants.LOGIN_PARAM_REFRESH_TOKEN, refreshToken);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson =  GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                Login obj = gson.fromJson(response.toString(), Login.class);

                responseHandler.onSuccess(requestCode, obj);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request loginByUsername (final int requestCode, OAuthentication oAuth, final ResponseHandler responseHandler){

        String url = String.format("%s/%s",
                APIConstants.DOMAIN,
                APIConstants.LOGIN_API);

        Map<String,String> params = new HashMap<String,String>();
        params.put(APIConstants.LOGIN_PARAM_CLIENT_ID, oAuth.getClientId());
        params.put(APIConstants.LOGIN_PARAM_CLIENT_SECRET, oAuth.getClientSecret());
        params.put(APIConstants.LOGIN_PARAM_GRANT_TYPE, oAuth.getGrantType());
        params.put(APIConstants.LOGIN_PARAM_USERNAME, oAuth.getUsername());
        params.put(APIConstants.LOGIN_PARAM_PASSWORD, oAuth.getPassword());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                Login obj = gson.fromJson(response.toString(), Login.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof ServerError) {
                    responseHandler.onFailed(requestCode, "Wrong Email or Password");
                } else {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }

    public static Request updateUserInfo(final int requestCode, UpdateUserInfo updateUserInfo,
                                         String accessToken, final ResponseHandler responseHandler){


        String url = String.format("%s/%s/%s",APIConstants.DOMAIN, APIConstants.UPDATE_USER_API, APIConstants.USER_UPDATE_API);

        JSONObject params = new JSONObject();

        /*try {
            params.put(APIConstants.ACCESS_TOKEN, accessToken);
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_IMAGES,new Gson().toJson(productUpload.getImages()));
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CATEGORY, productUpload.getCategory());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_BRAND,productUpload.getBrand());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_TITLE,productUpload.getTitle());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DESCRIPTION,productUpload.getFullDescription());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SHORT_DESCRIPTION,productUpload.getShortDescription());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CONDITION,productUpload.getCondition());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_ISFREESHIPPING,false);
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_LENGTH,productUpload.getLength());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WEIGHT,productUpload.getWeight());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_HEIGHT,productUpload.getHeight());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WIDTH,productUpload.getWidth());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_CUSTOM_BRAND,productUpload.getBrand());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_QUANTITY,productUpload.getQuantity());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRICE,productUpload.getPrice());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_DISCOUNTED_PRICE,productUpload.getDiscountedPrice());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_SKU,"");
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_PRODUCT_PROPERTIES,productUpload.getProductProperties());

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        Request requestUpdateUserInfo = new JsonObjectRequest(url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestUpdateUserInfo.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestUpdateUserInfo;
    }
    public static Request changePassword (final int requestCode, String token, String oldPassword, String newPassword,
                                          String newPasswordConfirm, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.USER_API,
                APIConstants.CHANGE_PASSWORD_API,
                APIConstants.ACCESS_TOKEN, token);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.PROFILE_OLD_PASSWORD, oldPassword);
        params.put(APIConstants.PROFILE_NEW_PASSWORD, newPassword);
        params.put(APIConstants.PROFILE_NEW_PASSWORD_CONFIRMED, newPasswordConfirm);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(Login.class, new Login.LoginInstance()).create();
                Login obj = gson.fromJson(response.toString(), Login.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                } else {

                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        message = jsonObject.getString("error_description");

                    } catch ( Exception e ) {
                        //Handle a malformed json response
                    }
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request disableAccount (final int requestCode, String token, String password, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.ACCOUNT_API,
                APIConstants.DISABLE_USER,
                APIConstants.ACCESS_TOKEN, token);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.REG_PARAM_PASSWORD, password);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                } else if (error instanceof ServerError) {
                    responseHandler.onFailed(requestCode, "Wrong Email or Password");
                } else {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request enableEmailNotifaction (final int requestCode, String accessToken, String isSubscribed, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.LOGIN_PARAM_EMAIL,
                APIConstants.PROFILE_SUBSCRIPTION_API);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.PROFILE_ISSUBSCRIBE, isSubscribed);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                } else {

                    try {
                        String responseBody = new String(error.networkResponse.data, "utf-8" );
                        JSONObject jsonObject = new JSONObject( responseBody );
                        jsonObject = jsonObject.getJSONObject("data");
                        JSONArray errors = jsonObject.getJSONArray("errors");
                        message = errors.getString(0);

                    } catch ( Exception e ) {
                        //Handle a malformed json response
                    }
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request enableSmsNotification (final int requestCode, String accessToken, String isSubscribed, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN,
                APIConstants.AUTH_API,
                APIConstants.SMS_API,
                APIConstants.PROFILE_SUBSCRIPTION_API);

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.ACCESS_TOKEN, accessToken);
        params.put(APIConstants.PROFILE_ISSUBSCRIBE, isSubscribed);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                responseHandler.onSuccess(requestCode, apiResponse);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = APIConstants.API_CONNECTION_PROBLEM;

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    message = APIConstants.API_CONNECTION_PROBLEM;

                } else if (error instanceof AuthFailureError) {

                    message = APIConstants.API_CONNECTION_AUTH_ERROR;

                } else {

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
                }

                responseHandler.onFailed(requestCode, message);
            }
        });

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }
}