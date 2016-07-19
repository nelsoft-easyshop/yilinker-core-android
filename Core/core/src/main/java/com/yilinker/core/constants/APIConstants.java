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
    public static final String DOMAIN = BaseApplication.getDomainURL();
    public static final String API_CLIENT_ID = BaseApplication.getClientIdFromApplication();
    public static final String API_CLIENT_SECRET = BaseApplication.getClientSecretFromApplication();
    public static final String AUTH_API = "auth";
    public static final String MERCHANT_API = "merchant";
    public static final String AFFILIATE_API = "affiliate";
    public static final String CANCELLATION_API = "cancellation";
    public static final String TRANSACTION_API = "transaction";
    public static final String RESELLER_API = "reseller";
    //public static final String DOMAIN = "http://online.api.easydeal.ph/api/v1";

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
    public static final String ORDER_PRODUCT_ID = "orderProductId";

    public static final String PRODUCT_GET_REVIEW = "getReviews";
    public static final String PRODUCT_GET_PRODUCT_REVIEW = "getProductReviews";
    public static final String PRODUCT_GET_REVIEW_PARAM_ID = "productId";
    public static final String PRODUCT_ADD_PRODUCT_REVIEW = "addProductReview";
    public static final String PRODUCT_ADD_SELLER_REVIEW = "addUserFeedback";
    public static final String PRODUCT_GET_SELLER_REVIEW = "getUserFeedbacks";
    public static final String PRODUCT_REVIEW = "review";
    public static final String PRODUCT_RATING  = "rating";
    public static final String PRODUCT_RATINGS  = "ratings";
    public static final String PRODUCT_FEEDBACK  = "feedback";
    public static final String PRODUCT_REVIEW_TITLE = "title";
    public static final String PRODUCT_REVIEW_ORDER_ID = "orderId";
    public static final String PRODUCT_REVIEW_SELLER_ID = "sellerId";

    //For Seller API
    public static final String SELLER_API = "seller";
    public static final String SELLER_USER_ID = "userId";
    public static final String SELLER_GET_DETAILS = "getDetails";
    public static final String SELLER_GET_DETAILS_PARAM_ID = "sellerId";
    public static final String SELLER_GET_SELLER_REVIEWS = "getReviews";
    public static final String SELLER_GET_STORE_INFO = "getStoreInfo";
    public static final String SELLER_GET_FOLLOWED_SELLERS = "getFollowedSellers";
    public static final String SELLER_GET_FOLLOW_HISTORY = "getFollowHistory";
    public static final String SELLER_FOLLOW_SELLER = "followSeller";
    public static final String SELLER_UNFOLLOW_SELLER = "unfollowSeller";
    public static final String SELLER_PARAMS_PAGE = "page";
    public static final String SELLER_PARAMS_LIMIT = "limit";
    public static final String SELLER_PARAMS_KEYWORD = "keyword";
    public static final String SELLER_GET_FOLLOWERS = "getFollowers";
    public static final String SELLER_PARAMS_SEARCH_KEYWORD = "searchKeyword";
    public static final String SEARCH_TRANSACTION_API = "transaction";
    public static final String SEARCH_QUERY_TRANSACTION = "query";
    public static final String GENERATE_QR_CODE_API = "getQrCode";

    /***Payout Module*/
    public static final String PAYOUT_BALANCE_RECORD_DETAILS = "balanceRecordDetails";
    public static final String PAYOUT_AMOUNT = "amount";
    public static final String PAYOUT_WITHDRAWAL_METHOD = "withdrawalMethod";
    public static final String PAYOUT_OTP = "otp";
    public static final String PAYOUT_WITHDRAWAL_REQUEST = "withdrawal-request";
    public static final String PAYOUT_WITHDRAWAL_LIST = "withdraw-list";
    public static final String PAYOUT_GET_EARNING_GROUPS = "earning-groups";
    public static final String PAYOUT_GET_EARNING_LIST = "earning-list";
    public static final String PAYOUT_PARAMS_EARNINGS_GROUP_ID = "earningGroupId";
    public static final String PAYOUT_PARAMS_EARNINGS_GROUP_PAGE = "page";
    public static final String PAYOUT_PARAMS_EARNINGS_GROUP_PER_PAGE = "perPage";

    /***One Time Password*/
    public static final String SEND = "send";
    public static final String TYPE= "type";

    //For Cart API
    public static final String CART_API = "cart";
    public static final String CART_GET_ITEMS = "getCart";
    public static final String CART_UPDATE_DETAILS = "updateCartItem";
    public static final String CART_UNIT_ID = "unitId";
    public static final String CART_QUANTITY = "quantity";
    public static final String CART_ITEM_ID = "itemId";
    public static final String WISH_LIST_GET_ITEMS = "wishlist";
    public static final String WISH_LIST_TO_CART = "wishlistToCart";
    public static final String ITEM_IDS = "itemIds";

    //For Checkout
    public static final String CHECKOUT_GUEST             = "isGuest";
    public static final String CHECKOUT_VERIFICATION_CODE = "verificationCode";
    public static final String CHECKOUT_CONTACT_NUMBER = "contactNumber";
    public static final String CHECKOUT_FIRST_NAME = "firstName";
    public static final String CHECKOUT_LAST_NAME = "lastName";
    public static final String CHECKOUT_MOBILE_PHONE = "contactNo";
    public static final String CHECKOUT_EMAIL     = "email";
    public static final String CHECKOUT_UPDATE_BASIC_INFO = "update-basic-info";
    public static final String CHECKOUT_TOKEN = "token";
    public static final String CHECKOUT_VALIDATE = "validate";

    //For Profile API
    public static final String PROFILE_API = "user";
    public static final String PROFILE_GET_DETAILS = "getUser";
    public static final String PROFILE_EDIT_DETAILS = "editProfile";
    public static final String PROFILE_PHOTO = "profilePhoto";
    public static final String PROFILE_USER_DOCUMENTS = "userDocument";
    public static final String PROFILE_COVER_PHOTO = "coverPhoto";
    public static final String PROFILE_FIRST_NAME = "firstName";
    public static final String PROFILE_LAST_NAME = "lastName";
    public static final String PROFILE_CONTACT_NUMBER = "contactNumber";
    public static final String PROFILE_GENDER = "gender";
    public static final String PROFILE_BIRTH_DATE = "birthdate";
    public static final String PROFILE_NICK_NAME = "nickname";
    public static final String PROFILE_SLUG = "slug";
    public static final String PROFILE_OLD_PASSWORD = "oldPassword";
    public static final String PROFILE_NEW_PASSWORD = "newPassword";
    public static final String PROFILE_NEW_PASSWORD_CONFIRMED = "newPasswordConfirm";
    public static final String PROFILE_USER_ADDRESS_ID = "userAddressId";
    public static final String PROFILE_LOCATION_ID = "locationId";
    public static final String PROFILE_TITLE = "title";
    public static final String PROFILE_UNIT_NUMBER = "unitNumber";
    public static final String PROFILE_BUILDING_NAME = "buildingName";
    public static final String PROFILE_STREET_NUMBER = "streetNumber";
    public static final String PROFILE_STREET_NAME = "streetName";
    public static final String PROFILE_SUBDIVISION = "subdivision";
    public static final String PROFILE_ZIP_CODE = "zipCode";
    public static final String PROFILE_STREET_ADDRESS = "streetAddress";
    public static final String PROFILE_LONGITUDE = "longitude";
    public static final String PROFILE_LATITUDE = "latitude";
    public static final String PROFILE_LANDLINE = "landline";
    public static final String PROFILE_ISSUBSCRIBE = "isSubscribe";
    public static final String PROFILE_SUBSCRIPTION_API = "subscription";
    public static final String PROFILE_REFERRAL_CODE = "referralCode";
    public static final String PROFILE_LANGUAGE_ID = "languageId";
    public static final String PROFILE_COUNTRY_ID = "countryId";

    //For Activity Log
    public static final String ACTIVITY_LOG_GET_ITEMS = "activityLog";

    //For Home API
    public static final String HOME_API = "home";
    public static final String HOME_GET_ITEMS = "getData";

    //For User API
    public static final String USER_API = "user";

    //For Registration API
    public static final String REG_API = "register";
    public static final String REG_GUEST_API = "registerGuestUser";
    public static final String REG_PARAM_FULLNAME = "fullname";
    public static final String REG_PARAM_FIRST_NAME = "firstName";
    public static final String REG_PARAM_LAST_NAME = "lastName";
    public static final String REG_PARAM_MOBILE = "contactNumber";
    public static final String REG_PARAM_EMAIL = "email";
    public static final String REG_PARAM_PASSWORD = "password";
    public static final String REG_PARAM_REFERRAL = "referrerCode";
    public static final String REG_PARAM_GUEST = "user_guest";
    public static final String REG_PARAM_PLAIN_PASSWORD = "plainPassword";
    public static final String REG_PARAM_FIRST = "first";
    public static final String REG_PARAM_SECOND = "second";

    //For Simplified Registration/Login
    public static final String REG_PARAM_AREA_CODE = "areaCode";
    public static final String REG_PARAM_UNAUTHENTICATION_TYPE = "type";
    public static final String REG_PARAM_STORE_TYPE = "storeType";
    public static final String REG_PARAM_VERIFICATION_CODE = "verificationCode";
    public static final String REG_PARAM_NEW_PASSWORD = "newPassword";
    public static final String REG_GET_ACTIVATION_CODE_API = "send";

    //For Simplified Reset Password API
    public static final String RESET_PASSWORD_API = "resetPassword";

    //For Login API
    public static final String TOKEN_API = "token";
    public static final String LOGIN_API = "login";
    public static final String LOGIN_SOCIAL_MEDIA_API = "socialmedia";
    public static final String LOGIN_MERGE_API = "merge";
    public static final String LOGIN_FACEBOOK_API = "facebook";
    public static final String LOGIN_GOOGLE_API = "google";
    public static final String LOGIN_PARAM_CLIENT_ID = "client_id";
    public static final String LOGIN_PARAM_CLIENT_SECRET = "client_secret";
    public static final String LOGIN_PARAM_GRANT_TYPE = "grant_type";
    public static final String LOGIN_PARAM_EMAIL = "email";
    public static final String LOGIN_PARAM_PASSWORD = "password";
    public static final String LOGIN_PARAM_USERNAME = "username";
    public static final String LOGIN_PARAM_REFRESH_TOKEN = "refresh_token";
    public static final String LOGIN_ACCOUNT_TYPE = "accountType";

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
    public static final String PRODUCT_UPLOAD_GET_CATEGORIES_PARAM_CATEGORY_ID = "productCategoryId";
    public static final String PRODUCT_UPLOAD_GET_CATEGORIES_PARAM_QUERY_STRING = "queryString";
    public static final String PRODUCT_UPLOAD_GET_CONDITIONS = "getProductConditions";

    //Get Product Edit Details
    public static final String PRODUCT_EDIT_DETAILS_API = "get-upload-details";
    public static final String PRODUCT_EDIT_DETAILS_PARAMS_PRODUCT_ID = "productId";

    //Edit Product
    public static final String PRODUCT_EDIT_API = "edit";
    public static final String PRODUCT_EDIT_PARAMS_PRODUCT_ID = "productId";
    public static final String PRODUCT_EDIT_PARAMS_PRODUCT_UNIT_ID = "productUnitId";
    public static final String PRODUCT_EDIT_PARAMS_IMAGE_DETAILS = "imageDetails";

    //Draft Product
    public static final String PRODUCT_DRAFT_API = "draft";

    //API Credentials
    public static final String API_GRANT_TYPE = "refresh_token";
    public static final String API_CONNECTION_PROBLEM = "Problem connecting to the server. Try again later.";
    public static final String API_CONNECTION_AUTH_ERROR = "OAuth Error";
    public static final String API_AUTHENTICATION_ERROR = "Authentication Failed";
    public static final String API_AUTHENTICATION_FAILURE_2 = "Authentication Failure.";
    public static final String API_GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    //Address
    public static final String STORE_ADDRESS = "storeAddress";
    public static final String STORE_ADDRESS_ADD = "addNewAddress";
    public static final String GET_STORE_ADDRESS = "getUserAddresses";
    public static final String EDIT_USER_ADDRESS = "editUserAddress";
    public static final String ADDRESS_PARAMS_ADDRESS_TITLE = "title";
    public static final String ADDRESS_PARAMS_TITLE = "title";
    public static final String ADDRESS_PARAMS_UNIT_NUMBER = "unitNumber";
    public static final String ADDRESS_PARAMS_BUILDING_NAME = "buildingName";
    public static final String ADDRESS_PARAMS_STREET_NUMBER = "streetNumber";
    public static final String ADDRESS_PARAMS_STREET_NAME = "streetName";
    public static final String ADDRESS_PARAMS_SUBDIVISION = "subdivision";
    public static final String ADDRESS_PARAMS_BARANGAY = "barangay";
    public static final String ADDRESS_PARAMS_LOCATIONID = "locationId";
    public static final String ADDRESS_PARAMS_LOCATION = "location";
    public static final String ADDRESS_PARAMS_LATITUDE = "latitude";
    public static final String ADDRESS_PARAMS_LONGITUDE = "longitude";
    public static final String ADDRESS_PARAMS_CITY = "city";
    public static final String ADDRESS_PARAMS_PROVINCE = "province";
    public static final String ADDRESS_PARAMS_ZIPCODE = "zipCode";
    public static final String ADDRESS_PARAMS_ISDEFAULT = "isDefault";
    public static final String ADDRESS_PARAMS_ADDITIONAL_INFO = "additionalInfo";

    //Mobile Verification
    public static final String SMS_API = "sms";
    public static final String GET_CODE = "getCode";
    public static final String VERIFY = "verify";
    public static final String VERIFY_PARAM_VERIFICATION_CODE = "code";
    public static final String CHANGE_CONTACT_NUMBER = "changeContactNumber";
    public static final String SMS_VERIFY = "verify";
    public static final String SMS_VERIFICATION_CODE = "code";
    public static final String SMS_PARAMS_OLD_CONTACT_NUMBER = "oldContactNumber";
    public static final String SMS_PARAMS_NEW_CONTACT_NUMBER = "newContactNumber";

    //Store User Info
    public static final String UPDATE_USER_API = "user";
    public static final String USER_UPDATE_API = "update";
    public static final String UPDATE_STORE_INFO_API = "updateUserInfo";
    public static final String PROFILE_PHOTO_PARAM = "profilePhoto";
    public static final String COVER_PHOTO_PARAM = "coverPhoto";
    public static final String STORE_NAME_PARAM = "storeName";
    public static final String STORE_DESCRIPTION_PARAM = "storeDescription";
    public static final String STORE_INFO_MERCHANT = "merchant";
    public static final String GET_STORE_INFO = "getUserInfo";
    public static final String CHANGE_PASSWORD_API = "changePassword";
    public static final String DISABLE_USER = "disable";
    public static final String ACCOUNT_API = "account";
    public static final String CATEGORY_IDS = "categoryIds";

    //Bank
    public static final String BANK_API = "bank";
    public static final String BANK_ACCOUNT_API = "account";
    public static final String GET_BANK_ACCOUNTS = "getBankAccounts";
    public static final String GET_BANK_LIST = "getEnabledBanks";
    public static final String SET_DEFAULT_BANK = "setDefaultBankAccount";
    public static final String DELETE_BANK_ACCOUNT = "deleteBankAccount";
    public static final String ADD_BANK_ACCOUNT = "addBankAccount";
    public static final String EDIT_BANK_ACCOUNT = "editBankAccount";
    public static final String BANK_PARAMS_ACCOUNT_TITLE = "accountTitle";
    public static final String BANK_PARAMS_ACCOUNT_NUMBER = "accountNumber";
    public static final String BANK_PARAMS_ACCOUNT_NAME = "accountName";
    public static final String BANK_PARAMS_BANK_ID = "bankId";
    public static final String LOCATION_API = "location";
    public static final String ADDRESS_GET_ALL_PROVINCES = "getAllProvinces";
    public static final String ADDRESS_GET_CHILD_CITIES = "getChildCities";
    public static final String ADDRESS_PARAMS_PROVINCE_ID = "provinceId";
    public static final String ADDRESS_PARAMS_CITY_ID = "cityId";
    public static final String ADDRESS_GET_CHILD_BARANGGAY = "getBarangaysByCity";
    public static final String SET_DEFAULT_ADDRESS = "setDefaultAddress";
    public static final String ADDRESS_PARAMS_USER_ADDRESS_ID = "userAddressId";

    //Customized Category
    public static final String CATEGORY_API = "category";
    public static final String ADD_CUSTOM_CATEGORY = "addCustomCategory";
    public static final String GET_CUSTOM_CATEGORIES = "getCustomCategories";
    public static final String GET_CATEGORY_DETAILS = "getCategoryDetails";
    public static final String UPDATE_CUSTOM_CATEGORY = "updateCustomCategory";
    public static final String CATEGORY_PARAMS_CATEGORY_ID = "categoryId";
    public static final String CATEGORY_PARAMS_CATEGORY_NAME = "categoryName";
    public static final String CATEGORY_PARAMS_PARENT_ID = "parentId";
    public static final String CATEGORY_PARAMS_PRODUCTS = "products";
    public static final String CATEGORY_PARAMS_SUBCATEGORIES = "subcategories";
    public static final String CATEGORY_PARAMS_CATEGORIES = "categories";

    //Product Management
    public static final String PRODUCT_MANAGEMENT_API = "product";
    public static final String GET_PRODUCT_LIST = "getProductList";
    public static final String UPDATE_PRODUCT_STATUS = "updateProductStatus";
    public static final String PRODUCT_MANAGEMENT_PARAMS_STATUS = "status";
    public static final String PRODUCT_MANAGEMENT_PARAMS_KEYWORD = "keyword";
    public static final String PRODUCT_MANAGEMENT_PARAMS_PRODUCT_ID = "productId";
    public static final String PRODUCT_MANAGEMENT_PARAMS_PAGE = "page";
    public static final String PRODUCT_MANAGEMENT_PARAMS_PER_PAGE = "perPage";


    //My Points
    public static final String GET_POINTS = "getPoints";
    public static final String GET_POINT_HISTORY = "getPointHistory";
    public static final String GET_POINTS_PARAMS_PAGE = "page";
    public static final String GET_POINTS_PARAMS_PER_PAGE = "perPage";



    /***Category*/
    public static final String GET_CATEGORY ="getCategories";
    public static final String PARENT_ID = "parentId";
    public static final String BANK_PARAMS_BANK_ACCOUNT_ID = "bankAccountId";

    /***Search*/
    public static final String GET_SEARCH_PRODUCT ="getSearchKeywords";
    public static final String STORE_API = "store";
    public static final String GET_SEARCH = "search";
    public static final String SEARCH_QUERY ="queryString";
    public static final String PRODUCT_NAME_API = "name-suggestion";
    public static final String PRODUCT_PARAMS_PRODUCT_NAME = "productName";
    public static final String RIDER_NAME_API = "suggestPackageHandler";
    public static final String SEARCH_PER_PAGE = "perPage";
    public static final String SEARCH_PAGE = "page";
    public static final String RIDER_NAME_PARAMS = "riderName";

    //Checkout Buyer
    public static final String CHECKOUT_PAYMENT_API = "payment";
    public static final String CHECKOUT_PAYMENT_COD = "doPaymentCod";
    public static final String CHECKOUT_PAYMENT_PESOPAY = "doPesoPay";
    public static final String CHECKOUT_PAYMENT_OVERVIEW = "checkoutOverview";
    public static final String CHECKOUT_PARAMS_TRANSACTION_ID = "transactionId";
    public static final String CHECKCOUT_ADDRESS_SET_ADDRESS = "setAddress";
    public static final String CHECKOUT_SELECT_ITEMS = "cartToCheckout";
    public static final String CHECKOUT_TRANSACTION_CLEAR = "transactionClear";

    //Checkout Guest
    public static final String GUEST_CONFIRMATION_CODE = "confirmationCode";
    public static final String GUEST_CHECKOUT_API = "guestUser";
    public static final String GUEST_PARAMS_FIRST_NAME = "firstName";
    public static final String GUEST_PARAMS_LAST_NAME = "lastName";
    public static final String GUEST_PARAMS_EMAIL = "email";
    public static final String GUEST_PARAMS_CONTACT_NUMBER = "contactNumber";
    public static final String GUEST_USER_PARAMS = "user_guest";
    public static final String GUEST_ADDRESS_PARAMS = "user_address";

    //Checkout Address
    public static final String ADDRESS_API = "address";
    public static final String ADDRESS_GET_ADDRESSES = "getAddresses";
    public static final String ADDRESS_PARAM_ADDRESS_ID = "address_id";
//    public static final String ADDRESS_ADD_ADDRESS = "addAddress";
//    public static final String ADDRESS_SET_ADDRESS = "setAddress";


    //////////////////////For Rider/////////////////////////////////////////////////////
    public static final String RIDER_GET_TOKEN = "token";
    public static final String RIDER_API = "riders";

    public static final String RIDER_GET_INFO = "get-rider-info";
    public static final String RIDER_GET_INFO_PARAM_TOKEN = "access_token";

    public static final String RIDER_ACCEPT_JOB_ORDER = "accept-job-order";
    public static final String RIDER_ACCEPT_JOB_ORDER_PARAM_TOKEN = "access_token";
    public static final String RIDER_ACCEPT_JOB_ORDER_PARAM_JONUMBER = "jobOrderNo";
    public static final String RIDER_ACCEPT_JOB_ORDER_PARAM_WAYBILLNO = "waybillNo";

    public static final String RIDER_GET_JOB_ORDERS = "get-job-orders";
    public static final String RIDER_GET_JOB_ORDERS_PARAM_TOKEN = "access_token";
    public static final String RIDER_GET_JOB_ORDERS_PARAM_STATUS = "status";
    public static final String RIDER_GET_JOB_ORDERS_PARAM_FILTERBYBRANCH = "filterByBranch";

    public static final String RIDER_GET_CASHDETAILS = "get-cash-details";
    public static final String RIDER_GET_CASHDETAILS_PARAM_TOKEN = "access_token";

    public static final String RIDER_UPDATE_STATUS = "update-job-order-status";
    public static final String RIDER_UPDATE_STATUS_PARAM_TOKEN = "access_token";
    public static final String RIDER_UPDATE_STATUS_PARAM_JONUMBER = "jobOrderNo";
    public static final String RIDER_UPDATE_STATUS_PARAM_STATUS = "status";

    public static final String RIDER_UPLOAD_SIGNATURE = "upload-signature";
    public static final String RIDER_UPLOAD_SIGNATURE_PARAM_TOKEN = "access_token";
    public static final String RIDER_UPLOAD_SIGNATURE__PARAM_JONUMBER = "jobOrderNo";
    public static final String RIDER_UPLOAD_SIGNATURE_PARAM_IMAGE = "image";

    public static final String RIDER_ADD_RATING = "submit-job-order-rating";
    public static final String RIDER_ADD_RATING_PARAM_ACCESS_TOKEN = "access_token";
    public static final String RIDER_ADD_RATING_PARAM_JONUMBER = "jobOrderNo";
    public static final String RIDER_ADD_RATING_PARAM_RATING = "rating";

    public static final String RIDER_GET_JODETAILS = "get-job-order-details";
    public static final String RIDER_GET_JODETAILS_PARAM_TOKEN = "access_token";
    public static final String RIDER_GET_JODETAILS_PARAM_JONUMBER = "jobOrderNo";
    public static final String RIDER_GET_JODETAILS_PARAM_WAYBILLNO = "waybillNo";

    public static final String RIDER_GET_WAREHOUSES = "get-warehouse";
    public static final String RIDER_GET_WAREHOUSES_PARAM_TOKEN = "access_token";

    public static final String RIDER_REPORT_PROBLEMATIC = "submit-problematic-job-order";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_TOKEN = "access_token";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_TYPE = "problemType";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_JONUMBER = "jobOrderNo";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_NOTES = "notes";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_IMAGE = "images[]";

    public static final String RIDER_LOGOUT = "confirm-rider-logout";
    public static final String RIDER_LOGOUT_PARAM_TOKEN = "access_token";
    public static final String RIDER_LOGOUT_PARAM_USERNAME = "username";
    public static final String RIDER_LOGOUT_PARAM_PASSWORD = "password";

    public static final String RIDER_UPLOAD_IMAGES = "upload-delivery-images";
    public static final String RIDER_UPLOAD_IMAGES_ACCESS_TOKEN = "access_token";
    public static final String RIDER_UPLOAD_IMAGES_WAYBILLNO = "waybillNo";
    public static final String RIDER_UPLOAD_IMAGES_IMAGES = "images[]";

    public static final String RIDER_EXTEND_CASH_LIMIT = "allow-exceed-cash-limit";
    public static final String RIDER_EXTEND_CASH_LIMIT_PARAM_TOKEN = "access_token";
    public static final String RIDER_EXTEND_CASH_LIMIT_PARAM_USERNAME = "username";
    public static final String RIDER_EXTEND_CASH_LIMIT_PARAM_PASSWORD = "password";

    public static final String RIDER_SEND_LOCATION = "add-location";
    public static final String RIDER_SEND_LOCATION_PARAM_TOKEN = "access_token";
    public static final String RIDER_SEND_LOCATION_PARAM_LATITUDE = "latitude";
    public static final String RIDER_SEND_LOCATION_PARAM_LONGITUDE = "longitude";

    public static final String RIDER_VERIFY = "is-rider";
    public static final String RIDER_VERIFY_PARAM_TOKEN = "access_token";

    public static final String RIDER_ACKNOWLEDGE = "accept-unverified-package";
    public static final String RIDER_ACKNOWLEDGE_TOKEN = "access_token";
    public static final String RIDER_ACKNOWLEDGE_WAYBILLNO = "waybillNo";

    public static final String RIDER_GET_PACKAGE_TYPES = "get-package-types";
    public static final String RIDER_CALCULATE_SHIPPING_FEE = "calculate-shipping-fee";
    public static final String RIDER_CALCULATE_PACKAGE_TYPE = "packageType";
    public static final String RIDER_IS_UPDATE_PACKAGE = "isUpdate";

    public static final String RIDER_GET_BANK_DETAILS = "get-bank-details";

    //TODO to move to express rider constant
    public static final String RIDER_REGISTRATION_MOBILE_NO = "mobileNumber";
    public static final String RIDER_REGISTRATION_PASSWORD = "password";
    public static final String RIDER_REGISTRATION_CODE = "otp";
    public static final String RIDER_PARTNERS_API = "partners";
    public static final String RIDER_GENERATE_OTP = "generate-otp";
    public static final String RIDER_VERIFY_OTP = "verify-otp";
    public static final String RIDER_REGISTER = "register";


    ////////////////////////////////////////////////////////////////////////////////

    public static final String ADDRESS_ADD_ADDRESS = "addNewAddress";
    public static final String ADDRESS_SET_ADDRESS = "setDefaultAddress";
    public static final String ADDRESS_DELETE_ADDRESS = "deleteUserAddress";
    public static final String ADDRESS_PARAM_ID = "userAddressId";


    // Messaging API
    public static final String MESSAGING_API                    = "message";
    // Method
    public static final String SEND_MESSAGE                     = "sendMessage";
    public static final String GET_CONVERSATION_HEAD            = "getConversationHead";
    public static final String GET_CONTACTS                     = "getContacts";
    public static final String GET_CONVERSATION_MESSAGES        = "getConversationMessages";
    public static final String SET_CONVERSATION_AS_READ         = "setConversationAsRead";
    public static final String IMAGE_ATTACH                     = "imageAttach";
    // Param
    public static final String MESSAGING_PARAM_MESSAGE          = "message";
    public static final String MESSAGING_PARAM_RECIPIENT_ID     = "recipientId";
    public static final String MESSAGING_PARAM_IS_IMAGE         = "isImage";
    public static final String MESSAGING_PARAM_ACCESS_TOKEN     = "access_token";
    public static final String MESSAGING_PARAM_PAGE             = "page";
    public static final String MESSAGING_PARAM_LIMIT            = "limit";
    public static final String MESSAGING_PARAM_KEYWORD          = "keyword";
    public static final String MESSAGING_PARAM_USER_ID          = "userId";
    public static final String MESSAGING_PARAM_IMAGE            = "image";

    // Device API
    public static final String DEVICE_API                       = "auth/device";
    //Method
    public static final String ADD_REGISTRATION_ID              = "addRegistrationId";
    public static final String DELETE_REGISTRATION_ID           = "deleteRegistrationId";
    public static final String UPDATE_REGISTRATION_ID           = "updateRegistrationId";

    // Param
    public static final String DEVICE_TYPE                      = "deviceType";
    public static final String DEVICE_PARAM_REGISTRATION_ID     = "registrationId";
    public static final String DEVICE_PARAM_ACCESS_TOKEN        = "access_token";
    public static final String DEVICE_PARAM_OLD_REGISTRATION_ID = "oldRegistrationId";
    public static final String DEVICE_PARAM_NEW_REGISTRATION_ID = "newRegistrationId";
    public static final String DEVICE_IS_IDLE                   = "isIdle";

    //Seller Transaction API
    public static final String SELLER_TRANSACTION_LIST_API      = "getTransactionList";
    public static final String SELLER_TRANSACTION_LIST_PARAMS_TYPE = "type";
    public static final String SELLER_TRANSACTION_LIST_PARAMS_PAGE = "page";
    public static final String SELLER_TRANSACTION_LIST_PARAMS_PER_PAGE = "perPage";
    public static final String SELLER_TRANSACTION_LIST_PARAMS_PAYMENT_METHOD = "paymentMethod";
    public static final String SELLER_TRANSACTION_LIST_PARAMS_DATE_FROM = "dateFrom";
    public static final String SELLER_TRANSACTION_LIST_PARAMS_DATE_TO = "dateTo";
    public static final String SELLER_TRANSACTION_LIST_PARAMS_ORDER_STATUS = "order_status_id";


    public static final String SELLER_TRANSACTION_API           = "getTransaction";
    public static final String SELLER_TRANSACTION_ORDER_PRODUCT_DETAILS_API = "getOrderProductDetail";
    public static final String SELLER_TRANSACTION_PARAMS_TRANSACTION_ID = "transactionId";

    public static final String SELLER_TRANSACTION_REASONS_API   = "reasons";

    public static final String SELLER_TRANSACTION_CANCEL_API    = "cancel";
    public static final String SELLER_TRANSACTION_CANCEL_PARAMS_TRANSACTION_ID = "transactionId";
    public static final String SELLER_TRANSACTION_CANCEL_PARAMS_REASON_ID = "reasonId";
    public static final String SELLER_TRANSACTION_CANCEL_PARAMS_REMARK = "remark";
    public static final String SELLER_TRANSACTION_CANCEL_PARAMS_ORDER_PRODUCT_ID = "orderProductId";

    public static final String SELLER_TRANSACTION_PICKUP_API    = "pickup";
    public static final String SELLER_TRANSACTION_PICKUP_PARAMS_TRANSACTION_ID = "transactionId";
    public static final String SELLER_TRANSACTION_PICKUP_PARAMS_PICKUP_SCHEDULE = "pickupSchedule";
    public static final String SELLER_TRANSACTION_PICKUP_PARAMS_PICKUP_REMARK = "pickupRemark";

    public static final String SELLER_TRANSACTION_GET_CONSIGNEE_API = "getTransactionConsignee";
    public static final String SELLER_TRANSACTION_GET_CONSIGNEE_PARAMS_TRANSACTION_ID = "transactionId";

    public static final String SELLER_TRANSACTION_DELIVERY_LOGS_API = "getTransactionDeliveryLogs";
    public static final String SELLER_TRANSACTION_DELIVERY_LOGS_PARAMS_ORDER_PRODUCT_ID = "orderProductId";
    public static final String SELLER_TRANSACTION_DELIVERY_LOGS_PARAMS_ORDER_PRODUCT_IDS = "orderProductIds";

    public static final String ORDER_PRODUCT_DETAIL_API = "getOrderProductDetail";
    public static final String ORDER_PRODUCT_DETAIL_PARAMS_ORDER_PRODUCT_ID = "orderProductId";

    //Sales Report API
    public static final String SALES_REPORT_API                 = "getSalesReport";
    public static final String SALES_REPORT_PARAM_DATE_TO       = "dateTo";
    public static final String SALES_REPORT_PARAM_DATE_FROM     = "dateFrom";

    //Resolution Center
    public final static String RESOLUTION_CENTER_DISPUTE = "dispute";
    public final static String RESOLUTION_CENTER_GET_CASES = "get-case";
    public final static String RESOLUTION_CENTER_FILTER = "filter";
    public final static String RESOLUTION_CENTER_ADD_CASE = "add-case";
    public final static String RESOLUTION_CENTER_PARAM_DISPUTE_TITLE = "disputeTitle";
    public final static String RESOLUTION_CENTER_PARAM_REMARKS = "remarks";
    public final static String RESOLUTION_CENTER_PARAM_ORDER_PRODUCT_STATUS = "orderProductStatus";
    public final static String RESOLUTION_CENTER_PARAM_ORDER_PRODUCT_ID = "orderProductIds";
    public final static String RESOLUTION_CENTER_GET_CASE_DETAILS = "get-case-detail";
    public final static String RESOLUTION_CENTER_DISPUTE_ID = "disputeId";
    public final static String RESOLUTION_CENTER_GET_SELLER_REASONS_API = "get-seller-reasons";
    public final static String RESOLUTION_CENTER_PARAM_REASON_ID = "reasonId";

    //Reseller
    public final static String GET_MANUFACTURER_PRODUCTS_API = "products";
    public final static String GET_MANUFACTURER_PRODUCTS_PARAMS_CATEGORY_ID = "categoryId";
    public final static String GET_MANUFACTURER_PRODUCTS_PARAMS_PAGE = "page";
    public final static String GET_MANUFACTURER_PRODUCTS_PARAMS_QUERY = "query";

    public final static String RESELLER_UPLOAD_API = "upload";
    public final static String RESELLER_UPLOAD_PARAMS_PRODUCT_IDS = "productIds[]";

    //Voucher Api
    public final static String APPLY_VOUCHER_API = "applyVoucher";

    public final static String APPLY_VOUCHER_PARAMS_VOUCHER_CODE = "voucherCode";


    //Settings
    public final static String SETTINGS_API = "subscription";
    public final static String SETTINGS_PARAMS_SUBSCRIBE = "isSubscribe";

    //Home V2
    public final static String API_HOME_V2_STORE                                                    = "store";
    public final static String API_HOME_V2_PRODUCT                                                  = "product";
    public final static String API_HOME_V2_TARGET                                                   = "target";
    public final static String API_HOME_V2_IMAGE                                                    = "image";
    public final static String API_HOME_V2_THUMBNAIL                                                = "thumbnail";
    public final static String API_HOME_V2_SMALL                                                    = "small";
    public final static String API_HOME_V2_MEDIUM                                                   = "medium";
    public final static String API_HOME_V2_LARGE                                                    = "large";
    public final static String API_HOME_V2_CATEGORY                                                 = "category";

    public final static String API_HOME_V2_LAYOUT_ID                                                = "layoutId";
    public final static String API_HOME_V2_SECTION_TITLE                                            = "sectionTitle";
    public final static String API_HOME_V2_VIEW_MORE_AVAILABLE                                      = "isViewMoreAvailable";
    public final static String API_HOME_V2_VIEW_MORE_TARGET                                         = "viewMoreTarget";
    public final static String API_HOME_V2_DATA                                                     = "data";
    public final static String API_HOME_V2_REMAINING_TIME                                           = "remainingTime";

    public final static String API_HOME_V2_NAME                                                     = "name";

    public final static String API_HOME_V2_TARGET_URL                                               = "targetUrl";
    public final static String API_HOME_V2_TARGET_TYPE                                              = "targetType";
    public final static String API_HOME_V2_TARGET_IS_AUTHENTICATED                                  = "isAuthenticated";

    public final static String API_HOME_V2_PRODUCT_NAME                                             = "name";
    public final static String API_HOME_V2_PRODUCT_ORIGINAL_PRICE                                   = "originalPrice";
    public final static String API_HOME_V2_PRODUCT_DISCOUNTED_PRICE                                 = "discountedPrice";
    public final static String API_HOME_V2_PRODUCT_DISCOUNTED_PERCENTAGE                            = "discountPercentage";
    public final static String API_HOME_V2_PRODUCT_CURRENCY                                         = "currency";
    public final static String API_HOME_V2_PRODUCT_IMAGE                                            = "image";

    public final static String API_HOME_V2_STORE_NAME                                               = "name";
    public final static String API_HOME_V2_STORE_SPECIALTY                                          = "specialty";
    public final static String API_HOME_V2_STORE_IMAGE                                              = "image";
    public final static String API_HOME_V2_STORE_TOP_PRODUCT                                        = "data";

    public final static String API_HOME_V2_SALE_REMAINING_TIME                                      = "remainingTime";

    public final static String API_HOME_V2_PRODUCT_ID                                               = "productId";
    public final static String API_HOME_V2_PRODUCT_UNIT_ID                                          = "productUnitId";

    //For Store Setup API
    public static final String STORE_SETUP_STORE                                                    = "store";
    public static final String STORE_SETUP_SETUP                                                    = "setup";
    public static final String STORE_SETUP_SLUG                                                     = "storeSlug";
    public static final String STORE_SETUP_NAME                                                     = "storeName";
    public static final String STORE_SETUP_DESCRIPTION                                              = "storeDescription";

    //For Upload Image API
    public static final String UPLOAD                                                               = "upload";
    public static final String IMAGE                                                                = "image";

    //For Edit Profile API
    public final static String VERIFY_EMAIL_API                                                     = "verify-email";
    public final static String UPDATE_USER_PROFILE_API                                              = "update-user-info";
    public final static String EDIT_PROFILE_PARAM_TIN                                               = "tin";
    public final static String EDIT_PROFILE_PARAM_IS_SENT                                           = "isSent";
    public final static String EDIT_PROFILE_PARAM_VALID_ID                                          = "validId";

    //Select Product API
    public final static String GET_AFFILLIATE_PRODUCTS                                              = "getAffiliateProducts";
    public final static String PARAMS_CATEGORY_IDS                                                  = "categoryIds";
    public final static String PARAMS_SORT_BY                                                       = "sortBy";
    public final static String PARAMS_STATUS                                                        = "status";
    public final static String PARAMS_PAGE                                                          = "page";
    public final static String PARAMS_LIMIT                                                         = "limit";
    public final static String PARAMS_NAME                                                          = "name";

    public final static String GET_CATEGORIES                                                       = "getCategories";

    public final static String SAVE_AFFILIATE_PRODUCTS                                              = "saveAffiliateProducts";
    public final static String PARAMS_MANUFACTURER_PRODUCT_IDS                                      = "manufacturerProductIds";
    public final static String PARAMS_REMOVE_MANUFACTURER_PRODUCT_IDS                               = "removeManufacturerProductIds";

    //Send Feedback API
    public final static String MOBILE_FEEDBACK                                                      = "mobile-feedback";
    public final static String SEND_FEEDBACK_API                                                    = "add";
    public final static String SEND_FEEDBACK_PARAMS_TITLE                                           = "title";
    public final static String SEND_FEEDBACK_PARAMS_DESCRIPTION                                     = "description";
    public final static String SEND_FEEDBACK_PARAMS_PHONE_MODEL                                     = "phoneModel";
    public final static String SEND_FEEDBACK_PARAMS_OS_VERSION                                      = "osVersion";
    public final static String SEND_FEEDBACK_PARAMS_OS_NAME                                         = "osName";


    //GET COUNTRY
    public final static String ADDRESS_GET_COUNTRY = "getAllCountries";
    public final static String ADDRESS_GET_COUNTRY_PARAM_TOKEN = "access_token";

    //COUNTRY STORE
    public final static String SELLER_COUNTRY_STORE_PARAMS_CODE                                     ="code";
    public final static String SELLER_COUNTRY_STORE_SETUP_API                                       ="country-setup";
    public final static String SELLER_COUNTRY_STORE_SET_WAREHOUSE                                   ="setwarehouse";
    public final static String SELLER_COUNTRY_STORE_PARAMS_PRODUCT_ID                               ="productId";
    public final static String SELLER_COUNTRY_STORE_PARAMS_USER_WAREHOUSE                           ="userWarehouse";
    public final static String SELLER_COUNTRY_STORE_PARAMS_LOGISTICS                                ="logistics";
    public final static String SELLER_COUNTRY_STORE_PARAMS_IS_COD                                   ="isCod";
    public final static String SELLER_COUNTRY_STORE_PARAMS_HANDLING_FEE                             ="handlingFee";
    public final static String SELLER_COUNTRY_STORE_PARAMS_PRIORITY                                 ="priority";
    public final static String SELLER_COUNTRY_STORE_PARAMS_PRODUCT_UNIT_ID                          ="productUnitId";
    public final static String SELLER_COUNTRY_STORE_PARAMS_PRICE                                    ="price";
    public final static String SELLER_COUNTRY_STORE_PARAMS_DISCOUNTED_PRICE                         ="discountedPrice";
    public final static String SELLER_COUNTRY_STORE_PARAMS_COMMISSION                               ="commission";
    public final static String SELLER_COUNTRY_STORE_PARAMS_STATUS                                   ="status";
    public final static String SELLER_COUNTRY_STORE_API                                             ="country-store";
    public final static String SELLER_COUNTRY_STORE_SAVE_COMBINATIONS_API                            ="save-combinations";

    //GET CHILD PROVINCES
    public final static String ADDRESS_GET_CHILD_PROVINCES = "getChildProvinces";
    public final static String ADDRESS_GET_CHILD_PROVINCES_PARAM_TOKEN = "access_token";
    public final static String ADDRESS_GET_CHILD_PROVINCES_PARAM_REGIONID = "regionId";

    //GET INTERNATIONAL PRODUCTS
    public final static String GET_INTERNATIONAL_PRODUCT = "internationalProduct";

    //MOBILE CATEGORIES
    public static final String CATEGORIES_API = "mobile-category";

}