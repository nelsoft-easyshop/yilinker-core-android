package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlcoronado on 8/22/15.
 */
public class FollowedSellers {

    private List<FollowedSeller> sellers = new ArrayList<>();

    public List<FollowedSeller> getSellers() {
        return sellers;
    }

    public void setSellers(List<FollowedSeller> sellers) {
        this.sellers = sellers;
    }

    public static class FollowedSellersInstance implements InstanceCreator<FollowedSellers>{

        @Override
        public FollowedSellers createInstance(Type type) {

            return new FollowedSellers();
        }
    }
}
