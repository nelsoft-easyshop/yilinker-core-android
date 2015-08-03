package com.yilinker.core.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by wagnavu on 8/3/15.
 *
 * Base class for all fragments
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Default constructor
     * @param args
     */
    public BaseFragment(@Nullable Bundle args){

        setArguments(args);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view, savedInstanceState);
    }

    /**
     * Initializes views included in the layout. This is called in onViewCreated method
     * @param view
     * @param savedInstanceState
     */
    protected abstract void initViews(View view, Bundle savedInstanceState);
}
