package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Patrick on 9/14/2015.
 */
public class Case {

    private String disputeId;
    private String disputeStatusType,dateAdded;
    private String orderProductStatus,disputeeFullName,disputeeContactNumber;

    public String getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(String disputeId) {
        this.disputeId = disputeId;
    }

    public String getDisputeStatusType() {
        return disputeStatusType;
    }

    public void setDisputeStatusType(String disputeStatusType) {
        this.disputeStatusType = disputeStatusType;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getOrderProductStatus() {
        return orderProductStatus;
    }

    public void setOrderProductStatus(String orderProductStatus) {
        this.orderProductStatus = orderProductStatus;
    }

    public String getDisputeeFullName() {
        return disputeeFullName;
    }

    public void setDisputeeFullName(String disputeeFullName) {
        this.disputeeFullName = disputeeFullName;
    }

    public String getDisputeeContactNumber() {
        return disputeeContactNumber;
    }

    public void setDisputeeContactNumber(String disputeeContactNumber) {
        this.disputeeContactNumber = disputeeContactNumber;
    }

    public static class CaseInstance implements InstanceCreator<Case> {

        @Override
        public Case createInstance(Type type) {
            return new Case();
        }
    }
}
