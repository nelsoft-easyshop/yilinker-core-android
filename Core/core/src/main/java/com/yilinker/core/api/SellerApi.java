package com.yilinker.core.api;

import com.google.gson.Gson;
import com.yilinker.core.model.Seller;
import com.yilinker.core.utility.GsonUtility;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class SellerApi {

    public static Seller getSellerDetails(int requestCode, String id){
        Gson gson = GsonUtility.createGsonBuilder(Seller.class, new Seller.SellerInstance()).create();
        return gson.fromJson("{'id':1000001,'name':'Claudia Buenavista','specialty':'Pole Dancing','logoUrl':'https://www.logo.com','images':['1000000001','1000000002','1000000003'],'description':'Don\u2019t make me close one more door! I dont wanna hurt anymore. Stay in my arms if you dare, just I imagined you there.','contactNo':9101122334}", Seller.class);
    }

}