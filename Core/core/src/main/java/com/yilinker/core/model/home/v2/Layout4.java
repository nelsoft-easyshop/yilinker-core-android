package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rlcoronado on 26/11/2015.
 */
public class Layout4<T> {

    @SerializedName(APIConstants.API_HOME_V2_SALE_REMAINING_TIME)
    private String remainingTime;
    private List<T> data;
    @SerializedName(APIConstants.API_HOME_V2_TARGET)
    private Target target;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT)
    private Product product;

    public String getRemainingTime() {
        return remainingTime;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setRemainingTime(String remainingTime) {
        this.remainingTime = remainingTime;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public static class Layout4Instance implements InstanceCreator<Layout4>{

        @Override
        public Layout4 createInstance(Type type) {
            return new Layout4();
        }
    }
}
