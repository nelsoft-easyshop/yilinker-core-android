package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybryantc on 2/23/16.
 */
public class ProductStatusList {

    @SerializedName("save")
    private List<ProductStatus> selectedProducts;
    @SerializedName("remove")
    private List<ProductStatus> unselectedProducts;

    public List<ProductStatus> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<ProductStatus> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<ProductStatus> getUnselectedProducts() {
        return unselectedProducts;
    }

    public void setUnselectedProducts(List<ProductStatus> unselectedProducts) {
        this.unselectedProducts = unselectedProducts;
    }

    public class ProductStatus {

        @SerializedName("error")
        private String error;
        @SerializedName("isSuccessful")
        private boolean successful;
        @SerializedName("product")
        private int productId;
        @SerializedName("manufacturerProductId")
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public boolean isSuccessful() {
            return successful;
        }

        public void setSuccessful(boolean successful) {
            this.successful = successful;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }
    }

    public static class ProductStatusListInstance implements InstanceCreator<ProductStatusList> {

        @Override
        public ProductStatusList createInstance(Type type) {
            return new ProductStatusList();
        }
    }

}
