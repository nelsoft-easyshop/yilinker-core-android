package com.yilinker.core.model;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.InstanceCreator;

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

    private int sellerId, quantity;
    private List<String> images;
    private String title, shortDescription, fullDescription, condition, brand,category;
    private double price, discountedPrice,length, weight, height, width;
    private List<ProductGroupAttribute> productGroupAttributeList;
    private List<AttributeCombinationUpload> attributeCombinationUploadList;

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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public List<ProductGroupAttribute> getProductGroupAttributeList() {
        return productGroupAttributeList;
    }

    public void setProductGroupAttributeList(List<ProductGroupAttribute> productGroupAttributeList) {
        this.productGroupAttributeList = productGroupAttributeList;
    }

    public List<AttributeCombinationUpload> getAttributeCombinationUploadList() {
        return attributeCombinationUploadList;
    }

    public void setAttributeCombinationUploadList(List<AttributeCombinationUpload> attributeCombinationUploadList){
        this.attributeCombinationUploadList = attributeCombinationUploadList;
    }

    public JSONArray getProductProperties() {

        final JSONArray arrayProductProperties = new JSONArray();

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
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
                        jsonProductProperty.put("discountedPrice", attributeCombinationUpload.getDiscountedPrice());
                        jsonProductProperty.put("sku","");
                        jsonProductProperty.put("images", attributeCombinationUpload.getImages());

                        arrayProductProperties.put(jsonProductProperty);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();

        return arrayProductProperties;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_IMAGES + images + "," + KEY_TITLE + title + "," + KEY_SHORT_DESCRIPTION + shortDescription + ","
                + KEY_FULL_DESCRIPTION + fullDescription + "," + KEY_SELLER_ID + sellerId + ","
                + KEY_PRICE + price + "," + KEY_DISCOUNTED_PRICE + discountedPrice + ","
                + KEY_LENGTH + length + ","  + KEY_WEIGHT + weight + ","
                + KEY_WIDTH + width + "," + KEY_HEIGHT + height + ","
                + KEY_CONDITION + condition + "," + KEY_BRAND + brand + "," + KEY_QUANTITY + quantity + "]" ;
    }

    public static class ProductUploadInstance implements InstanceCreator<ProductUpload> {
        @Override
        public ProductUpload createInstance(Type type) {
            return new ProductUpload();
        }
    }
}
