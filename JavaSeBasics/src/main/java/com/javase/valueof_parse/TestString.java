package com.javase.valueof_parse;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * TODO
 *
 * @date:2019/10/23 15:37
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestString {

    public static void main(String[] args) {
        String x = "1";

/*        int i = Integer.parseInt(x,0);

        System.out.println(i);*/

        Double.parseDouble(x);
        System.out.println(x);

        Double aDouble = Double.valueOf(x);

        System.out.println(aDouble);

        Integer integer = Integer.valueOf(x);

        System.out.println(integer);
    }

    @Test
    public void test(){


        String s = "01";
        Integer integer = Integer.valueOf(s);
        System.out.println(integer);
    }

}
