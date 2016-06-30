package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaybr_000 on 9/2/2015.
 */
public class TransactionList {

    private List<TransactionItem> orders = new ArrayList<>();
    private String totalResultCount;

    public List<TransactionItem> getOrders() {
        return orders;
    }

    public void setOrders(List<TransactionItem> orders) {
        this.orders = orders;
    }

    public String getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(String totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    public static class TransactionListInstance implements InstanceCreator<TransactionList> {

        @Override
        public TransactionList createInstance(Type type) {

            return new TransactionList();
        }
    }

}
