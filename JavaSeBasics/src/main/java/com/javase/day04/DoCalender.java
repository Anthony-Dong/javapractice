package com.javase.day04;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

/**
 * ClassName:DoCalender
 * Package:com.javase.day04
 * Description:
 *
 * @date:2019/7/2 8:55
 * @author: 574986060@qq.com
 */

public class DoCalender {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));


        System.currentTimeMillis();
        calendar.getTimeInMillis();
        Clock.systemDefaultZone().millis();


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String date = format.format(calendar.getTime());
        System.out.println(date);
        /**
         *java8 特有的
         */

        LocalDateTime localDateTime = LocalDateTime.now();



        System.out.println(localDateTime.getYear());

        LocalDateTime with = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(with);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        System.out.println(with.format(formatter));

        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
    }
}
