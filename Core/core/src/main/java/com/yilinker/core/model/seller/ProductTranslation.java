package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 5/18/16.
 */
public class ProductTranslation {

    @SerializedName("default")
    private TranslationProductDetails defaultLanguage;
    @SerializedName("target")
    private TranslationProductDetails targetLanguage;

    public TranslationProductDetails getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(TranslationProductDetails defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public TranslationProductDetails getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(TranslationProductDetails targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public static class ProductTranslationInstance implements InstanceCreator<ProductTranslation> {

        @Override
        public ProductTranslation createInstance(Type type) {
            return new ProductTranslation();
        }

    }

}
