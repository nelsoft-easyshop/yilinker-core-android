package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybr_000 on 9/2/2015.
 */
public class TransactionList {

    private List<Transaction> orders;
    private String totalResultCount;

    public List<Transaction> getOrders() {
        return orders;
    }

    public void setOrders(List<Transaction> orders) {
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
