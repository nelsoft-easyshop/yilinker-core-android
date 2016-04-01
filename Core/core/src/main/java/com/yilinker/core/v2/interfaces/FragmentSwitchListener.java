package com.yilinker.core.v2.interfaces;

import android.app.Fragment;

/**
 * Created by Adur Urbano on 3/18/2016.
 */
public interface FragmentSwitchListener {

    /**
     * Use this interface every time you switch fragments
     * @param fragment
     */
    void onFragmentSwitch(Fragment fragment, boolean addToBackStack);

}
