package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 1/29/2016.
 */
public class BalanceRecord {

    private final static String TOTAL_EARNING = "totalEarning";
    private final static String ACTIVE_EARNING = "activeEarning";
    private final static String TENTATIVE_EARNING = "tentativeEarning";
    private final static String TOTAL_WITHDREW = "totalWidthrew";
    private final static String TOTAL_WITHDREW_IN_PROCESS = "totalWithdrewInProcess";
    private final static String AVAILABLE_BALANCE = "availableBalance";
    private final static String CURRENCY_CODE = "currencyCode";
    private final static String EARNINGS = "earnings";

    @SerializedName(TOTAL_EARNING)
    private String totalEarning;
    @SerializedName(ACTIVE_EARNING)
    private String activeEarning;
    @SerializedName(TENTATIVE_EARNING)
    private String tentativeEarning;
    @SerializedName(TOTAL_WITHDREW)
    private String totalWithdrew;
    @SerializedName(TOTAL_WITHDREW_IN_PROCESS)
    private String totalWithdrewInProcess;
    @SerializedName(AVAILABLE_BALANCE)
    private String availableBalance;
    @SerializedName(CURRENCY_CODE)
    private String currency;
    @SerializedName(EARNINGS)
    private List<Earnings> earnings = new ArrayList<>();

    public String getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(String totalEarning) {
        this.totalEarning = totalEarning;
    }

    public String getActiveEarning() {
        return activeEarning;
    }

    public void setActiveEarning(String activeEarning) {
        this.activeEarning = activeEarning;
    }

    public String getTentativeEarning() {
        return tentativeEarning;
    }

    public void setTentativeEarning(String tentativeEarning) {
        this.tentativeEarning = tentativeEarning;
    }

    public String getTotalWithdrew() {
        return totalWithdrew;
    }

    public void setTotalWithdrew(String totalWithdrew) {
        this.totalWithdrew = totalWithdrew;
    }

    public String getTotalWithdrewInProcess() {
        return totalWithdrewInProcess;
    }

    public void setTotalWithdrewInProcess(String totalWithdrewInProcess) {
        this.totalWithdrewInProcess = totalWithdrewInProcess;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Earnings> getEarnings() {
        return earnings;
    }

    public void setEarnings(List<Earnings> earnings) {
        this.earnings = earnings;
    }

    public static class BalanceRecordInstance implements InstanceCreator<BalanceRecord> {

        @Override
        public BalanceRecord createInstance(Type type) {
            return new BalanceRecord();
        }

    }


    public class Earnings {

        private final static String EARNINGS_DATE = "date";
        private final static String EARNINGS_AMOUNT = "amount";

        @SerializedName(EARNINGS_DATE)
        private String date;
        @SerializedName(EARNINGS_AMOUNT)
        private String amount;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}
