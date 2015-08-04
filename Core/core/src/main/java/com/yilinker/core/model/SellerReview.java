package com.yilinker.core.model;

import java.util.List;

/**
 * Created by J.Bautista
 */
public class SellerReview {

    private static final String OBJ_NAME = "SellerReview";
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
}
