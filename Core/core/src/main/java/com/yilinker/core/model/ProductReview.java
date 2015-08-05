package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista
 */
public class ProductReview {

    private static final String OBJ_NAME = "ProductReview";
    private static final String KEY_RATING = "rating";
    private static final String KEY_REVIEWS = "reviews";

    private int rating;
    private List<Review> reviews;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_RATING + ", " + KEY_REVIEWS + reviews + "]";
    }

    public static class ProductReviewInstance implements InstanceCreator<ProductReview> {

        @Override
        public ProductReview createInstance(Type type) {

            return new ProductReview();
        }
    }
}
