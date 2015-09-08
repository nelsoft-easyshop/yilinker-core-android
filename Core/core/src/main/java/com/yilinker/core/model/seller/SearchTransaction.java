package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 9/8/2015.
 */
public class SearchTransaction {

    private String invoiceNumber;
    private String target;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public static class SearchTransactionInstance implements InstanceCreator<SearchTransaction> {
        @Override
        public SearchTransaction createInstance(Type type) {
            return new SearchTransaction();
        }
    }
}
