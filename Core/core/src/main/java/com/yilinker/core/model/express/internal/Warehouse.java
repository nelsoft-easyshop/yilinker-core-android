package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista
 */
public class Warehouse {

    private int id;
    private int forClaiming;
    private int forPickup;
    private Location location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForClaiming() {
        return forClaiming;
    }

    public void setForClaiming(int forClaiming) {
        this.forClaiming = forClaiming;
    }

    public int getForPickup() {
        return forPickup;
    }

    public void setForPickup(int forPickup) {
        this.forPickup = forPickup;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class WarehouseInstance implements InstanceCreator<Warehouse> {

        @Override
        public Warehouse createInstance(Type type) {

            return new Warehouse();
        }
    }

}
