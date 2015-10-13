package com.yilinker.core.constants;

import com.yilinker.core.base.BaseApplication;

import org.apache.http.entity.StringEntity;

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
    public static final String AUTH_API = "auth";
    public static final String MERCHANT_API = "merchant";
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

    //For Profile API
    public static final String PROFILE_API = "user";
    public static final String PROFILE_GET_DETAILS = "getUser";
    public static final String PROFILE_EDIT_DETAILS = "editProfile";
    public static final String PROFILE_PHOTO = "profilePhoto";
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

    //For Activity Log
    public static final String ACTIVITY_LOG_GET_ITEMS = "activityLog";

    //For Home API
    public static final String HOME_API = "home";
    public static final String HOME_GET_ITEMS = "getData";

    //For User API
    public static final String USER_API = "user";


    //For Registration API
    public static final String REG_API = "register";
    public static final String REG_PARAM_FULLNAME = "fullname";
    public static final String REG_PARAM_FIRST_NAME = "firstName";
    public static final String REG_PARAM_LAST_NAME = "lastName";
    public static final String REG_PARAM_MOBILE = "contactNumber";
    public static final String REG_PARAM_EMAIL = "email";
    public static final String REG_PARAM_PASSWORD = "password";
    public static final String REG_PARAM_REFERRAL = "referralCode";

    //For Login API
    public static final String TOKEN_API = "token";
    public static final String LOGIN_API = "login";
    public static final String LOGIN_FACEBOOK_API = "facebook";
    public static final String LOGIN_GOOGLE_API = "google";
    public static final String LOGIN_PARAM_CLIENT_ID = "client_id";
    public static final String LOGIN_PARAM_CLIENT_SECRET = "client_secret";
    public static final String LOGIN_PARAM_GRANT_TYPE = "grant_type";
    public static final String LOGIN_PARAM_EMAIL = "email";
    public static final String LOGIN_PARAM_PASSWORD = "password";
    public static final String LOGIN_PARAM_USERNAME = "username";
    public static final String LOGIN_PARAM_REFRESH_TOKEN = "refresh_token";

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
    public static final String PRODUCT_UPLOAD_GET_CATEGORIES_PARAM_QUERY_STRING = "queryString";
    public static final String PRODUCT_UPLOAD_GET_CONDITIONS = "getProductConditions";

    //Get Product Edit Details
    public static final String PRODUCT_EDIT_DETAILS_API = "upload-details";
    public static final String PRODUCT_EDIT_DETAILS_PARAMS_PRODUCT_ID = "productId";

    //Edit Product
    public static final String PRODUCT_EDIT_API = "edit";
    public static final String PRODUCT_EDIT_PARAMS_PRODUCT_ID = "productId";
    public static final String PRODUCT_EDIT_PARAMS_PRODUCT_UNIT_ID = "productUnitId";
    public static final String PRODUCT_EDIT_PARAMS_IMAGE_DETAILS = "imageDetails";

    //Draft Product
    public static final String PRODUCT_DRAFT_API = "draft";

    //API Credentials
    public static final String API_CLIENT_ID = "1_167rxzqvid8g8swggwokcoswococscocc8ck44wo0g88owgkcc";
    public static final String API_CLIENT_SECRET = "317eq8nohry84ooc0o8woo8000c0k844c4cggws84g80scwwog";
    public static final String API_GRANT_TYPE = "refresh_token";
    public static final String API_CONNECTION_PROBLEM = "Problem connecting to the server. Try again later.";
    public static final String API_CONNECTION_AUTH_ERROR = "OAuth Error";
    public static final String API_AUTHENTICATION_ERROR = "Authentication Failed";
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

    public static final String RIDER_GET_JOB_ORDERS = "get-job-orders";
    public static final String RIDER_GET_JOB_ORDERS_PARAM_TOKEN = "access_token";
    public static final String RIDER_GET_JOB_ORDERS_PARAM_STATUS = "status";

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

    public static final String RIDER_GET_WAREHOUSES = "get-warehouse";
    public static final String RIDER_GET_WAREHOUSES_PARAM_TOKEN = "access_token";

    public static final String RIDER_REPORT_PROBLEMATIC = "submit-problematic-job-order";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_TOKEN = "access_token";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_TYPE = "problemType";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_JONUMBER = "jobOrderNo";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_NOTES = "notes";
    public static final String RIDER_REPORT_PROBLEMATIC_PARAM_IMAGE = "images";

    public static final String RIDER_LOGOUT = "confirm-rider-logout";
    public static final String RIDER_LOGOUT_PARAM_TOKEN = "access_token";
    public static final String RIDER_LOGOUT_PARAM_USERNAME = "username";
    public static final String RIDER_LOGOUT_PARAM_PASSWORD = "password";

    public static final String RIDER_UPLOAD_IMAGES = "upload-delivery-images";
    public static final String RIDER_UPLOAD_IMAGES_ACCESS_TOKEN = "access_token";
    public static final String RIDER_UPLOAD_IMAGES_WAYBILLNO = "waybillNo";
    public static final String RIDER_UPLOAD_IMAGES_IMAGES = "images";

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


    //Settings
    public final static String SETTINGS_API = "subscription";
    public final static String SETTINGS_PARAMS_SUBSCRIBE = "isSubscribe";
}