package com.yilinker.core.constants;

import com.yilinker.core.BuildConfig;

/**
 * Created by J.Bautista
 */
public class APIConstants {

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

    public static final String PRODUCT_GET_REVIEW = "getProductReview";
    public static final String PRODUCT_GET_REVIEW_PARAM_ID = "productId";

    //For Seller API
    public static final String SELLER_API = "seller";
    public static final String SELLER_GET_DETAILS = "getDetails";
    public static final String SELLER_GET_DETAILS_PARAM_ID = "sellerId";

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

    //For Login API
    public static final String TOKEN_API = "token";
    public static final String LOGIN_API = "login";
    public static final String LOGIN_PARAM_CLIENT_ID = "client_id";
    public static final String LOGIN_PARAM_CLIENT_SECRET = "client_secret";
    public static final String LOGIN_PARAM_GRANT_TYPE = "grant_type";
    public static final String LOGIN_PARAM_EMAIL = "email";
    public static final String LOGIN_PARAM_PASSWORD = "password";
}
