package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlcoronado on 09/02/2016.
 */
public class EarningsGroupItem {

    private static final String EARNINGS_LIST = "earnings";

    @SerializedName(EARNINGS_LIST)
    private List<EarningsItem> earningsList = new ArrayList<>();

    public List<EarningsItem> getEarningsList() {
        return earningsList;
    }

    public void setEarningsList(List<EarningsItem> earningsList) {
        this.earningsList = earningsList;
    }

    public class EarningsItem {

        private static final String EARNINGS_DATE = "date";
        private static final String EARNINGS_DESCRIPTION = "description";
        private static final String EARNINGS_TYPE_NAME = "earningTypeName";
        private static final String EARNINGS_TYPE_ID = "earningTypeId";
        private static final String EARNINGS_AMOUNT = "amount";
        private static final String EARNINGS_CURRENCY_CODE = "currencyCode";
        private static final String EARNINGS_STATUS_ID = "statusId";
        private static final String EARNINGS_STATUS = "status";


        @SerializedName(EARNINGS_DATE)
        private String date;
        @SerializedName(EARNINGS_DESCRIPTION)
        private String description;
        @SerializedName(EARNINGS_TYPE_NAME)
        private String earningTypeName;
        @SerializedName(EARNINGS_TYPE_ID)
        private String earningTypeId;
        @SerializedName(EARNINGS_AMOUNT)
        private String amount;
        @SerializedName(EARNINGS_CURRENCY_CODE)
        private String currencyCode;
        @SerializedName(EARNINGS_STATUS_ID)
        private String statusId;
        @SerializedName(EARNINGS_STATUS)
        private String status;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getEarningTypeName() {
            return earningTypeName;
        }

        public void setEarningTypeName(String earningTypeName) {
            this.earningTypeName = earningTypeName;
        }

        public String getEarningTypeId() {
            return earningTypeId;
        }

        public void setEarningTypeId(String earningTypeId) {
            this.earningTypeId = earningTypeId;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public String getStatusId() {
            return statusId;
        }

        public void setStatusId(String statusId) {
            this.statusId = statusId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class EarningsGroupItemInstance implements InstanceCreator<EarningsGroupItem> {

        @Override
        public EarningsGroupItem createInstance(Type type) {
            return new EarningsGroupItem();
        }
    }


}
