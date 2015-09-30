package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 9/29/2015.
 */
public class SearchTransactionList {

private List<SearchTransaction> orders;

    public List<SearchTransaction> getOrders() {
        return orders;
    }

    public void setOrders(List<SearchTransaction> orders) {
        this.orders = orders;
    }

    public static class SearchTransactionListInstance implements InstanceCreator<SearchTransactionList> {
        @Override
        public SearchTransactionList createInstance(Type type) {
            return new SearchTransactionList();
        }
    }
}
