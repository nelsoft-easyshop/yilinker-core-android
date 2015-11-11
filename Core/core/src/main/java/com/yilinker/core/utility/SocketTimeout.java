package com.yilinker.core.utility;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RetryPolicy;

/**
 * Created by rlcoronado on 8/13/15.
 */
public class SocketTimeout {

    public static RetryPolicy getRetryPolicy(){
        int socketTimeout = 10000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        return policy;
    }
}
