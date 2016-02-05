package com.yilinker.core.helper;

import android.os.Environment;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.yilinker.core.model.UpdateUserInfo;
import com.yilinker.core.model.seller.AttributeCombinationUpload;
import com.yilinker.core.model.seller.ProductUpload;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by J.Bautista
 */
public abstract class MultiPartRequest2<T> extends Request {

    public static final String CONTENT_TYPE_IMAGE = "image/jpeg";

    private HttpEntity mHttpEntity;
    private Response.Listener mListener;
    private Map<String, String> mHeaders;
    private final Gson gson;

    public MultiPartRequest2(String url,
                            Map<String, String> headers, T objects,
                            Response.Listener listener,
                            Response.ErrorListener errorListener) {

        super(Request.Method.POST, url, errorListener);
        mHeaders = headers;
        mListener = listener;
        gson = new Gson();
        mHttpEntity = buildEntity(objects);
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

//        mHeaders.put("Content-Type", "multipart/form-data; boundary=" + "BOUNDARY"  + "; charset=utf-8");
        mHeaders.put("Content-Type","multipart/form-data; charset=utf-8");
        mHeaders.put("Accept", "application/json");
        return mHeaders != null ? mHeaders : super.getHeaders();
//        return mHeaders;
    }

    @Override
    public String getBodyContentType() {
        return mHttpEntity.getContentType().getValue();
//        return "multipart/form-data; boundary=" +  "BOUNDARY" + "; charset=utf-8";
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            mHttpEntity.writeTo(bos);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(Object response) {
        mListener.onResponse(response);
    }


    @Override
    public int compareTo(Object another) {
        return 0;
    }


    public abstract HttpEntity buildEntity(T objects);
}
