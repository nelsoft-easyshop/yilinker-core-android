package com.yilinker.core.model.seller;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patVillanueva on 5/17/2016.
 */
public class CountryWarehouse {

    private final static String KEY_IS_COD = "is_cod";
    private final static String KEY_IS_LOCAL = "is_local";
    private final static String KEY_USER_WAREHOUSE = "user_warehouse";

    private String id;
    private int priority;
    private String handlingFee;
    @SerializedName(KEY_IS_COD)
    private boolean isCod;
    @SerializedName(KEY_IS_LOCAL)
    private boolean isLocal;
    private CountryLogistic logistic;
    @SerializedName(KEY_USER_WAREHOUSE)
    private CountryUserWarehouse userWarehouse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(String handlingFee) {
        this.handlingFee = handlingFee;
    }

    public boolean isCod() {
        return isCod;
    }

    public void setCod(boolean cod) {
        isCod = cod;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public CountryLogistic getLogistic() {
        return logistic;
    }

    public void setLogistic(CountryLogistic logistic) {
        this.logistic = logistic;
    }

    public CountryUserWarehouse getUserWarehouse() {
        return userWarehouse;
    }

    public void setUserWarehouse(CountryUserWarehouse userWarehouse) {
        this.userWarehouse = userWarehouse;
    }
}
