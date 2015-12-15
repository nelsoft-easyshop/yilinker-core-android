package com.yilinker.core.helper;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by Adur Urbano on 12/14/2015.
 */
public class GoogleAnalyticsHelper {

    private Tracker mGaTracker = null;
    private static String TAG = "GoogleAnalyticsHelper";
    private static final String PROPERTY_ID = "UA-68038640-8";

    public void init(Context ctx) {
        try {

            if (mGaTracker == null && ctx != null) {
                mGaTracker = GoogleAnalytics.getInstance(ctx).newTracker(PROPERTY_ID);
            }
        } catch (Exception e) {
            Log.d(GoogleAnalyticsHelper.TAG, "init, e=" + e);
        }
    }

    public void sendScreenNameGoogleAnalytics(Context iCtx, String screenName)
    {
        init(iCtx);

        mGaTracker.setScreenName(screenName);
        mGaTracker.send(new HitBuilders.AppViewBuilder().build());

    }


    public void sendEventGoogleAnalytics(Context iCtx,String iCategoryId, String iActionId, String iLabelId)
    {
        init(iCtx);

        mGaTracker.send(new HitBuilders.EventBuilder()
                .setCategory(iCategoryId)
                .setAction(iActionId)
                .setLabel(iLabelId)
                .build());

    }
}