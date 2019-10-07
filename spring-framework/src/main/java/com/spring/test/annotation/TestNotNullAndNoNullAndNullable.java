package com.spring.test.annotation;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * TODO
 *
 * @date:2019/10/1 23:55
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestNotNullAndNoNullAndNullable {


    public static void main(String[] args) {

        test02(null);

    }


    public static void test(@Nullable List list) {
        System.out.println(list);
    }

    public static void test02(@NonNull String s) {
        System.out.println(s);
    }

}
