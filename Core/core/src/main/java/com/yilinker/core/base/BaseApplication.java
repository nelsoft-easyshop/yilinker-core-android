package com.yilinker.core.base;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by J.Bautista
 */
public class BaseApplication extends Application{

    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public RequestQueue getRequestQueue() {

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }

}
