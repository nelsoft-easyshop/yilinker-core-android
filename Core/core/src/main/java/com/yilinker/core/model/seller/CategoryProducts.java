package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Created by Bryan on 9/2/2015.
 */
public class CategoryProducts implements Serializable {

    private int productId;
    private String productName;
    private String image;
    private int status;

    public CategoryProducts(){

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public static class CategoryProductsInstance implements InstanceCreator<CategoryProducts> {
        @Override
        public CategoryProducts createInstance(Type type) {
            return new CategoryProducts();
        }
    }
}
