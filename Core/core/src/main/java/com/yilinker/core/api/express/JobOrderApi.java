package com.yilinker.core.api.express;

import android.net.Uri;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.MultiPartRequest2;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Address;
import com.yilinker.core.model.express.internal.JobOrder;
import com.yilinker.core.model.express.internal.PackageType;
import com.yilinker.core.model.express.internal.ProblematicJobOrder;
import com.yilinker.core.model.express.internal.ShippingFee;
import com.yilinker.core.model.express.internal.Warehouse;
import com.yilinker.core.model.express.internal.request.PackageRequest;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by J.Bautista on 2/18/16.
 */
public class JobOrderApi {

    /**
     * Get list of job orders with filter
     *
     * @param requestCode
     * @param type
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request getJobOrders(final int requestCode, String type, boolean filterByBranch, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_GET_JOB_ORDERS);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_GET_JOB_ORDERS_PARAM_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_GET_JOB_ORDERS_PARAM_STATUS, type);

        int filter = 0;
        if (filterByBranch)
            filter = 1;

        params.put(APIConstants.RIDER_GET_JOB_ORDERS_PARAM_FILTERBYBRANCH, String.valueOf(filter));

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Address.class, new JobOrder.JobOrderInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<JobOrder>>() {
                    }.getType();

                    List<JobOrder> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    /**
     * Get list of job orders
     *
     * @param requestCode
     * @param type
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request getJobOrders(final int requestCode, String type, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_GET_JOB_ORDERS);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_GET_JOB_ORDERS_PARAM_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_GET_JOB_ORDERS_PARAM_STATUS, type);


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Address.class, new JobOrder.JobOrderInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<JobOrder>>() {
                    }.getType();

                    List<JobOrder> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    /**
     * Get job order details by JO Number
     *
     * @param requestCode
     * @param joborderNo
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request getJobOrderDetailsByJONumber(final int requestCode, String joborderNo, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_GET_JODETAILS);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_GET_JODETAILS_PARAM_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_GET_JODETAILS_PARAM_JONUMBER, joborderNo);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(Address.class, new JobOrder.JobOrderInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    JobOrder obj = gson.fromJson(jsonString, JobOrder.class);

                    responseHandler.onSuccess(requestCode, obj);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    /**
     * Get joborder details by waybill number
     *
     * @param requestCode
     * @param waybillNo
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request getJobOrderDetailsByWaybillNo(final int requestCode, String waybillNo, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_GET_JODETAILS);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_GET_JODETAILS_PARAM_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_GET_JODETAILS_PARAM_WAYBILLNO, waybillNo);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    gson = GsonUtility.createGsonBuilder(Address.class, new JobOrder.JobOrderInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    JobOrder obj = gson.fromJson(jsonString, JobOrder.class);

                    responseHandler.onSuccess(requestCode, obj);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    /**
     * Updates job order status
     *
     * @param requestCode
     * @param jobOrderNo
     * @param newStatus
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request updateStatus(final int requestCode, String jobOrderNo, String newStatus, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_UPDATE_STATUS);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_UPDATE_STATUS_PARAM_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_UPDATE_STATUS_PARAM_STATUS, newStatus);
        params.put(APIConstants.RIDER_UPDATE_STATUS_PARAM_JONUMBER, jobOrderNo);

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                } else {
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }


    /**
     * Uploads signature image for a job order
     *
     * @param requestCode
     * @param jobOrderNo
     * @param image
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request uploadSignature(final int requestCode, String jobOrderNo, String image, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        BaseApplication app = BaseApplication.getInstance();

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_UPLOAD_SIGNATURE, APIConstants.RIDER_UPLOAD_SIGNATURE_PARAM_TOKEN, app.getAccessToken());

//        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_UPLOAD_SIGNATURE__PARAM_JONUMBER, jobOrderNo);
//        params.put(APIConstants.RIDER_UPLOAD_SIGNATURE_PARAM_TOKEN, app.getAccessToken());

        MultiPartRequest2 request = new MultiPartRequest2<String>(url, params, image, new Response.Listener() {
            @Override
            public void onResponse(Object response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);
//
                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, response);
                } else {

                    responseHandler.onFailed(requestCode, response.toString());

                }


            }
        }, errorHandler) {
            @Override
            public HttpEntity buildEntity(String image) {

                MultipartEntityBuilder builder = MultipartEntityBuilder.create();


                File file = new File(image);
                builder.addBinaryBody(APIConstants.RIDER_UPLOAD_SIGNATURE_PARAM_IMAGE, file, ContentType.create(CONTENT_TYPE_IMAGE), file.getName());


                Map<String, String> mHeaders = null;
                try {

                    mHeaders = getHeaders();

                    for (Map.Entry<String, String> entry : mHeaders.entrySet()) {
                        builder.addTextBody(entry.getKey(), entry.getValue());
                    }

                    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                    builder.setBoundary(MultiPartRequest2.CONTENT_BOUNDARY);

                } catch (AuthFailureError authFailureError) {
                    authFailureError.printStackTrace();
                }

                return builder.build();
            }
        };

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    /**
     * Adds joborder rating
     *
     * @param requestCode
     * @param jobOrderNo
     * @param rating
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request addRating(final int requestCode, String jobOrderNo, int rating, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_ADD_RATING);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_ADD_RATING_PARAM_JONUMBER, jobOrderNo);
        params.put(APIConstants.RIDER_ADD_RATING_PARAM_RATING, String.valueOf(rating));
        params.put(APIConstants.RIDER_ADD_RATING_PARAM_ACCESS_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {
                    responseHandler.onSuccess(requestCode, response);
                } else {
                    responseHandler.onFailed(requestCode, response.toString());
                }

                responseHandler.onSuccess(requestCode, response);

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    /***
     * Get list of warehouses
     *
     * @param requestCode
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request getWarehouses(final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_GET_WAREHOUSES);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_GET_WAREHOUSES_PARAM_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Address.class, new Warehouse.WarehouseInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

//                Type listType = new TypeToken<ArrayList<Warehouse>>() {
//                }.getType();

//                List<Warehouse> obj = gson.fromJson(jsonString, listType);

                    //Temp
                    Warehouse obj = gson.fromJson(jsonString, Warehouse.class);

                    responseHandler.onSuccess(requestCode, obj);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    /***
     * Submits details of problematic joborder
     *
     * @param requestCode
     * @param problematicJobOrder
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request reportProblematic(final int requestCode, ProblematicJobOrder problematicJobOrder, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        BaseApplication app = BaseApplication.getInstance();

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_REPORT_PROBLEMATIC, APIConstants.RIDER_REPORT_PROBLEMATIC_PARAM_TOKEN, app.getAccessToken());


        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_REPORT_PROBLEMATIC_PARAM_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_REPORT_PROBLEMATIC_PARAM_JONUMBER, problematicJobOrder.getJobOrderNo());
        params.put(APIConstants.RIDER_REPORT_PROBLEMATIC_PARAM_NOTES, problematicJobOrder.getNotes());
        params.put(APIConstants.RIDER_REPORT_PROBLEMATIC_PARAM_TYPE, problematicJobOrder.getProblemType());
//        params.put(APIConstants.RIDER_REPORT_PROBLEMATIC_PARAM_IMAGE, problematicJobOrder.getImage());

        MultiPartRequest2 request = new MultiPartRequest2<ProblematicJobOrder>(url, params, problematicJobOrder, new Response.Listener() {
            @Override
            public void onResponse(Object response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler) {
            @Override
            public HttpEntity buildEntity(ProblematicJobOrder objects) {

                MultipartEntityBuilder builder = MultipartEntityBuilder.create();

                List<String> images = objects.getImages();

                if (images != null) {

                    File file = null;

                    for (String path : images) {

                        file = new File(path);
                        builder.addBinaryBody(APIConstants.RIDER_REPORT_PROBLEMATIC_PARAM_IMAGE, file, ContentType.create(CONTENT_TYPE_IMAGE), file.getName());

                    }


                }

                Map<String, String> mHeaders = null;
                try {

                    mHeaders = getHeaders();

                    for (Map.Entry<String, String> entry : mHeaders.entrySet()) {
                        builder.addTextBody(entry.getKey(), entry.getValue());
                    }

                    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                    builder.setBoundary(MultiPartRequest2.CONTENT_BOUNDARY);

                } catch (AuthFailureError authFailureError) {
                    authFailureError.printStackTrace();
                }

                return builder.build();
            }
        };

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;

    }

    /***
     * Uploads images for a joborder
     *
     * @param requestCode
     * @param waybillNo
     * @param imageURIs
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request uploadJobOrderImages(final int requestCode, String waybillNo, List<String> imageURIs, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        BaseApplication app = BaseApplication.getInstance();

        String url = String.format("%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_UPLOAD_IMAGES, APIConstants.RIDER_UPLOAD_IMAGES_ACCESS_TOKEN, app.getAccessToken());


        Map<String, String> params = new HashMap<String, String>();
//        params.put(APIConstants.RIDER_UPLOAD_IMAGES_ACCESS_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_UPLOAD_IMAGES_WAYBILLNO, waybillNo);

        MultiPartRequest2 request = new MultiPartRequest2<List<String>>(url, params, imageURIs, new Response.Listener() {
            @Override
            public void onResponse(Object response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()){

                    responseHandler.onSuccess(requestCode, response);
                }
                else{

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }


            }
        }, errorHandler) {
            @Override
            public HttpEntity buildEntity(List<String> objects) {

                MultipartEntityBuilder builder = MultipartEntityBuilder.create();

                List<String> images = objects;

                if (images != null) {

                    File file = null;
                    Uri uri = null;

                    for (String path : images) {

//                        uri = Uri.parse(path);

                        file = new File(path);
                        builder.addBinaryBody(APIConstants.RIDER_UPLOAD_IMAGES_IMAGES, file, ContentType.create(CONTENT_TYPE_IMAGE), file.getName());

                    }


                }

                Map<String, String> mHeaders = null;
                try {

                    mHeaders = getHeaders();

                    for (Map.Entry<String, String> entry : mHeaders.entrySet()) {
                        builder.addTextBody(entry.getKey(), entry.getValue());
                    }

                    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                    builder.setBoundary(MultiPartRequest2.CONTENT_BOUNDARY);

                } catch (AuthFailureError authFailureError) {
                    authFailureError.printStackTrace();
                }

                return builder.build();
            }
        };

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return request;

    }

    /***
     * Retrieves list of package types from the server
     *
     * @param requestCode
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request getPackageTypes(final int requestCode, final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        BaseApplication app = BaseApplication.getInstance();

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_GET_PACKAGE_TYPES);


        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_UPLOAD_IMAGES_ACCESS_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Address.class, new PackageType.PackageTypeInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<PackageType>>() {
                    }.getType();

                    List<PackageType> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        RetryPolicy policy = new DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        request.setRetryPolicy(policy);

        return request;

    }


    /***
     * Calculates the shipping fee of a package
     *
     * @param requestCode
     * @param packageRequest
     * @param isUpdate
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request calculateShippingFee(final int requestCode, PackageRequest packageRequest, String isUpdate,
                                               final ResponseHandler responseHandler, final Response.ErrorListener errorHandler) {

        BaseApplication app = BaseApplication.getInstance();

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.RIDER_API, APIConstants.RIDER_CALCULATE_SHIPPING_FEE);


        Map<String, String> params = new HashMap<String, String>();
        params.put(APIConstants.RIDER_UPLOAD_IMAGES_ACCESS_TOKEN, app.getAccessToken());
        params.put(APIConstants.RIDER_CALCULATE_PACKAGE_TYPE, String.valueOf(packageRequest.getPackageTypeId()));
        params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WEIGHT, String.valueOf(packageRequest.getWeight()));

        if (packageRequest.getPackageTypeId() == 99) {

            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_LENGTH, packageRequest.getLength());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_WIDTH, packageRequest.getWidth());
            params.put(APIConstants.PRODUCT_UPLOAD_PARAM_HEIGHT, packageRequest.getHeight());

        }

        params.put(APIConstants.RIDER_ACCEPT_JOB_ORDER_PARAM_JONUMBER, packageRequest.getJobOrderNo());
        params.put(APIConstants.RIDER_IS_UPDATE_PACKAGE, String.valueOf(isUpdate));


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if (apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(ShippingFee.class, new ShippingFee.ShippingFeeInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    ShippingFee obj = gson.fromJson(jsonString, ShippingFee.class);

                    responseHandler.onSuccess(requestCode, obj);

                } else {

                    responseHandler.onFailed(requestCode, apiResponse.getMessage());

                }

            }
        }, errorHandler);

        RetryPolicy policy = new DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        request.setRetryPolicy(policy);

        return request;

    }

}
