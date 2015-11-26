package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 11/25/2015.
 */
public class TopProduct {

    @SerializedName(APIConstants.API_HOME_V2_PRODUCT)
    private Product product;
    @SerializedName(APIConstants.API_HOME_V2_TARGET)
    private Target target;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public static class TopProductInstance implements InstanceCreator<TopProduct> {

        @Override
        public TopProduct createInstance(Type type) {
            return new TopProduct();
        }
    }
}