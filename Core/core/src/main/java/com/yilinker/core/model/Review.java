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

    private int userId;
    private String title;
    private String review;
    private float rating;
    private String fullName;
    private String profileImageUrl;
    private String dateAdded;

    /***for sellerReivew*/
    private String storeName;
    private String feedback;
    private String averageRating;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    //    @Override
//    public String toString() {
//        return OBJ_NAME + "[" + KEY_NAME + name + KEY_IMAGE_URL + imageUrl + ", " + KEY_RATING + rating + ", " + KEY_MESSAGE + message + "]";
//    }

    @Override
    public String toString() {
        return OBJ_NAME;
    }

    public static class ReviewInstance implements InstanceCreator<Review> {

        @Override
        public Review createInstance(Type type) {

            return new Review();
        }
    }
}
