package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 11/25/2015.
 */
public class Layout7 {

    @SerializedName(APIConstants.API_HOME_V2_STORE)
    private Store store;
    @SerializedName(APIConstants.API_HOME_V2_TARGET)
    private Target target;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public static class Layout7Instance implements InstanceCreator<Layout7> {

        @Override
        public Layout7 createInstance(Type type) {
            return new Layout7();
        }
    }

    public class Store {
        @SerializedName(APIConstants.API_HOME_V2_STORE_NAME)
        private String name;
        @SerializedName(APIConstants.API_HOME_V2_STORE_SPECIALTY)
        private String specialty;
        @SerializedName(APIConstants.API_HOME_V2_STORE_IMAGE)
        private String image;
        @SerializedName(APIConstants.API_HOME_V2_STORE_TOP_PRODUCT)
        private TopProduct topProduct;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public TopProduct getTopProduct() {
            return topProduct;
        }

        public void setTopProduct(TopProduct topProduct) {
            this.topProduct = topProduct;
        }
    }
}