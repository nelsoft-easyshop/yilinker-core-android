package com.yilinker.core.api;

import com.google.gson.Gson;
import com.yilinker.core.model.SellerReview;
import com.yilinker.core.utility.GsonUtility;

/**
 * Created by Adur Urbano on 8/4/2015.
 */
public class SellerReviewApi {

    public static SellerReview getReviewBySellerId(int requestCode, String id){
        Gson gson = GsonUtility.createGsonBuilder(SellerReview.class, new SellerReview.SellerReviewInstance()).create();
        return gson.fromJson("{'rating':5,'reviews':[{'name':'Sir Edyuward','imageUrl':'https://www.edyuward.com','rating':5,'message':'How do I get you alone.'},{'name':'Mayordoma','imageUrl':'https://www.anglakingbaso.com','rating':0,'message':'Ehh kasi po Sir nagready na po ako ng 10 pork chop doon. Ehh hindi po naibigay ni Jona.'},{'name':'Alvin Garcia','imageUrl':'https://www.hindikomakitabaso.com','rating':5,'message':'Ate, san po yung baso?'}]}", SellerReview.class);
    }

}