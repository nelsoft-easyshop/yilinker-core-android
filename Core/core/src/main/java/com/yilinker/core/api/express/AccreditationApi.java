package com.yilinker.core.api.express;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.helper.VolleyPostHelper;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.model.APIResponse;
import com.yilinker.core.model.Address;
import com.yilinker.core.model.express.internal.AccreditationRequirement;
import com.yilinker.core.model.express.internal.JobOrder;
import com.yilinker.core.model.express.internal.request.Accreditation;
import com.yilinker.core.utility.GsonUtility;
import com.yilinker.core.utility.SocketTimeout;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by J.Bautista on 3/18/16.
 */
public class AccreditationApi {

    /***
     * Retrieves the list of requirements for accreditation
     * @param requestCode
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request getRequirements(final int requestCode, final ResponseHandler responseHandler, Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, ExpressAPIConstants.PARTNERS_API, ExpressAPIConstants.ACCREDITATION_GET_REQUIREMENTS);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(ExpressAPIConstants.ACCREDITATION_GET_REQUIREMENTS_PARAM_TOKEN, app.getAccessToken());

        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    gson = GsonUtility.createGsonBuilder(Address.class, new AccreditationRequirement.AccreditationRequirementInstance()).create();
                    String jsonString = new Gson().toJson(apiResponse.getData());

                    Type listType = new TypeToken<ArrayList<AccreditationRequirement>>() {
                    }.getType();

                    List<AccreditationRequirement> obj = gson.fromJson(jsonString, listType);

                    responseHandler.onSuccess(requestCode, obj);
                }
                else{
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }

    /***
     * Submits the accreditation to the server
     * @param requestCode
     * @param accreditation
     * @param responseHandler
     * @param errorHandler
     * @return
     */
    public static Request submitAccreditation(final int requestCode, Accreditation accreditation,final ResponseHandler responseHandler, Response.ErrorListener errorHandler){

        String url = String.format("%s/%s/%s",
                APIConstants.DOMAIN, ExpressAPIConstants.PARTNERS_API, ExpressAPIConstants.ACCREDITATION_SUBMIT);

        BaseApplication app = BaseApplication.getInstance();

        Map<String, String> params = new HashMap<String, String>();
        params.put(ExpressAPIConstants.ACCREDITATION_SUBMIT_PARAM_TOKEN, app.getAccessToken());
        params.put(ExpressAPIConstants.ACCREDITATION_SUBMIT_PARAM_FIRSTNAME, accreditation.getFirstName());
        params.put(ExpressAPIConstants.ACCREDITATION_SUBMIT_PARAM_LASTNAME, accreditation.getLastName());
        params.put(ExpressAPIConstants.ACCREDITATION_SUBMIT_PARAM_BIRTHDAY, accreditation.getBirthday());
        params.put(ExpressAPIConstants.ACCREDITATION_SUBMIT_PARAM_GENDER, accreditation.getFirstName());
        params.put(ExpressAPIConstants.ACCREDITATION_SUBMIT_PARAM_REQUIREMENTS, accreditation.getRequirements());


        VolleyPostHelper request = new VolleyPostHelper(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Gson gson = GsonUtility.createGsonBuilder(APIResponse.class, new APIResponse.APIResponseInstance()).create();
                APIResponse apiResponse = gson.fromJson(response.toString(), APIResponse.class);

                if(apiResponse.isSuccessful()) {

                    responseHandler.onSuccess(requestCode, apiResponse.getMessage());
                }
                else{
                    responseHandler.onFailed(requestCode, apiResponse.getMessage());
                }

            }
        }, errorHandler);

        request.setRetryPolicy(SocketTimeout.getRetryPolicy());
        return request;
    }
}
