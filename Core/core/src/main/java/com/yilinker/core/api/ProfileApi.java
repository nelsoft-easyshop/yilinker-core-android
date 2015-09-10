package com.yilinker.core.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.MultiPartRequest;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Profile;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adur Urbano on 8/26/2015.
 */
public class ProfileApi {

    public static Request getUserDetails(final int requestCode, String token, final ResponseHandler responseHandler) {

        String url = String.format("%s/%s/%s/%s?%s=%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.PROFILE_API, APIConstants.PROFILE_GET_DETAILS,
                APIConstants.ACCESS_TOKEN, token);

        Request requestGetCart = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                gson = GsonUtility.createGsonBuilder(Profile.class, new Profile.ProfileInstance()).create();
                String jsonString = new Gson().toJson(apiResponse.getData());
                Profile obj = gson.fromJson(jsonString, Profile.class);

                responseHandler.onSuccess(requestCode, obj);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
            }
        });


        requestGetCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

        return requestGetCart;

    }

    public static Request updateUserDetails (final int requestCode, String token, File profilePhoto, String coverPhoto,
                                             String firstName, String lastName, String contactNumber, String gender,
                                             String birthDate, String nickName, String slug, String oldPassword,
                                             String newPassword, String newPasswordConfirm, String userAddressId,
                                             String locationId, String title, String unitNumber, String buildingName,
                                             String streetNumber, String streetName, String subdivision, String zipCode,
                                             String streetAddress, String longitude, String latitude, String landline,
                                             boolean isProfilePictureEmpty, final ResponseHandler responseHandler){

        String url = String.format("%s/%s/%s/%s",
                APIConstants.DOMAIN, APIConstants.AUTH_API, APIConstants.PROFILE_API, APIConstants.PROFILE_EDIT_DETAILS);

        Map<String, String> params = new HashMap<String, String>();
        //params.put(APIConstants.ACCESS_TOKEN, token);
        if (!isProfilePictureEmpty)
            params.put(APIConstants.PROFILE_PHOTO, profilePhoto.getName());
        //params.put(APIConstants.PROFILE_COVER_PHOTO, coverPhoto);
        params.put(APIConstants.PROFILE_FIRST_NAME, firstName);
        params.put(APIConstants.PROFILE_LAST_NAME, lastName);
        params.put(APIConstants.PROFILE_CONTACT_NUMBER, contactNumber);
        params.put(APIConstants.PROFILE_GENDER, gender);
//        params.put(APIConstants.PROFILE_BIRTH_DATE, birthDate);
//        params.put(APIConstants.PROFILE_NICK_NAME, nickName);
//        params.put(APIConstants.PROFILE_SLUG, slug);
//        params.put(APIConstants.PROFILE_OLD_PASSWORD, oldPassword);
//        params.put(APIConstants.PROFILE_NEW_PASSWORD, newPassword);
//        params.put(APIConstants.PROFILE_NEW_PASSWORD_CONFIRMED, newPasswordConfirm);
        params.put(APIConstants.PROFILE_USER_ADDRESS_ID, userAddressId);
        if (locationId != null)
            params.put(APIConstants.PROFILE_LOCATION_ID, locationId);
        if (title != null)
            params.put(APIConstants.PROFILE_TITLE, title);
        if (unitNumber != null)
            params.put(APIConstants.PROFILE_UNIT_NUMBER, unitNumber);
        if (buildingName != null)
            params.put(APIConstants.PROFILE_BUILDING_NAME, buildingName);
        if (streetNumber != null)
            params.put(APIConstants.PROFILE_STREET_NUMBER, streetNumber);
        if (streetName != null)
            params.put(APIConstants.PROFILE_STREET_NAME, streetName);
        if (subdivision != null)
            params.put(APIConstants.PROFILE_SUBDIVISION, subdivision);
        if (zipCode != null)
            params.put(APIConstants.PROFILE_ZIP_CODE, zipCode);
//        params.put(APIConstants.PROFILE_STREET_ADDRESS, streetAddress);
//        params.put(APIConstants.PROFILE_LONGITUDE, longitude);
//        params.put(APIConstants.PROFILE_LATITUDE, latitude);
//        params.put(APIConstants.PROFILE_LANDLINE, landline);

        StringBuilder stringBuilder = new StringBuilder();

        for(String key:params.keySet()) {
            stringBuilder.append(key+"="+params.get(key)+"&");
        }

        url = String.format("%s?%s=%s",url,APIConstants.ACCESS_TOKEN, token);

        if (!isProfilePictureEmpty) {
            MultiPartRequest multiPartRequest = new MultiPartRequest(url, profilePhoto.getPath(), APIResponse.class, params, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                    APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                    if (apiResponse.isSuccessful()) {
                        responseHandler.onSuccess(requestCode, apiResponse.isSuccessful());
                    } else {
                        responseHandler.onFailed(requestCode, apiResponse.getMessage());
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            });

            multiPartRequest.setRetryPolicy(SocketTimeout.getRetryPolicy());

            return multiPartRequest;
        }
        else {
            VolleyPostHelper requestUpdateCart = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {

                    Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                    APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                    if (apiResponse.isSuccessful()) {
                        responseHandler.onSuccess(requestCode, apiResponse.isSuccessful());
                    } else {
                        responseHandler.onFailed(requestCode, apiResponse.getMessage());
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    responseHandler.onFailed(requestCode, APIConstants.API_CONNECTION_PROBLEM);
                }
            });

            requestUpdateCart.setRetryPolicy(SocketTimeout.getRetryPolicy());

            return requestUpdateCart;
        }
    }
}