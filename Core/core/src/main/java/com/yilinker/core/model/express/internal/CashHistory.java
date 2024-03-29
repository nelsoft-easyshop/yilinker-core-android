package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista
 */
public class CashHistory {

//    private String action;
//    private int jobOrderNo;
    private double amount;
//    private String jobOrderNo;
    private String date;
    private String type;
    @SerializedName("waybillNumber")
    private String waybillNo;
    private double runningTotal;

//    public String getAction() {
//        return action;
//    }
//
//    public void setAction(String action) {
//        this.action = action;
//    }
//
//    public int getJobOrderNo() {
//        return jobOrderNo;
//    }
//
//    public void setJobOrderNo(int jobOrderNo) {
//        this.jobOrderNo = jobOrderNo;
//    }


    public double getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
//
//    public String getJobOrderNo() {
//        return jobOrderNo;
//    }
//
//    public void setJobOrderNo(String jobOrderNo) {
//        this.jobOrderNo = jobOrderNo;
//    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public static class CashHistoryInstance implements InstanceCreator<CashHistory> {

        @Override
        public CashHistory createInstance(Type type) {

            return new CashHistory();
        }
    }

}
