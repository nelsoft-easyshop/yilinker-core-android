package com.yilinker.core.api;

import com.google.gson.Gson;
import com.yilinker.core.model.Product;
import com.yilinker.core.utility.GsonUtility;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class ProductApi {

    public static Product getProductDetails(int requestCode, String id){
        Gson gson = GsonUtility.createGsonBuilder(Product.class, new Product.ProductInstance()).create();
        return gson.fromJson("{'id':1000,'title':'adur','shortDescription':'asdh asjdha lkjas','fullDescription':'uiiw kdpo aksjwi jhdu','sellerId':111004179,'attributes':[{'id':100,'name':'groupName','items':[{'id':200,'name':'Samsung'},{'id':300,'name':'Apple'},{'id':400,'name':'Blackberry'}]}],'availableAttributeCombi':[{'combination':[{'id':112233,'id2':332211},{'id':445566,'id2':665544}],'quantity':100,'images':[]}],'originalPrice':0,'newPrice':0,'discount':0.5}", Product.class);
    }

}