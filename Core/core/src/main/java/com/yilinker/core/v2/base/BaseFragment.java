package com.yilinker.core.v2.base;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yilinker.core.R;
import com.yilinker.core.api.UserApi;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.ErrorMessages;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.v2.constants.RequestCodes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adur Urbano on 1/5/2016.
 */
public abstract class BaseFragment extends Fragment implements ResponseHandler, View.OnClickListener {

    /**
     * Reference of baseApplication
     */
    public BaseApplication baseApplication;

    /**
     * Reference of RequestQueue
     */
    private RequestQueue requestQueue;

    /**
     * Reference of Requests
     */
    private List<Request> requestList = new ArrayList<>();

    /**
     * Boolean for Toolbar
     */
    private boolean hasToolbar = false;

    /**
     * Integer for layoutID
     */
    private int layoutId = 0;

    /**
     * String for toolbar title
     */
    private String toolbarTitle = null;

    /**
     * Reference of Frame Layout to be inflated
     */
    private FrameLayout flBaseContainer;

    /**
     * Reference of Progress Bar
     */
    private RelativeLayout rlProgressBar;

    /**
     * Reference of Reload Layout
     */
    public RelativeLayout rlReload;

    /**
     * Reference of TextView to be inflated with error messages
     */
    public TextView tvError;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //declaration of application to be used by classes extending this base class
        baseApplication = (BaseApplication) getActivity().getApplicationContext();

        //initialization of request queue
        requestQueue = Volley.newRequestQueue(getActivity());

        //passing of data through arguments
        initData(getArguments());

        //initialization of layout id, toolbar, and request tags
        initMain();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.v2_activity_base, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initialization of views in base
        flBaseContainer = (FrameLayout) view.findViewById(R.id.flBaseContainer);
        rlProgressBar   = (RelativeLayout) view.findViewById(R.id.rlProgressBar);
        rlReload        = (RelativeLayout) view.findViewById(R.id.rlReload);
        tvError         = (TextView) view.findViewById(R.id.tvError);

        if (layoutId != 0) {

            inflateView(flBaseContainer, layoutId);

            initViews(view, savedInstanceState);

        }

        if (hasToolbar) {

            View viewFragment = view.findViewById(R.id.header);

            ((TextView) viewFragment.findViewById(R.id.tvHeaderName)).setText(toolbarTitle == null ? "" : toolbarTitle);

        } else {

            (view.findViewById(R.id.header)).setVisibility(View.GONE);

        }

        //setting onClickListener for rlReload if request failed
        rlReload.setOnClickListener(this);

    }

    @Override
    public void onPause() {
        super.onPause();

        //cancels request when activity pauses
        this.cancelRequests();

    }

    private static final Field sChildFragmentManagerField;

    static {

        Field f = null;

        try {

            f = Fragment.class.getDeclaredField("mChildFragmentManager");
            f.setAccessible(true);

        } catch (NoSuchFieldException e) {

            Log.e("Field", "Error getting mChildFragmentManager field", e);

        }

        sChildFragmentManagerField = f;

    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (sChildFragmentManagerField != null) {

            try {

                sChildFragmentManagerField.set(this, null);

            } catch (Exception e) {

                Log.e("Seller", "Error setting mChildFragmentManager field", e);

            }

        }

    }

    @Override
    public void onSuccess(int requestCode, Object object) {

        switch (requestCode) {

            case RequestCodes.REQUEST_CODE_REFRESH_TOKEN:
                handleRefreshToken(object);
                break;

        }

        //showed frame layout and hid progress loader
        handleSuccessfulRequest();

        //hid progress bar
        changeProgressBarVisibility(false);

        //remove request from requestList
        removeFromRequestQueue(requestCode);

    }

    @Override
    public void onFailed(int requestCode, String message) {

        if(message.equalsIgnoreCase(ErrorMessages.ERR_EXPIRED_TOKEN)){

            cancelRequests();
            refreshToken(this);

            return;

        }

        switch (requestCode) {

            case RequestCodes.REQUEST_CODE_REFRESH_TOKEN:
                baseApplication.deleteSharedPrefs(getActivity());
                break;

//            default:
//                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
//                break;

        }

        //hid progress bar
        changeProgressBarVisibility(false);

        //remove request from requestList
        removeFromRequestQueue(requestCode);

    }

    /**
     * This method initializes layout id, toolbar, and request tag for requests
     */
    public abstract void initMain();

    /**
     * This method initializes views included in the layout
     * @param view
     * @param savedInstanceState
     */
    public abstract void initViews(View view, Bundle savedInstanceState);

    /**
     *This method provides data passed through arguments
     */
    public abstract void initData(Bundle bundle);

    /**
     * This method inflates the frame layout with child layout
     * @param frameLayout
     * @param layoutId
     */
    private void inflateView(FrameLayout frameLayout, int layoutId) {

        View child = getActivity().getLayoutInflater().inflate(layoutId, null);
        frameLayout.addView(child);

    }

    /**
     * This method is triggered every time the token expires
     * @param handler
     */
    private void refreshToken(ResponseHandler handler) {

        Request request = UserApi.refreshToken(RequestCodes.REQUEST_CODE_REFRESH_TOKEN,
                baseApplication.getRefreshToken(), handler);

        baseApplication.getRequestQueue().add(request);

    }

    /**
     * Called to most recent failed request
     */
    private void retryRequests() {

        for (Request request : this.requestList) {

            this.requestQueue.add(request);

        }

    }

    /**
     * Called to cancel all requests
     */
    public void cancelRequests() {

        for (Request request : this.requestList) {

            request.cancel();

        }

    }

    /**
     * This method handles refresh token
     * @param object
     */
    private void handleRefreshToken(Object object) {

        com.yilinker.core.model.Login login = (com.yilinker.core.model.Login) object;
        baseApplication.saveToken(login.getAccess_token(), login.getRefresh_token());

        this.retryRequests();

    }

    /**
     * Enables progress bar
     * @param isLoading
     */
    public void changeProgressBarVisibility(boolean isLoading) {

        rlProgressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);

    }

    /**
     * Enables intent
     * @param context
     * @param activityClass
     */
    public void enableIntent(Context context, Class activityClass) {

        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);

    }

    /**
     * Handles request if successful
     */
    public void handleSuccessfulRequest() {

        flBaseContainer.setVisibility(View.VISIBLE);
        rlReload.setVisibility(View.GONE);
        tvError.setText("");

    }

    /**
     * Handles request if failed
     * @param errorMessage
     */
    public void handleFailedRequest(String errorMessage) {

        flBaseContainer.setVisibility(View.GONE);
        rlReload.setVisibility(View.VISIBLE);
        tvError.setText(errorMessage);

    }

    /**
     * Sets boolean if activity has toolbar
     * @param hasToolbar
     */
    public void setHasToolbar(boolean hasToolbar) {

        this.hasToolbar = hasToolbar;

    }

    /**
     * Sets the layout id of the activity
     * @param layoutId
     */
    public void setLayoutId(int layoutId) {

        this.layoutId = layoutId;

    }

    /**
     * Sets title of the toolbar
     * @param toolbarTitle
     */
    public void setToolbarTitle(String toolbarTitle) {

        this.toolbarTitle = toolbarTitle;

    }

    /**
     * Called to add request to request queue
     * @param request
     */
    public void addToRequestQueue(Request request) {

        this.requestList.add(request);
        this.requestQueue.add(request);

    }

    /**
     * Called to remove successful request from requestList
     * @param requestCode
     */
    private void removeFromRequestQueue(int requestCode) {

        for (Request request : this.requestList) {

            if ((int)request.getTag() == requestCode) {

                this.requestList.remove(request);

                break;

            }

        }

    }

}