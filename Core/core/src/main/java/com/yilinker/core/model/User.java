package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 8/8/15.
 */
public class User {
    public final String OBJ_NAME = "User";
    //    {"name":"","emailAddress":"","imageUrl":"\/assets\/images\/foo\/bar\/baz.png",
//            "address":{"addressId":1,"city":"Makati","region":"Visayas","streetAddress":"2339 Gil Puyat"}}

    public final String KEY_NAME = "name";
    public final String KEY_EMAIL_ADDRESS = "emailAddress";
    public final String KEY_IMAGE_URL = "imageUrl";
    public final String KEY_ADDRESS = "address";

//    @Override
//    public String toString() {
//        return OBJ_NAME + "[" + KEY_FEATURED + featured + ", " + KEY_HOT_ITEMS + hotItems + ", " + KEY_NEW_ITEMS + newItems + ", " + KEY_SELLERS + sellers + "]";
//    }

    public static class UserInstance implements InstanceCreator<User> {

        @Override
        public User createInstance(Type type) {

            return new User();
        }
    }
}
