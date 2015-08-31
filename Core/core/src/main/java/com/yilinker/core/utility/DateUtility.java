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

            e.printStackTrace();
        }

        return date;
    }

    /**
     * Converts Date to string
     * @param date
     * @return
     */
    public static String convertDateToString(Date date, String format){

        DateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);

        String strDate = formatter.format(date);

        return strDate;
    }
}
