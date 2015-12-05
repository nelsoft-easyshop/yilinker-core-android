package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 02/12/2015.
 */
public class TopProducts {

    @SerializedName(APIConstants.API_HOME_V2_IMAGE)
    private String image;
    @SerializedName(APIConstants.API_HOME_V2_TARGET)
    private Target target;
    @SerializedName(APIConstants.API_HOME_V2_NAME)
    private String name;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_ORIGINAL_PRICE)
    private String originalPrice;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_DISCOUNTED_PRICE)
    private String discountedPrice;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_DISCOUNTED_PERCENTAGE)
    private String discountPercentage;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_CURRENCY)
    private String currency;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public static class TopProductsInstance implements InstanceCreator<TopProducts> {

        @Override
        public TopProducts createInstance(Type type) {

            return new TopProducts();
        }
    }
}
