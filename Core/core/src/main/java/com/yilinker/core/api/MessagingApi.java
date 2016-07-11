package com.yilinker.core.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.GsonRequest;
import com.yilinker.core.helper.MultiPartRequest;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.responses.EvGetContactsResp;
import com.yilinker.core.responses.EvGetConversationHeadResp;
import com.yilinker.core.responses.EvGetConversationMessagesResp;
import com.yilinker.core.responses.EvImageAttachResp;
import com.yilinker.core.responses.EvSendMessageResp;
import com.yilinker.core.responses.EvSetConversationAsReadResp;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by J.Bautista
 * <p>
 * Includes methods for api requests and response parsers related to messaging
 */
public class MessagingApi
{
    private static final Logger logger = Logger.getLogger(MessagingApi.class.getSimpleName());

    // Request Codes
    public static final int RC_SEND_MESSAGE = 2200;
    public static final int RC_GET_CONVERSATION_HEAD = 2201;
    public static final int RC_GET_CONTACTS = 2202;
    public static final int RC_GET_CONVERSATION_MESSAGES = 2203;
    public static final int RC_SET_CONVERSATION_AS_READ = 2204;
    public static final int RC_IMAGE_ATTACH = 2205;

    public static Request sendMessage(String accessToken, Integer recipientId, String message,
                                      boolean image, final ResponseHandler handler)
    {
        // Build endpoint
        String endpoint = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.MESSAGING_API, APIConstants.SEND_MESSAGE);

        // Build request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.MESSAGING_PARAM_ACCESS_TOKEN, accessToken);
        params.put(APIConstants.MESSAGING_PARAM_RECIPIENT_ID, Integer.toString(recipientId));
        params.put(APIConstants.MESSAGING_PARAM_MESSAGE, message);

        if(image){
            params.put(APIConstants.MESSAGING_PARAM_IS_IMAGE, "1");
        }else{
            params.put(APIConstants.MESSAGING_PARAM_IS_IMAGE, "0");
        }
        /**
         * TODO Include when server is fixed
         */
        //params.put(APIConstants.MESSAGING_PARAM_IS_IMAGE, String.valueOf(isImage));

        // Build request
        Request<EvSendMessageResp> request = new GsonRequest<>(Request.Method.POST, endpoint, params,
                EvSendMessageResp.class, new GsonRequest.GsonResponseListener<EvSendMessageResp>()
        {
            @Override
            public void onResponse(EvSendMessageResp object)
            {
                handler.onSuccess(RC_SEND_MESSAGE, object);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                String message = null;

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

                handler.onFailed(RC_SEND_MESSAGE, message);
            }
        });

        //request.setTag(RC_SEND_MESSAGE);
        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    /**
     * Get conversation head
     * @param accessToken
     * @param page
     * @param limit
     * @param handler
     * @return
     */
    public static Request getConversationHead(String accessToken, int page, int limit, final ResponseHandler handler)
    {
        // Build endpoint
        String endpoint = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.MESSAGING_API, APIConstants.GET_CONVERSATION_HEAD);

        // Build request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.MESSAGING_PARAM_ACCESS_TOKEN, accessToken);
        params.put(APIConstants.MESSAGING_PARAM_PAGE, String.valueOf(page));
        params.put(APIConstants.MESSAGING_PARAM_LIMIT, String.valueOf(limit));

        // Build request
        Request<EvGetConversationHeadResp> request = new GsonRequest<>(Request.Method.POST, endpoint, params,
                EvGetConversationHeadResp.class, new GsonRequest.GsonResponseListener<EvGetConversationHeadResp>()
        {
            @Override
            public void onResponse(EvGetConversationHeadResp object)
            {
                handler.onSuccess(RC_GET_CONVERSATION_HEAD, object);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                String message = null;

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

                handler.onFailed(RC_GET_CONVERSATION_HEAD, message);
            }
        });

        //request.setTag(RC_GET_CONVERSATION_HEAD);
        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    /**
     * Get contacts
     * @param accessToken
     * @param page
     * @param limit
     * @param keyword
     * @param handler
     * @return
     */
    public static Request getContacts(String accessToken, int page, int limit, String keyword, final ResponseHandler handler)
    {
        // Build endpoint
        String endpoint = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.MESSAGING_API, APIConstants.GET_CONTACTS);

        // Build request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.MESSAGING_PARAM_ACCESS_TOKEN, accessToken);
        params.put(APIConstants.MESSAGING_PARAM_PAGE, String.valueOf(page));
        params.put(APIConstants.MESSAGING_PARAM_LIMIT, String.valueOf(limit));
        params.put(APIConstants.MESSAGING_PARAM_KEYWORD, keyword);

        // Build request
        Request<EvGetContactsResp> request = new GsonRequest<>(Request.Method.POST, endpoint, params,
                EvGetContactsResp.class, new GsonRequest.GsonResponseListener<EvGetContactsResp>()
        {
            @Override
            public void onResponse(EvGetContactsResp object)
            {
                handler.onSuccess(RC_GET_CONTACTS, object);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                String message = null;

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

                handler.onFailed(RC_GET_CONTACTS, message);
            }
        });

        //request.setTag(Integer.toString(RC_GET_CONTACTS));
        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    /**
     * Get conversation messages
     * @param accessToken
     * @param userId
     * @param page
     * @param limit
     * @param handler
     * @return
     */
    public static Request getConversationMessages(String accessToken, int userId, int page,
                                                  int limit, final ResponseHandler handler)
    {
        // Build endpoint
        String endpoint = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.MESSAGING_API, APIConstants.GET_CONVERSATION_MESSAGES);

        // Build request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.MESSAGING_PARAM_ACCESS_TOKEN, accessToken);
        params.put(APIConstants.MESSAGING_PARAM_USER_ID, String.valueOf(userId));
        params.put(APIConstants.MESSAGING_PARAM_PAGE, String.valueOf(page));
        params.put(APIConstants.MESSAGING_PARAM_LIMIT, String.valueOf(limit));

        // Build request
        Request<EvGetConversationMessagesResp> request = new GsonRequest<>(Request.Method.POST, endpoint, params,
                EvGetConversationMessagesResp.class, new GsonRequest.GsonResponseListener<EvGetConversationMessagesResp>()
        {
            @Override
            public void onResponse(EvGetConversationMessagesResp object)
            {
                handler.onSuccess(RC_GET_CONVERSATION_MESSAGES, object);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                String message = null;

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

                handler.onFailed(RC_GET_CONVERSATION_MESSAGES, message);
            }
        });

        //request.setTag(RC_GET_CONVERSATION_MESSAGES);
        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }


    public static Request setConversationAsRead(String accessToken, int userId, final ResponseHandler handler)
    {
        // Build endpoint
        String endpoint = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.MESSAGING_API, APIConstants.SET_CONVERSATION_AS_READ);

        // Build request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.MESSAGING_PARAM_ACCESS_TOKEN, accessToken);
        params.put(APIConstants.MESSAGING_PARAM_USER_ID, String.valueOf(userId));

        // Build request
        Request<EvSetConversationAsReadResp> request = new GsonRequest<>(Request.Method.POST, endpoint, params,
                EvSetConversationAsReadResp.class, new GsonRequest.GsonResponseListener<EvSetConversationAsReadResp>()
        {
            @Override
            public void onResponse(EvSetConversationAsReadResp object)
            {
                handler.onSuccess(RC_SET_CONVERSATION_AS_READ, object);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                String message = null;

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

                handler.onFailed(RC_SET_CONVERSATION_AS_READ, message);
            }
        });

        //request.setTag(RC_SET_CONVERSATION_AS_READ);
        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;
    }

    public static Request attachImage(String accessToken, File file, final int requestCode,final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.MESSAGING_API, APIConstants.IMAGE_ATTACH, APIConstants.ACCESS_TOKEN, accessToken);

        MultiPartRequest multiPartRequest = new MultiPartRequest(url, EvImageAttachResp.class, file, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                Gson gson = GsonUtility.createGsonBuilder(EvImageAttachResp.class, new EvImageAttachResp.EvImageAttachRespInstance()).create();
                EvImageAttachResp evImageAttachResp = gson.fromJson(response.toString(), EvImageAttachResp.class);

                responseHandler.onSuccess(requestCode, evImageAttachResp);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = null;

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

        multiPartRequest.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return multiPartRequest;
    }
}