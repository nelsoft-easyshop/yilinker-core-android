package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rlcoronado on 8/20/15.
 */
public class AddressList {

    private List<Address> addresses;


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public static class AddressListInstance implements InstanceCreator<AddressList>{

        @Override
        public AddressList createInstance(Type type) {
            return new AddressList();
        }
    }
}
