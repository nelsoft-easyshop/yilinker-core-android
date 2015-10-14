package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.yilinker.core.model.buyer.ProductGroupAttribute;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Jay Bryant Casilang on 8/13/2015.
 */
public class ProductUpload {

    private final static String OBJ_NAME = "ProductUpload";
    private static final String KEY_IMAGES = "images";
    private static final String KEY_TITLE = "title";
    private static final String KEY_SHORT_DESCRIPTION = "shortDescription";
    private static final String KEY_FULL_DESCRIPTION = "fullDescription";
    private static final String KEY_SELLER_ID = "sellerId";
    private static final String KEY_ATTRIBUTES = "attributes";
    private static final String KEY_AVAILABLE_ATTRIBUTES = "availableAttributeCombi";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DISCOUNTED_PRICE = "discountedPrice";
    private static final String KEY_LENGTH = "length";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_WIDTH = "width";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_CONDITION = "condition";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_SKU = "sku";

    private int productId, sellerId, quantity, brandId, categoryId, conditionId;
    private String productUnitId;
    private List<String> images;
    private String title, shortDescription, fullDescription, customBrand, sku;
    private double price, discountedPrice,length, weight, height, width;
    private List<ProductGroupAttribute> productGroupAttributeList;
    private List<AttributeCombinationUpload> attributeCombinationUploadList;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<AttributeCombinationUpload> getAttributeCombinationUploadList() {
        return attributeCombinationUploadList;
    }

    public void setAttributeCombinationUploadList(List<AttributeCombinationUpload> attributeCombinationUploadList) {
        this.attributeCombinationUploadList = attributeCombinationUploadList;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCustomBrand() {
        return customBrand;
    }

    public void setCustomBrand(String customBrand) {
        this.customBrand = customBrand;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }

    public List<ProductGroupAttribute> getProductGroupAttributeList() {
        return productGroupAttributeList;
    }

    public void setProductGroupAttributeList(List<ProductGroupAttribute> productGroupAttributeList) {
        this.productGroupAttributeList = productGroupAttributeList;
    }

    public JSONArray getImageIndicesArray() {

        final JSONArray arrayIndices = new JSONArray();

        Integer index = 0;

        for (String string: this.images) {
            arrayIndices.put(index);
            index++;
        }

//        for (AttributeCombinationUpload attributeCombinationUpload: attributeCombinationUploadList) {
//            for (String string : attributeCombinationUpload.getImages()) {
//                arrayIndices.put(index);
//                index++;
//            }
//        }

        return arrayIndices;
    }

    public JSONArray getProductProperties() {

        final JSONArray arrayProductProperties = new JSONArray();

        int index = this.images.size();

        try {
            for (int i = 0; i < attributeCombinationUploadList.size(); i++) {

                AttributeCombinationUpload attributeCombinationUpload = attributeCombinationUploadList.get(i);

                JSONObject jsonProductProperty = new JSONObject();
                JSONArray arrayAttributes = new JSONArray();
                for (int j = 0; j < productGroupAttributeList.size(); j++) {

                    JSONObject jsonAttribute = new JSONObject();

                    jsonAttribute.put("name", productGroupAttributeList.get(j).getName());
                    jsonAttribute.put("value", attributeCombinationUpload.getCombinationList().get(j));
                    arrayAttributes.put(jsonAttribute);

                }

                jsonProductProperty.put("attribute", arrayAttributes);
                jsonProductProperty.put("price", attributeCombinationUpload.getRetailPrice());
                jsonProductProperty.put("discountedPrice", attributeCombinationUpload.getDiscountedPrice() >= 0.00 ? attributeCombinationUpload.getDiscountedPrice() : null);
                jsonProductProperty.put("sku",attributeCombinationUpload.getSku());
                jsonProductProperty.put("images", attributeCombinationUpload.getImageIndices(index));
                jsonProductProperty.put("quantity",attributeCombinationUpload.getQuantity());
                jsonProductProperty.put("unitLength", attributeCombinationUpload.getLength());
                jsonProductProperty.put("unitWeight", attributeCombinationUpload.getWeight());
                jsonProductProperty.put("unitHeight", attributeCombinationUpload.getHeight());
                jsonProductProperty.put("unitWidth", attributeCombinationUpload.getWidth());
                if (attributeCombinationUpload.getProductUnitId() != null)
                    jsonProductProperty.put("productUnitId", attributeCombinationUpload.getProductUnitId());

                arrayProductProperties.put(jsonProductProperty);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return arrayProductProperties;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_IMAGES + images + "," + KEY_TITLE + title + "," + KEY_SHORT_DESCRIPTION + shortDescription + ","
                + KEY_FULL_DESCRIPTION + fullDescription + "," + KEY_SELLER_ID + sellerId + ","
                + KEY_PRICE + price + "," + KEY_DISCOUNTED_PRICE + discountedPrice + ","
                + KEY_LENGTH + length + ","  + KEY_WEIGHT + weight + ","
                + KEY_WIDTH + width + "," + KEY_HEIGHT + height + ","
                + KEY_CONDITION + conditionId + "," + KEY_BRAND + brandId + "," + KEY_QUANTITY + quantity + "]" ;
    }

    public static class ProductUploadInstance implements InstanceCreator<ProductUpload> {
        @Override
        public ProductUpload createInstance(Type type) {
            return new ProductUpload();
        }
    }
}
