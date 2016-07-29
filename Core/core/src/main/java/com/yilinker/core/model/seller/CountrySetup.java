package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by patVillanueva on 5/17/2016.
 */
public class CountrySetup {

    private CountryProduct product;
    private CountryProductUnit defaultUnit;
    private List<CountryWarehouse> productWarehouses;
    private List<CountryLogistic> logistics;

    public CountryProduct getProduct() {
        return product;
    }

    public void setProduct(CountryProduct product) {
        this.product = product;
    }

    public CountryProductUnit getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(CountryProductUnit defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public List<CountryWarehouse> getProductWarehouses() {
        return productWarehouses;
    }

    public void setProductWarehouses(List<CountryWarehouse> productWarehouses) {
        this.productWarehouses = productWarehouses;
    }

    public List<CountryLogistic> getLogistics() {
        return logistics;
    }

    public void setLogistics(List<CountryLogistic> logistics) {
        this.logistics = logistics;
    }

    public  static class CountrySetupInstance implements InstanceCreator<CountrySetup>{

        @Override
        public CountrySetup createInstance(Type type) {
            return new CountrySetup();
        }
    }
}
