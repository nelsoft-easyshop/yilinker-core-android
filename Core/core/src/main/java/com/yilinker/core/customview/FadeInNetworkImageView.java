package com.yilinker.core.customview;

/**
 * Created by rlcoronado on 10/26/15.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.*;
import android.util.AttributeSet;

import com.android.volley.toolbox.NetworkImageView;

public class FadeInNetworkImageView extends NetworkImageView {

    private static final int FADE_IN_TIME_MS = 500;
    private ColorDrawable cd = new ColorDrawable(getContext().getResources().getColor(android.R.color.transparent));

    public FadeInNetworkImageView(Context context) {
        super(context);
    }

    public FadeInNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FadeInNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                cd, new BitmapDrawable(getContext().getResources(), bm)

        });
        td.setCrossFadeEnabled(true);
        setImageDrawable(td);
        td.startTransition(FADE_IN_TIME_MS);
    }
}