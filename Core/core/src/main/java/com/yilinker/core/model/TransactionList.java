package com.yilinker.core.model;

import java.util.List;

/**
 * Created by Patrick on 8/21/2015.
 */
public class TransactionList {

    private int itemCount;
    private List<TransactionItem> transactionItems;

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<TransactionItem> getTransactionItems() {
        return transactionItems;
    }

    public void setTransactionItems(List<TransactionItem> transactionItems) {
        this.transactionItems = transactionItems;
    }
}
