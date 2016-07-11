package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/5/2015.
 */
public class CartItem2 {

    private int id;
    private String productName;
    private String title;
    private String image;
    private List<ProductImages> images;
    private String shortDescription;
    private String fullDescription;

    private int sellerId;
    private List<ProductGroupAttribute> attributes;
//    private List<AttributeCombination> productUnit
    private List<AttributeCombination2> productUnits;
    private String price;
    private String discountedPrice;
    private double discount;

    private List<Integer> selectedAttributes;
//    private List<ProductCartItem> productUnits;
    private int unitId;
    private int quantity;
    private  int itemId;

    @SerializedName("hasCOD")
    private boolean isCODAvailble;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ProductImages> getImages() {
        return images;
    }

    public void setImages(List<ProductImages> images) {
        this.images = images;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public List<ProductGroupAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ProductGroupAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<AttributeCombination2> getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(List<AttributeCombination2> productUnits) {
        this.productUnits = productUnits;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<Integer> getSelectedAttributes() {
        return selectedAttributes;
    }

    public void setSelectedAttributes(List<Integer> selectedAttributes) {
        this.selectedAttributes = selectedAttributes;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isCODAvailble() {
        return isCODAvailble;
    }

    public void setIsCODAvailble(boolean isCODAvailble) {
        this.isCODAvailble = isCODAvailble;
    }

    public static class CartItemInstance2 implements InstanceCreator<CartItem2> {

        @Override
        public CartItem2 createInstance(Type type) {

            return new CartItem2();
        }
    }
}