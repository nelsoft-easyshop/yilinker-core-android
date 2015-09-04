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
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.model.UpdateUserInfo;
import com.yilinker.core.model.seller.ProductUpload;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jaybr_000 on 8/19/2015.
 */
public class MultiPartRequest extends Request {
    private static final String KEY_PICTURE = "images[]";
    private static final String KEY_PROFILE = "profilePhoto";
    private static final String KEY_COVER = "coverPhoto";
    private static final String TAG = "MutliPartRequest";
    public final static String uploadDirectory = String.format("%s/%s", Environment.getExternalStorageDirectory().toString(), "Online Seller Temp");

    private HttpEntity mHttpEntity;
    private final Class mClass;
    private Response.Listener mListener;
    private Map<String, String> mHeaders;
    private final Gson gson;
    private ProductUpload productUpload;
    private UpdateUserInfo updateUserInfo;

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

    public MultiPartRequest(String url, UpdateUserInfo updateUserInfo,
                            Class clazz,
                            Map<String, String> headers,
                            Response.Listener listener,
                            Response.ErrorListener errorListener) {
        super(Request.Method.POST, url, errorListener);
        mHeaders = headers;
        mClass = clazz;
        mListener = listener;
        gson = new Gson();
        this.updateUserInfo = updateUserInfo;
        mHttpEntity = buildMultipartEntityStoreInfo();
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

        if (url.contains(APIConstants.PROFILE_EDIT_DETAILS)) {

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            File file  = new File(path);
            String fileName = file.getName();
            builder.addBinaryBody("profilePhoto", file, ContentType.create("image/*"), fileName);

            for (Map.Entry<String, String> entry : mHeaders.entrySet()) {
                builder.addTextBody(entry.getKey(), entry.getValue());
            }

            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.setBoundary("BOUNDARY");

            mHttpEntity = builder.build();

            Log.i("editProfile", builder.toString());

        } else {

            mHttpEntity = buildMultipartEntity(path);

        }
    }

    public MultiPartRequest(String url, Class clazz, File file, Response.Listener listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, errorListener);

        this.mHeaders = new HashMap<>();
        this.mClass = clazz;
        this.mListener = listener;
        gson = new Gson();

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        String fileName = file.getName();
        builder.addBinaryBody("image", file, ContentType.create("image/jpeg"), fileName);
        mHttpEntity = builder.build();

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
        }

        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.setBoundary("BOUNDARY");
        return builder.build();
    }

    private HttpEntity buildMultipartEntityStoreInfo() {

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        String coverPhoto = updateUserInfo.getCoverPhoto();
        if(coverPhoto!=null){
            builder.addBinaryBody(KEY_COVER, new File(updateUserInfo.getCoverPhoto()),
                    ContentType.create("image/jpeg"),updateUserInfo.getCoverPhoto());
        }

        String profilePhoto = updateUserInfo.getProfilePhoto();
        if(profilePhoto!=null){
            builder.addBinaryBody(KEY_PROFILE, new File(updateUserInfo.getProfilePhoto()),
                    ContentType.create("image/jpeg"),updateUserInfo.getProfilePhoto());
        }

        for (Map.Entry<String, String> entry : mHeaders.entrySet()) {
            builder.addTextBody(entry.getKey(), entry.getValue());
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