package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlcoronado on 03/02/2016.
 */
public class EarningsGroup {

    private static final String EARNING_GROUPS = "earningGroups";

    @SerializedName(EARNING_GROUPS)
    private List<EarningGroupItem> earningGroups = new ArrayList<>();

    public List<EarningGroupItem> getEarningGroups() {
        return earningGroups;
    }

    public void setEarningGroups(List<EarningGroupItem> earningGroups) {
        this.earningGroups = earningGroups;
    }

    public class EarningGroupItem {

        private static final String EARNINGS_NAME = "name";
        private static final String EARNINGS_TYPE_ID = "earningGroupId";
        private static final String EARNINGS_TOTAL_AMOUNT = "totalAmount";
        private static final String EARNINGS_CURRENCY_CODE = "currencyCode";
        private static final String EARNINGS_IMAGE_LOCATION = "imageLocation";

        @SerializedName(EARNINGS_TYPE_ID)
        private String earningGroupId;
        @SerializedName(EARNINGS_NAME)
        private String name;
        @SerializedName(EARNINGS_IMAGE_LOCATION)
        private String imageLocation;
        @SerializedName(EARNINGS_TOTAL_AMOUNT)
        private String totalAmount;
        @SerializedName(EARNINGS_CURRENCY_CODE)
        private String currencyCode;


        public String getEarningGroupId() {
            return earningGroupId;
        }

        public void setEarningGroupId(String earningGroupId) {
            this.earningGroupId = earningGroupId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageLocation() {
            return imageLocation;
        }

        public void setImageLocation(String imageLocation) {
            this.imageLocation = imageLocation;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

    }

    public static class EarningsGroupInstance implements InstanceCreator<EarningsGroup> {

        @Override
        public EarningsGroup createInstance(Type type) {
            return new EarningsGroup();
        }
    }
}
