package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rlcoronado on 07/01/2016.
 */
public class PackageType {

    private int id;
    private String name;
    private List<Sizes> size;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sizes> getSize() {
        return size;
    }

    public void setSize(List<Sizes> size) {
        this.size = size;
    }

    public class Sizes {

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class PackageTypeInstance implements InstanceCreator<PackageType> {

        @Override
        public PackageType createInstance(Type type) {

            return new PackageType();
        }
    }
}
