package com.yilinker.core.helper;

import android.content.Context;

import com.android.volley.toolbox.HurlStack;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;

/**
 * Created by rlcoronado on 9/9/15.
 */
public class HurlCookieStack extends HurlStack {

    public HurlCookieStack(Context context){
        super();
        CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL ) );
//        CookieManager cookieManager = new CookieManager(new VolleyCookieHelper(context), CookiePolicy.ACCEPT_ALL);
//        CookieHandler.setDefault(cookieManager);
    }
}
