package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybryantc on 2/23/16.
 */
public class ProductSelection {

    @SerializedName("selectedProductCount")
    private int selectProductCount;
    @SerializedName("manufacturerProductIds")
    private int[] manufacturerProductIds;
    @SerializedName("selectedManufacturerProductIds")
    private int[] selectedManufacturerProductIds;
    @SerializedName("storeSpace")
    private int storeSpace;
    @SerializedName("products")
    private List<Product> products;

    public ProductSelection() {

    }

    public int getSelectProductCount() {
        return selectProductCount;
    }

    public void setSelectProductCount(int selectProductCount) {
        this.selectProductCount = selectProductCount;
    }

    public int[] getManufacturerProductIds() {
        return manufacturerProductIds;
    }

    public void setManufacturerProductIds(int[] manufacturerProductIds) {
        this.manufacturerProductIds = manufacturerProductIds;
    }

    public int[] getSelectedManufacturerProductIds() {
        return selectedManufacturerProductIds;
    }

    public void setSelectedManufacturerProductIds(int[] selectedManufacturerProductIds) {
        this.selectedManufacturerProductIds = selectedManufacturerProductIds;
    }

    public int getStoreSpace() {
        return storeSpace;
    }

    public void setStoreSpace(int storeSpace) {
        this.storeSpace = storeSpace;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Product Model
     */

    public class Product {

        @SerializedName("manufacturerProductId")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("storeName")
        private String storeName;
        @SerializedName("originalPrice")
        private double originalPrice;
        @SerializedName("discountedPrice")
        private double price;
        @SerializedName("discount")
        private double discount;
        @SerializedName("commission")
        private double commision;
        @SerializedName("images")
        private List<String> imageUrls;
        @SerializedName("units")
        private List<Unit> units;
        @SerializedName("isSelected")
        private boolean selected;

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

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getCommision() {
            return commision;
        }

        public void setCommision(double commision) {
            this.commision = commision;
        }

        public double getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(double originalPrice) {
            this.originalPrice = originalPrice;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public List<String> getImageUrls() {
            return imageUrls;
        }

        public void setImageUrls(List<String> imageUrls) {
            this.imageUrls = imageUrls;
        }

        public List<Unit> getUnits() {
            return units;
        }

        public void setUnits(List<Unit> units) {
            this.units = units;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public class Unit {

            @SerializedName("manufacturerProductUnitId")
            private int id;
            @SerializedName("quantity")
            private int quantity;
            @SerializedName("retailPrice")
            private double originalPrice;
            @SerializedName("discountedPrice")
            private double price;
            @SerializedName("commission")
            private double earning;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public double getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(double originalPrice) {
                this.originalPrice = originalPrice;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getEarning() {
                return earning;
            }

            public void setEarning(double earning) {
                this.earning = earning;
            }

        }

    }


    public static class ProductSelectionInstance implements InstanceCreator<ProductSelection> {

        @Override
        public ProductSelection createInstance(Type type) {
            return new ProductSelection();
        }

    }

}
