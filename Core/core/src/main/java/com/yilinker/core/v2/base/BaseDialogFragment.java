package com.yilinker.core.v2.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.yilinker.core.R;
import com.yilinker.core.base.BaseApplication;

/**
 * Created by Adur Urbano on 1/15/2016.
 */
public abstract class BaseDialogFragment extends DialogFragment {

    /**
     * Reference of baseApplication
     */
    public BaseApplication baseApplication;

    /**
     * Integer for layoutID
     */
    private int layoutId = 0;

    /**
     * View to be animated
     */
    private View view;

    /**
     * Integer for entrance of animation
     */
    private int animationEnter = R.anim.anim_slide_up;

    /**
     * Integer for exit of animation
     */
    private int animationExit = R.anim.anim_slide_down;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        //declaration of application to be used by classes extending this base class
        baseApplication = (BaseApplication) getActivity().getApplicationContext();

        //initialization of layout id, toolbar, and request tags
        initMain();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(layoutId, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //passing of data through arguments
        initData(getArguments());

        //for initialization of views
        initViews(view, savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();

        showParent();

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
     * Animates dialogFragment onShow
     */
    private void showParent() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(AnimationUtils.loadAnimation(getActivity(), animationEnter));
                view.setVisibility(View.VISIBLE);
            }
        }, 300);

    }

    /**
     * Animates dialogFragment onStop
     */
    public void hideParent() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(AnimationUtils.loadAnimation(getActivity(), animationExit));
                view.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismiss();
                    }
                }, 300);

            }
        }, 300);

    }

    /**
     * Sets the layout id of the activity
     * @param layoutId
     */
    public void setLayoutId(int layoutId) {

        this.layoutId = layoutId;

    }

    /**
     * Sets view to be animated
     * @param view
     */
    public void setViewToAnimate(View view) {

        this.view = view;

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
