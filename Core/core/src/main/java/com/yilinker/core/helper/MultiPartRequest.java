package com.yilinker.core.helper;

import android.os.Environment;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yilinker.core.model.AttributeCombinationUpload;
import com.yilinker.core.model.ProductUpload;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by jaybr_000 on 8/19/2015.
 */
public class MultiPartRequest extends Request {
    private static final String KEY_PICTURE = "images[]";
    private static final String TAG = "MutliPartRequest";
    public final static String uploadDirectory = String.format("%s/%s", Environment.getExternalStorageDirectory().toString(), "Online Seller Temp");

    private HttpEntity mHttpEntity;
    private final Class mClass;
    private Response.Listener mListener;
    private Map<String, String> mHeaders;
    private final Gson gson;
    private ProductUpload productUpload;

    public MultiPartRequest(String url, File file,
                            Class clazz,
                            Map<String, String> headers,
                            Response.Listener listener,
                            Response.ErrorListener errorListener) {
        super(Request.Method.POST, url, errorListener);
        mHeaders = headers;
        mClass = clazz;
        mListener = listener;
        gson = new Gson();
        mHttpEntity = buildMultipartEntity(file);
    }

    public MultiPartRequest(String url, ProductUpload productUpload,
                            Class clazz,
                            Map<String, String> headers,
                            Response.Listener listener,
                            Response.ErrorListener errorListener) {
        super(Request.Method.POST, url, errorListener);
        mHeaders = headers;
        mClass = clazz;
        mListener = listener;
        gson = new Gson();
        this.productUpload = productUpload;
        mHttpEntity = buildMultipartEntity();
    }

    public MultiPartRequest(String url, String path,
                            Class clazz,
                            Map<String, String> headers,
                            Response.Listener listener,
                            Response.ErrorListener errorListener) {
        super(Request.Method.POST, url, errorListener);
        mHeaders = headers;
        mClass = clazz;
        mListener = listener;
        gson = new Gson();
        mHttpEntity = buildMultipartEntity(path);
    }

    private HttpEntity buildMultipartEntity(String path) {
        File file = new File(path);
        return buildMultipartEntity(file);
    }

    private HttpEntity buildMultipartEntity(File file) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        String fileName = file.getName();
        builder.addBinaryBody(KEY_PICTURE, file, ContentType.create("image/jpeg"), fileName);
        return builder.build();
    }

    private HttpEntity buildMultipartEntity() {

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        for(String image:productUpload.getImages()) {
            builder.addBinaryBody(KEY_PICTURE, new File(uploadDirectory,image),ContentType.create("image/jpeg"),image);
//            builder.addPart(KEY_PICTURE, new FileBody(new File(uploadDirectory,image),ContentType.create("image/jpeg"),image));
        }

        if(productUpload.getAttributeCombinationUploadList().size() !=  0){

            for(AttributeCombinationUpload attributeCombinationUpload:productUpload.getAttributeCombinationUploadList()){

                for(String image2:attributeCombinationUpload.getImages()){

                    builder.addBinaryBody(KEY_PICTURE, new File(uploadDirectory,image2),ContentType.create("image/jpeg"),image2);
//                    builder.addPart(KEY_PICTURE, new FileBody(new File(uploadDirectory,image2),ContentType.create("image/jpeg"),image2));
                }

            }
        }

        for (Map.Entry<String, String> entry : mHeaders.entrySet()) {
            builder.addTextBody(entry.getKey(), entry.getValue());
//            try {
//                builder.addPart(entry.getKey(),new StringBody(entry.getValue()));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
        }

        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.setBoundary("BOUNDARY");
        return builder.build();
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

//        mHeaders.put("Content-Type", "multipart/form-data; boundary=" + "BOUNDARY"  + "; charset=utf-8");
        mHeaders.put("Content-Type","multipart/form-data; charset=utf-8");
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
}