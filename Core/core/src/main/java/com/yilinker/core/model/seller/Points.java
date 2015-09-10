package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 9/7/2015.
 */
public class Points {

    private String points;
    private int userPointHistoryId;
    private int userId;
    private int userPointTypeId;
    private String userPointTypeName;
    private PointsDateAdded dateAdded;

    public int getUserPointHistoryId() {
        return userPointHistoryId;
    }

    public void setUserPointHistoryId(int userPointHistoryId) {
        this.userPointHistoryId = userPointHistoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserPointTypeId() {
        return userPointTypeId;
    }

    public void setUserPointTypeId(int userPointTypeId) {
        this.userPointTypeId = userPointTypeId;
    }

    public String getUserPointTypeName() {
        return userPointTypeName;
    }

    public void setUserPointTypeName(String userPointTypeName) {
        this.userPointTypeName = userPointTypeName;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public PointsDateAdded getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(PointsDateAdded dateAdded) {
        this.dateAdded = dateAdded;
    }

    public static class PointsInstance implements InstanceCreator<Points> {
        @Override
        public Points createInstance(Type type) {
            return new Points();
        }
    }
}
