package com.ticketing.util;

import java.util.Date;

public class DateComparison {


    public static Date findBeforeDate(Date isBeforeDate, Date date) {
        if (isBeforeDate == null || date == null) {
            return null;
        }
        return isBeforeDate.before(date) ? isBeforeDate : date;
    }


    public static Date findAfterDate(Date isAfterDate, Date date) {
        if (isAfterDate == null || date == null) {
            return null;
        }
        return isAfterDate.after(date) ? isAfterDate : date;
    }

    public static Boolean dateIsBeforeNow(Date date) {
        if (date == null) {
            return null;
        }
        return date.before(new Date());
    }

    public static Boolean dateIsAfterNow(Date date) {
        if (date == null) {
            return null;
        }
        return date.after(new Date());
    }


}
