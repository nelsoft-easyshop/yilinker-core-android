package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista
 */
public class CashDetail {

    private double cashOnHand;
    private double cashLimit;
    private List<CashHistory> cashHistory;

    public double getCashOnHand() {
        return cashOnHand;
    }

    public void setCashOnHand(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    public double getCashLimit() {
        return cashLimit;
    }

    public void setCashLimit(double cashLimit) {
        this.cashLimit = cashLimit;
    }

    public List<CashHistory> getCashHistory() {
        return cashHistory;
    }

    public void setCashHistory(List<CashHistory> cashHistory) {
        this.cashHistory = cashHistory;
    }

    public static class CashDetailInstance implements InstanceCreator<CashDetail> {

        @Override
        public CashDetail createInstance(Type type) {

            return new CashDetail();
        }
    }
}
