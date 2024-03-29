package com.yilinker.core.model;

import com.google.gson.InstanceCreator;
import com.yilinker.core.model.seller.ResolutionCenterProducts;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Patrick on 9/14/2015.
 */
public class Case {

    private String invoiceNumber;
    private String disputeTitle;
    private String disputeId;
    private String disputeStatusType,dateAdded;
    private String orderProductStatus,disputeeFullName,disputeeContactNumber,disputerFullName;
    private List<String> orderProductIds;
    private String ticketId;
    private String ticket;

    private List<ResolutionCenterProducts> products;

//    public List<CategoryProducts> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<CategoryProducts> products) {
//    private List<ResolutionCenterProducts> products;


    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public List<ResolutionCenterProducts> getProducts() {
        return products;
    }

    public void setProducts(List<ResolutionCenterProducts> products) {
        this.products = products;
    }

    private List<Remarks> remarks;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(String disputeId) {
        this.disputeId = disputeId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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

    public String getDisputerFullName() {
        return disputerFullName;
    }

    public void setDisputerFullName(String disputerFullName) {
        this.disputerFullName = disputerFullName;
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
    public List<Remarks> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Remarks> remarks) {
        this.remarks = remarks;
    }

    public static class CaseInstance implements InstanceCreator<Case> {

        @Override
        public Case createInstance(Type type) {
            return new Case();
        }
    }
}