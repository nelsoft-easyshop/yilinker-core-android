package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Patrick on 9/14/2015.
 */
public class Case {

    private String disputeTitle;
    private String remarks;
    private String disputeId;
    private String disputeStatusType,dateAdded;
    private String orderProductStatus,disputeeFullName,disputeeContactNumber;
    private List<String> orderProductIds;

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

    public String getDisputeTitle() {
        return disputeTitle;
    }

    public void setDisputeTitle(String disputeTitle) {
        this.disputeTitle = disputeTitle;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<String> getOrderProductIds() {
        return orderProductIds;
    }

    public void setOrderProductIds(List<String> orderProductIds) {
        this.orderProductIds = orderProductIds;
    }

    public JSONArray getProductIds(){
        JSONArray jsonProductArray = new JSONArray();
        if(getOrderProductIds() != null) {
            if(getOrderProductIds().size() > 0) {
                for (int ctr = 0; ctr < getOrderProductIds().size(); ctr++) {
                    jsonProductArray.put(Integer.parseInt(getOrderProductIds().get(ctr)));
                }
            }
        }
        return jsonProductArray;
    }
    public static class CaseInstance implements InstanceCreator<Case> {

        @Override
        public Case createInstance(Type type) {
            return new Case();
        }
    }
}
