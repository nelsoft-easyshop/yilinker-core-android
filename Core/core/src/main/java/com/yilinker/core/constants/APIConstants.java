package com.yilinker.core.constants;

import com.yilinker.core.BuildConfig;

/**
 * Created by J.Bautista
 */
public class APIConstants {

    //access token
    public static final String ACCESS_TOKEN = "access_token";

    //temp
    public static final String DOMAIN = BuildConfig.SERVER_URL;

    //For Product API
    public static final String PRODUCT_API = "product";
    public static final String PRODUCT_GET_DETAILS = "getProductDetail";
    public static final String PRODUCT_GET_DETAILS_PARAM_ID = "productId";

    public static final String PRODUCT_GET_LIST = "getProductList";
    public static final String PRODUCT_GET_LIST_PARAM_FILTER = "filterType";
    public static final String PRODUCT_GET_LIST_PARAM_SEARCH_KEY = "searchKey";
    public static final String PRODUCT_GET_LIST_PARAM_CATEGORY = "category";
    public static final String PRODUCT_GET_LIST_PARAM_SELLERID = "sellerId";
    public static final String PRODUCT_GET_LIST_PARAM_PAGE = "page";

    public static final String PRODUCT_UNIT_ID = "unitId";
    public static final String PRODUCT_QUANTITY = "quantity";
    public static final String PRODUCT_ID = "productId";

    public static final String PRODUCT_GET_REVIEW = "getReviews";
    public static final String PRODUCT_GET_REVIEW_PARAM_ID = "productId";

    //For Seller API
    public static final String SELLER_API = "seller";
    public static final String SELLER_GET_DETAILS = "getDetails";
    public static final String SELLER_GET_DETAILS_PARAM_ID = "sellerId";

    //For Cart API
    public static final String CART_API = "cart";
    public static final String CART_UPDATE_DETAILS = "updateCartDetails";
    public static final String CART_UPDATE_ITEM = "updateCartItem";

    //For Home API
    public static final String HOME_API = "home";
    public static final String HOME_GET_ITEMS = "getItems";

    //For User API

    public static final String USER_API = "user";

    //For Registration API
    public static final String REG_API = "register";
    public static final String REG_PARAM_FIRSTNAME = "firstName";
    public static final String REG_PARAM_LASTNAME = "lastName";
    public static final String REG_PARAM_EMAIL = "emailAddress";
    public static final String REG_PARAM_PASSWORD = "password";
    public static final String REG_PARAM_REFERRAL = "referralCode";

    //For Login API
    public static final String TOKEN_API = "token";
    public static final String LOGIN_API = "login";
    public static final String LOGIN_PARAM_CLIENT_ID = "client_id";
    public static final String LOGIN_PARAM_CLIENT_SECRET = "client_secret";
    public static final String LOGIN_PARAM_GRANT_TYPE = "grant_type";
    public static final String LOGIN_PARAM_EMAIL = "email";
    public static final String LOGIN_PARAM_PASSWORD = "password";

    //API Credentials
    public static final String API_CLIENT_ID = "1_167rxzqvid8g8swggwokcoswococscocc8ck44wo0g88owgkcc";
    public static final String API_CLIENT_SECRET = "317eq8nohry84ooc0o8woo8000c0k844c4cggws84g80scwwog";
}

