package com.yilinker.core.model.seller;

/**
 * Created by patVillanueva on 5/17/2016.
 */
public class CountryWarehouse {

    private String id;
    private int priority;
    private String handlingFee;
    private boolean is_cod;
    private boolean is_local;
    private CountryLogistic logistic;
    private CountryUserWarehouse user_warehouse;

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

    public boolean is_cod() {
        return is_cod;
    }

    public void setIs_cod(boolean is_cod) {
        this.is_cod = is_cod;
    }

    public boolean is_local() {
        return is_local;
    }

    public void setIs_local(boolean is_local) {
        this.is_local = is_local;
    }

    public CountryLogistic getLogistic() {
        return logistic;
    }

    public void setLogistic(CountryLogistic logistic) {
        this.logistic = logistic;
    }

    public CountryUserWarehouse getUser_warehouse() {
        return user_warehouse;
    }

    public void setUser_warehouse(CountryUserWarehouse user_warehouse) {
        this.user_warehouse = user_warehouse;
    }
}
