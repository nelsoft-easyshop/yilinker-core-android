package com.yilinker.core.v2.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Adur Urbano on 3/18/2016.
 */
public class CustomTextViewBold extends TextView
{

    public CustomTextViewBold(Context context)
    {

        super(context);
        init();

    }

    public CustomTextViewBold(Context context, AttributeSet attrs)
    {

        super(context, attrs);
        init();

    }

    public CustomTextViewBold(Context context, AttributeSet attrs, int defStyleAttr)
    {

        super(context, attrs, defStyleAttr);
        init();

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomTextViewBold(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {

        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }

    private void init()
    {

        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + "HelveticaWorld-Bold.ttf");
        setTypeface(myTypeface);

    }
}
