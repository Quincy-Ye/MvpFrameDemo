package com.example.mvp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Quincy
 * @Date 2020/2/17
 * @Description
 */

public class DateUtil {
    private static final Locale LOCALE = Locale.CHINA;
    public static String format(Date date, String s) {
        return new SimpleDateFormat(s, LOCALE).format(date);
    }
}

