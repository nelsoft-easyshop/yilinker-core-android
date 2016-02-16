package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by Patrick on 2/3/2016.
 */
public class WithdrawalRequest {

    private final static String KEY_DATE = "date";
    private final static String KEY_WITHDRAWAL_METHOD = "withdrawalMethod";
    private final static String KEY_TOTAL_AMOUNT = "totalAmount";
    private final static String KEY_CHARGE = "charge";
    private final static String KEY_NET_AMOUNT = "netAmount";
    private final static String KEY_CURRENCY_CODE = "currencyCode";
    private final static String KEY_STATUS = "status";
    private final static String KEY_PAY_TO = "payTo";
    private final static String KEY_BANK_NAME = "bankName";
    private final static String KEY_ACCOUNT_NUMBER = "accountNumber";
    private final static String KEY_ACCOUNT_NAME = "accountName";

    @SerializedName(KEY_DATE)
    private String date;
    @SerializedName(KEY_WITHDRAWAL_METHOD)
    private String withdrawalMethod;
    @SerializedName(KEY_TOTAL_AMOUNT)
    private String totalAmount;
    @SerializedName(KEY_CHARGE)
    private String charge;
    @SerializedName(KEY_NET_AMOUNT)
    private String netAmount;
    @SerializedName(KEY_CURRENCY_CODE)
    private String currencyCode;
    @SerializedName(KEY_STATUS)
    private String status;
    @SerializedName(KEY_PAY_TO)
    private String payTo;
    @SerializedName(KEY_BANK_NAME)
    private String bankName;
    @SerializedName(KEY_ACCOUNT_NUMBER)
    private String accountNumber;
    @SerializedName(KEY_ACCOUNT_NAME)
    private String accountName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWithdrawalMethod() {
        return withdrawalMethod;
    }

    public void setWithdrawalMethod(String withdrawalMethod) {
        this.withdrawalMethod = withdrawalMethod;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayTo() {
        return payTo;
    }

    public void setPayTo(String payTo) {
        this.payTo = payTo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public static class WithdrawalRequestInstance implements InstanceCreator<WithdrawalRequest> {
        @Override
        public WithdrawalRequest createInstance(Type type) {
            return new WithdrawalRequest();
        }
    }
}
