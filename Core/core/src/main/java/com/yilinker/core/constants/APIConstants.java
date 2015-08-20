package com.yilinker.core.constants;

import com.yilinker.core.base.BaseApplication;

/**
 * Created by J.Bautista
 */
public class APIConstants {

    //access token
    public static final String ACCESS_TOKEN = "access_token";


    //upload token
    public static final String UPLOAD_TOKEN = "upload_token";

    //temp
    public static final String DOMAIN = "http://merchant.online.api.easydeal.ph/api/v1";

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

    public static final String PRODUCT_LIST_TARGET = "target";
    public static final String PRODUCT_lIST_PRICE_FROM = "priceFrom";
    public static final String PRODUCT_LIST_PRICE_TO = "priceTo";
    public static final String PRODUCT_LIST_CATEGORY_ID = "categoryId";
    public static final String PRODUCT_lIST_SELLER_ID = "sellerId";
    public static final String PRODUCT_LIST_SORT_TYPE ="sortType";
    public static final String PRODUCT_LIST_SORT_DIRECTION = "sortDirection";
    public static final String PRODUCT_lIST_FILTER = "filters";
    public static final String PRODUCT_LIST_BRAND_ID = "brandId";
    public static final String PRODUCT_LIST_PAGE = "page";

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
    public static final String CART_GET_ITEMS = "getCart";
    public static final String CART_UPDATE_DETAILS = "updateCartDetails";
    public static final String CART_UNIT_ID = "unitId";
    public static final String CART_QUANTITY = "quantity";
    public static final String WISH_LIST_GET_ITEMS = "wishlist";

    //For Home API
    public static final String HOME_API = "home";
    public static final String HOME_GET_ITEMS = "getData";

    //For User API
    public static final String USER_API = "user";

    //For Registration API
    public static final String REG_API = "register";
    public static final String REG_PARAM_FULLNAME = "fullname";
    public static final String REG_PARAM_EMAIL = "email";
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

    //For Product Upload API
    public static final String PRODUCT_UPLOAD_API="upload";
    public static final String PRODUCT_UPLOAD_PARAM_IMAGES = "images[]";
    public static final String PRODUCT_UPLOAD_PARAM_CATEGORY = "productCategory";
    public static final String PRODUCT_UPLOAD_PARAM_BRAND = "brand";
    public static final String PRODUCT_UPLOAD_PARAM_TITLE = "title";
    public static final String PRODUCT_UPLOAD_PARAM_DESCRIPTION = "description";
    public static final String PRODUCT_UPLOAD_PARAM_SHORT_DESCRIPTION = "shortDescription";
    public static final String PRODUCT_UPLOAD_PARAM_CONDITION = "condition";
    public static final String PRODUCT_UPLOAD_PARAM_ISFREESHIPPING = "isFreeShipping";
    public static final String PRODUCT_UPLOAD_PARAM_LENGTH = "length";
    public static final String PRODUCT_UPLOAD_PARAM_WIDTH = "width";
    public static final String PRODUCT_UPLOAD_PARAM_HEIGHT = "height";
    public static final String PRODUCT_UPLOAD_PARAM_WEIGHT = "weight";
    public static final String PRODUCT_UPLOAD_PARAM_QUANTITY = "quantity";
    public static final String PRODUCT_UPLOAD_PARAM_SKU = "sku";
    public static final String PRODUCT_UPLOAD_PARAM_PRICE = "price";
    public static final String PRODUCT_UPLOAD_PARAM_DISCOUNTED_PRICE = "discountedPrice";
    public static final String PRODUCT_UPLOAD_PARAM_PRODUCT_PROPERTIES = "productProperties";
    public static final String PRODUCT_UPLOAD_PARAM_CUSTOM_BRAND = "customBrand";

    public static final String PRODUCT_UPLOAD_GET_BRAND = "getBrands";
    public static final String PRODUCT_UPLOAD_GET_BRAND_PARAM_BRAND_KEYWORD = "brandKeyword";

    public static final String PRODUCT_UPLOAD_GET_CATEGORIES = "getCategories";
    public static final String PRODUCT_UPLOAD_GET_CATEGORIES_PARAM_PARENT_ID = "parentId";

    public static final String PRODUCT_UPLOAD_GET_CONDITIONS = "getProductConditions";



    //API Credentials
    public static final String API_CLIENT_ID = "1_167rxzqvid8g8swggwokcoswococscocc8ck44wo0g88owgkcc";
    public static final String API_CLIENT_SECRET = "317eq8nohry84ooc0o8woo8000c0k844c4cggws84g80scwwog";
    public static final String API_CONNECTION_PROBLEM = "Problem connecting to the server. Try again later.";

    //Store Address
    public static final String STORE_ADDRESS = "storeAddress";
    public static final String STORE_ADDRESS_ADD = "addStoreAddress";
    public static final String ADDRESS_TITLE = "addressTitle";
    public static final String ADDRESS_LINE1 = "addressLine1";
    public static final String ADDRESS_LINE2 = "addressLine2";
    public static final String ADDRESS_ADDITIONAL_INFO = "additionalInfo";

    //Mobile Verification
    public static final String AUTH = "auth/sms";
    public static final String GET_CODE = "getCode";
    public static final String VERIFY = "verify";
    public static final String VERIFY_PARAM_VERIFICATION_CODE = "code";

    //Update User Info
    public static final String UPDATE_USER_API = "user";
    public static final String USER_UPDATE_API = "update";
    public static final String PROFILE_PHOTO_PARAM = "profilePhoto";
    public static final String COVER_PHOTO_PARAM = "coverPhoto";
    public static final String STORE_NAME_PARAM = "storeName";
    public static final String STORE_DESCRIPTION_PARAM = "storeDescription";
    public static final String STREET_ADDRESS_PARAM = "streetAddress";



}
