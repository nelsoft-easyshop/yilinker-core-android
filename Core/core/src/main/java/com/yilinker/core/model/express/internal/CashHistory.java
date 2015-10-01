package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista
 */
public class CashHistory {

    private String action;
    private int jobOrderNo;
    private double amount;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getJobOrderNo() {
        return jobOrderNo;
    }

    public void setJobOrderNo(int jobOrderNo) {
        this.jobOrderNo = jobOrderNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static class CashHistoryInstance implements InstanceCreator<CashHistory> {

        @Override
        public CashHistory createInstance(Type type) {

            return new CashHistory();
        }
    }

}
