package com.yilinker.core.imageloader;

import android.content.Context;
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
    private Context context;

    private VolleyImageLoader(Context context){

        this.context = context;
        requestQueue = getRequestQueue();
//        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
//            LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(10);
//
//            @Override
//            public Bitmap getBitmap(String url) {
//                return cache.get(url);
//            }
//            @Override
//            public void putBitmap(String url, Bitmap bitmap) {
//                cache.put(url, bitmap);
//            }
//
//        });
//        imageLoader = new ImageLoader(requestQueue, new LruBitmapCache(LruBitmapCache.getCacheSize(context)));
        this.imageLoader = ImageCacheManager.getInstance().getImageLoader();
    }

    public RequestQueue getRequestQueue(){

        if(requestQueue == null){

            requestQueue = Volley.newRequestQueue(context);
        }

        return requestQueue;

    }

    public static VolleyImageLoader getInstance(Context context){
        if(instance == null){
            instance = new VolleyImageLoader(context);
        }
        return instance;
    }

    public ImageLoader getImageLoader(){
        return this.imageLoader;
    }
}
