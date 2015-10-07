package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybr_000 on 9/6/2015.
 */
public class SalesReport {

    private int productCount, totalTransactionCount;
    private String totalSales;
    private List<TransactionPerDay> confirmedTransactionPerDay, cancelledTransactionPerDay;

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getTotalTransactionCount() {
        return totalTransactionCount;
    }

    public void setTotalTransactionCount(int totalTransactionCount) {
        this.totalTransactionCount = totalTransactionCount;
    }

    public String getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }

    public List<TransactionPerDay> getConfirmedTransactionPerDay() {
        return confirmedTransactionPerDay;
    }

    public void setConfirmedTransactionPerDay(List<TransactionPerDay> confirmedTransactionPerDay) {
        this.confirmedTransactionPerDay = confirmedTransactionPerDay;
    }

    public List<TransactionPerDay> getCancelledTransactionPerDay() {
        return cancelledTransactionPerDay;
    }

    public void setCancelledTransactionPerDay(List<TransactionPerDay> cancelledTransactionPerDay) {
        this.cancelledTransactionPerDay = cancelledTransactionPerDay;
    }

    public class TransactionPerDay {

        private String date, numberOfOrders;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getNumberOfOrders() {
            return numberOfOrders;
        }

        public void setNumberOfOrders(String numberOfOrders) {
            this.numberOfOrders = numberOfOrders;
        }

    }

    public static class SalesReportInstance implements InstanceCreator<SalesReport> {

        @Override
        public SalesReport createInstance(Type type) {

            return new SalesReport();
        }

    }

}
