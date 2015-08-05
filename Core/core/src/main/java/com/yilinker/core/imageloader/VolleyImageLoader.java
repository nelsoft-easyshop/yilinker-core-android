package com.yilinker.core.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.yilinker.core.base.BaseApplication;

/**
 * Created by rlcoronado on 8/5/15.
 */
public class VolleyImageLoader {
    private static VolleyImageLoader instance = null;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    private VolleyImageLoader(){
        requestQueue = Volley.newRequestQueue(BaseApplication.getAppContext());
        imageLoader = new ImageLoader(this.requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(10);
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }
        });
    }

    public static VolleyImageLoader getInstance(){
        if(instance == null){
            instance = new VolleyImageLoader();
        }
        return instance;
    }

    public RequestQueue getRequestQueue(){
        return this.requestQueue;
    }

    public ImageLoader getImageLoader(){
        return this.imageLoader;
    }
}
