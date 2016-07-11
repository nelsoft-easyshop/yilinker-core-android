package com.yilinker.core.model.seller.request;

/**
 * Created by patVillanueva on 5/19/2016.
 */
public class CountryStoreSetInventoryLocation {

    private String code;
    private String productId;
    private String userWarehouse;
    private String logistics;
    private boolean isCod;
    private String handlingFee;
    private String priority;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserWarehouse() {
        return userWarehouse;
    }

    public void setUserWarehouse(String userWarehouse) {
        this.userWarehouse = userWarehouse;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistiics) {
        this.logistics = logistiics;
    }

    public boolean isCod() {
        return isCod;
    }

    public void setCod(boolean cod) {
        isCod = cod;
    }

    public String getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(String handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
