package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rlcoronado on 8/20/15.
 */
public class CheckoutPayment {

    private int transactionId;
    private String paymentUrl;
    private String returnUrl, cancelUrl;
    private List<CartItem> cartData;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public List<CartItem> getCartData() {
        return cartData;
    }

    public void setCartData(List<CartItem> cartData) {
        this.cartData = cartData;
    }

    public static class CheckoutPaymentInstance implements InstanceCreator<CheckoutPayment> {

        @Override
        public CheckoutPayment createInstance(Type type) {
            return new CheckoutPayment();
        }
    }
}
