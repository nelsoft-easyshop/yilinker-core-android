package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by J.Bautista
 */
public class AttributeCombination {

    private static final String OBJ_NAME = "AttributeCombination";
    private static final String KEY_COMBINATION = "combination";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_IMAGES = "imageIds";

    private int[] combination;
    private int quantity;
    private List<String> imageIds = new ArrayList<String>();


    public int[] getCombination() {
        return combination;
    }

    public void setCombination(int[] combination) {
        this.combination = combination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getImages() {
        return imageIds;
    }

    public void setImages(List<String> images) {
        this.imageIds = imageIds;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_COMBINATION + combination + ", " + KEY_QUANTITY + quantity + ", " + KEY_IMAGES + imageIds + "]";
    }

    public static class AttributeCombinationInstance implements InstanceCreator<AttributeCombination>{

        @Override
        public AttributeCombination createInstance(Type type) {

            return new AttributeCombination();
        }
    }
}
