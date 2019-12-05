package com.date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author kingston
 */
public class DateUtil {

    private static ThreadLocal<SimpleDateFormat> sdf = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static String format(Date date) {
        String msg = null;
        try {
            msg = sdf.get().format(date);
        } finally {
            sdf.remove();
        }
        return msg;
    }

    public static String formatJava8(Date date){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static void main(String[] args) throws Exception {

        System.err.println("a : "+format(new Date()).hashCode());

        System.err.println("a : "+format(new Date()).hashCode());
    }

}