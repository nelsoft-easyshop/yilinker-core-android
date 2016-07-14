package com.yilinker.core.model.buyer.productV2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 7/4/2016.
 */
public class ProductReview {

    @SerializedName("ratingAverage")
    private float ratingAverage;
    @SerializedName("reviews")
    private List<Reviews> reviews;

    public float getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(float ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public class Reviews {

        @SerializedName("title")
        private String title;
        @SerializedName("review")
        private String review;
        @SerializedName("rating")
        private String rating;
        @SerializedName("fullName")
        private String fullName;
        @SerializedName("firstName")
        private String firstName;
        @SerializedName("lastName")
        private String lastName;
        @SerializedName("profileImageUrl")
        private String profileImageUrl;
        @SerializedName("dateAdded")
        private String dateAdded;

        @SerializedName("userId")
        private int id;

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

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    public static class ProductReviewInstance implements InstanceCreator<ProductReview> {

        @Override
        public ProductReview createInstance(Type type) {

            return new ProductReview();

        }

    }

}
