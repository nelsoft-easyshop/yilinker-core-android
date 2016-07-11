package com.yilinker.core.v2.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yilinker.core.R;
import com.yilinker.core.api.UserApi;
import com.yilinker.core.base.BaseApplication;
import com.yilinker.core.constants.ErrorMessages;
import com.yilinker.core.interfaces.ResponseHandler;
import com.yilinker.core.v2.constants.RequestCodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adur Urbano on 1/5/2016.
 */
public abstract class BaseActivity extends AppCompatActivity implements ResponseHandler, View.OnClickListener {

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
    private boolean hasToolbar = true;

    /**
     * Integer for layoutID
     */
    private int layoutId = 0;

    /**
     * String for toolbar title
     */
    private String toolbarTitle = null;

    /**
     * Reference of Reload Layout
     */
    private RelativeLayout rlReload;

    /**
     * Reference of Error TextView
     */
    private TextView tvError;

    /**
     * Integer for entrance of animation
     */
    private int animationEnter = R.anim.anim_slide_in_left;

    /**
     * Integer for exit of animation
     */
    private int animationExit = R.anim.anim_slide_out_right;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v2_activity_base);

        //declaration of application to be used by classes extending this base class
        baseApplication = (BaseApplication) getApplicationContext();

        //initialization of requestqueue object
        requestQueue = Volley.newRequestQueue(this);

        //passing of data through intent
        initData(getIntent());

        //initialization of layout id, toolbar, and request tags
        initMain();

        if (layoutId != 0) {

            inflateView(((FrameLayout) findViewById(R.id.flBaseContainer)), layoutId);

            initViews(findViewById(layoutId), savedInstanceState);

        }

        //setting toolbar
        setToolbar();

        //initialization of views in base
        rlReload = (RelativeLayout) findViewById(R.id.rlReload);
        tvError = (TextView) findViewById(R.id.tvError);

        //setting onClickListener for rlReload if request failed
        rlReload.setOnClickListener(this);

    }

    @Override
    public void onPause() {
        super.onPause();

        //cancels request when activity pauses
        this.cancelRequests();

    }

    @Override
    public void finish() {
        super.finish();
        
        //animates activity when finished
        overridePendingTransition(animationEnter, animationExit);
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;

        }

        return super.onOptionsItemSelected(item);

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

        if(message.equalsIgnoreCase(ErrorMessages.ERR_EXPIRED_TOKEN)) {

            cancelRequests();
            refreshToken(this);

            return;

        }

        switch (requestCode) {

            case RequestCodes.REQUEST_CODE_REFRESH_TOKEN:
                baseApplication.deleteSharedPrefs(this);
                break;

            default:
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                break;

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
     * @param savedInstanceState
     */
    public abstract void initViews(View view, Bundle savedInstanceState);

    /**
     * This method provides data passed through intents
     * @param intent
     */
    public abstract void initData(Intent intent);

    /**
     * This method inflates the frame layout with child layout
     * @param frameLayout
     * @param layoutId
     */
    private void inflateView(FrameLayout frameLayout, int layoutId) {

        View child = getLayoutInflater().inflate(layoutId, null);
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
     * Setting of toolbar
     */
    private void setToolbar() {

        //reference of Toolbar and set this Toolbar to act as action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.header);

        //setting toolbar title
        ((TextView) toolbar.findViewById(R.id.tvHeaderName)).setText(toolbarTitle == null ? "" : toolbarTitle);

        //set toolbar as action bar
        setSupportActionBar(toolbar);

        //makes the title in toolbar disabled
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //makes the icon and title in the toolbar clickable so that “up” (ancestral) navigation can be provided
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //this method just controls whether to show the Activity icon/logo or not.
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //this method set the image to be used as indicator
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);

        if (!hasToolbar)
            (findViewById(R.id.header)).setVisibility(View.GONE);

    }

    /**
     * Enables progress bar
     * @param isLoading
     */
    public void changeProgressBarVisibility(boolean isLoading) {

        (findViewById(R.id.rlProgressBar)).setVisibility(isLoading ? View.VISIBLE : View.GONE);

    }

    /**
     * Handles request if successful
     */
    public void handleSuccessfulRequest() {

        (findViewById(R.id.flBaseContainer)).setVisibility(View.VISIBLE);
        rlReload.setVisibility(View.GONE);
        tvError.setText("");

    }

    /**
     * Handles request if failed
     * @param errorMessage
     */
    public void handleFailedRequest(String errorMessage) {

        (findViewById(R.id.flBaseContainer)).setVisibility(View.GONE);
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

    /**
     * Sets entrance of animation
     * @param animationEnter
     */
    public void setAnimationEnter(int animationEnter) {

        this.animationEnter = animationEnter;

    }

    /**
     * Sets exit of animation
     * @param animationExit
     */
    public void setAnimationExit(int animationExit) {

        this.animationExit = animationExit;

    }
}