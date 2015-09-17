package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista
 */
public class JobOrder {

    private String jobOrderNo;
    private String jobOrderType;
    private String jobOrderStatus;
    private String recipientName;
    private String recipientContactNo;
    private List<String> items;
    private String packageSize;
    private String pickupAddr;
    private String dropoffAddr;
    private String eta;
    private double earnings;
    private List<String> images;
    private String trackingNo;
    private String deliveryAddress;
    private String timeDelivered;
    private int rating;
    private String branchName;
    private Location location;


    public String getJobOrderNo() {
        return jobOrderNo;
    }

    public void setJobOrderNo(String jobOrderNo) {
        this.jobOrderNo = jobOrderNo;
    }

    public String getJobOrderType() {
        return jobOrderType;
    }

    public void setJobOrderType(String jobOrderType) {
        this.jobOrderType = jobOrderType;
    }

    public String getJobOrderStatus() {
        return jobOrderStatus;
    }

    public void setJobOrderStatus(String jobOrderStatus) {
        this.jobOrderStatus = jobOrderStatus;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientContactNo() {
        return recipientContactNo;
    }

    public void setRecipientContactNo(String recipientContactNo) {
        this.recipientContactNo = recipientContactNo;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public String getPickupAddr() {
        return pickupAddr;
    }

    public void setPickupAddr(String pickupAddr) {
        this.pickupAddr = pickupAddr;
    }

    public String getDropoffAddr() {
        return dropoffAddr;
    }

    public void setDropoffAddr(String dropoffAddr) {
        this.dropoffAddr = dropoffAddr;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getTimeDelivered() {
        return timeDelivered;
    }

    public void setTimeDelivered(String timeDelivered) {
        this.timeDelivered = timeDelivered;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class JobOrderInstance implements InstanceCreator<JobOrder> {

        @Override
        public JobOrder createInstance(Type type) {

            return new JobOrder();
        }
    }
}
