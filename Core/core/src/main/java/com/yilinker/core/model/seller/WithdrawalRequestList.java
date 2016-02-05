package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Patrick on 2/3/2016.
 */
public class WithdrawalRequestList {

    private final static String KEY_REQUESTS = "requests";

    @SerializedName(KEY_REQUESTS)
    private List<WithdrawalRequest> withdrawalRequests;

    public List<WithdrawalRequest> getWithdrawalRequests() {
        return withdrawalRequests;
    }

    public void setWithdrawalRequests(List<WithdrawalRequest> withdrawalRequests) {
        this.withdrawalRequests = withdrawalRequests;
    }

    public static class WithdrawalRequestListInstance implements InstanceCreator<WithdrawalRequestList> {
        @Override
        public WithdrawalRequestList createInstance(Type type) {
            return new WithdrawalRequestList();
        }
    }

}
