package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista
 */
public class Rider {

    private String name;
    private String imageUrl;
    private int currentDeliveryJO;
    private int currentPickupJO;
    private double cashOnHand;
//    private double totalEarning;
    private int completedJO;
    private int currentJO;
    private int currentDropoffJO;
    private String areaCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCurrentDeliveryJO() {
        return currentDeliveryJO;
    }

    public void setCurrentDeliveryJO(int currentDeliveryJO) {
        this.currentDeliveryJO = currentDeliveryJO;
    }

    public int getCurrentPickupJO() {
        return currentPickupJO;
    }

    public void setCurrentPickupJO(int currentPickupJO) {
        this.currentPickupJO = currentPickupJO;
    }

    public double getCashOnHand() {
        return cashOnHand;
    }

    public void setCashOnHand(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

//    public double getTotalEarning() {
//        return totalEarning;
//    }
//
//    public void setTotalEarning(double totalEarning) {
//        this.totalEarning = totalEarning;
//    }

    public int getCompletedJO() {
        return completedJO;
    }

    public void setCompletedJO(int completedJO) {
        this.completedJO = completedJO;
    }

    public int getCurrentJO() {
        return currentJO;
    }

    public void setCurrentJO(int currentJO) {
        this.currentJO = currentJO;
    }

    public int getCurrentDropoffJO() {
        return currentDropoffJO;
    }

    public void setCurrentDropoff(int currentDropoffJO) {
        this.currentDropoffJO = currentDropoffJO;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public static class RiderInstance implements InstanceCreator<Rider> {

        @Override
        public Rider createInstance(Type type) {

            return new Rider();
        }
    }
}
