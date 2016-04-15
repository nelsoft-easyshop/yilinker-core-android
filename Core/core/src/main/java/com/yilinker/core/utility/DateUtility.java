package com.yilinker.core.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by J.Bautista
 */
public class DateUtility {

    /**
     * Converts string to Date object
     * @param strDate
     * @return
     */
    public static Date convertStringToDate(String strDate, String format){

        DateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);

        Date date = null;
        try {
            date = formatter.parse(strDate);

        } catch (ParseException e) {

            return null;
        }

        return date;
    }

    /**
     * Converts Date to string
     * @param date
     * @return
     */
    public static String convertDateToString(Date date, String format){

        String strDate = "";

        if(date != null) {

            DateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
            strDate = formatter.format(date);
        }

        return strDate;
    }

    public static Date transactionDateParser(String dateString){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date reportDateParser(String dateString){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static String formatTransactionDate(Date date){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        return simpleDateFormat.format(date);

    }


    public static String dateToTransactionDateStringFormat(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return simpleDateFormat.format(date);

    }

    public static String formatDateToReportDateStringFormat(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(date);

    }


}
