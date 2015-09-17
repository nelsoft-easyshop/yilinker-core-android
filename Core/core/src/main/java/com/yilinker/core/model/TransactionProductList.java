package com.yilinker.core.model;

import java.util.List;

/**
 * Created by Patrick on 8/21/2015.
 */
public class TransactionProductList {


    private int itemCount;
    private List<TransactionProduct> transactionProductList;

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<TransactionProduct> getTransactionProductList() {
        return transactionProductList;
    }

    public void setTransactionProductList(List<TransactionProduct> transactionProductList) {
        this.transactionProductList = transactionProductList;
    }


}
