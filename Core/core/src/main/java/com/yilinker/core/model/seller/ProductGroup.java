package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 5/12/16.
 */
public class ProductGroup {

    public static class ProductGroupInstance implements InstanceCreator<ProductGroup> {
        @Override
        public ProductGroup createInstance(Type type) {
            return new ProductGroup();
        }
    }

}
