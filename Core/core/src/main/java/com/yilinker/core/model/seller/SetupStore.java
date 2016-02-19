package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 2/18/2016.
 */
public class SetupStore {

    @SerializedName(APIConstants.STORE_SETUP_SLUG)
    private String storeSlug;
    @SerializedName(APIConstants.STORE_SETUP_NAME)
    private String storeName;
    @SerializedName(APIConstants.STORE_SETUP_DESCRIPTION)
    private String storeDescription;

    public String getStoreSlug() {
        return storeSlug;
    }

    public void setStoreSlug(String storeSlug) {
        this.storeSlug = storeSlug;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public static class SetupStoreInstance implements InstanceCreator<SetupStore> {

        @Override
        public SetupStore createInstance(Type type) {

            return new SetupStore();

        }

    }
}
