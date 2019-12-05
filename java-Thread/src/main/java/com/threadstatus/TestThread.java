package com.threadstatus;

import org.springframework.cglib.core.Local;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * TODO
 *
 * @date:2019/11/16 0:38
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestThread {


    public static void main(String[] args) {

        Map<String, String> map = System.getenv();


        Set<String> strings = map.keySet();


        strings.forEach(e->{
            System.out.println(e+" : "+map.get(e));
        });

        System.out.println("====================");

        Properties props = System.getProperties();
        props.list(System.out);

        System.out.println("=================================");

        for (String isoCountry : Locale.getISOCountries()) {
            System.out.println(isoCountry);
        }
    }


}
