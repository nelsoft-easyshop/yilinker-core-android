package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista
 */
public class Review {

    private static final String OBJ_NAME = "Review";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE_URL = "imageUrl";
    private static final String KEY_RATING = "rating";
    private static final String KEY_MESSAGE = "message";

    private String name;
    private String imageUrl;
    private int rating;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_NAME + name + KEY_IMAGE_URL + imageUrl + ", " + KEY_RATING + rating + ", " + KEY_MESSAGE + message + "]";
    }

    public static class ReviewInstance implements InstanceCreator<Review> {

        @Override
        public Review createInstance(Type type) {

            return new Review();
        }
    }
}
