package com.yilinker.core.model.buyer.product2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import static com.yilinker.core.constants.ProductAPIConstants.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 7/4/2016.
 */
public class ProductReview {

    @SerializedName(KEY_RATING_AVERAGE)
    private float ratingAverage;
    @SerializedName(KEY_REVIEWS)
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

        @SerializedName(KEY_TITLE)
        private String title;
        @SerializedName(KEY_REVIEW)
        private String review;
        @SerializedName(KEY_RATING)
        private String rating;
        @SerializedName(KEY_FULL_NAME)
        private String fullName;
        @SerializedName(KEY_FIRST_NAME)
        private String firstName;
        @SerializedName(KEY_LAST_NAME)
        private String lastName;
        @SerializedName(KEY_PROFILE_IMAGE_URL)
        private String profileImageUrl;
        @SerializedName(KEY_DATE_ADDED)
        private String dateAdded;

        @SerializedName(KEY_USER_ID)
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
