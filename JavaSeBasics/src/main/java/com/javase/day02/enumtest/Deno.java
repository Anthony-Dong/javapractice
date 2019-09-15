package com.javase.day02.enumtest;

import com.javase.day02.enumtest.EnumerationTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Deno
 * Package:com.javase.day02
 * Description:
 *
 * @date:2019/6/29 11:37
 * @author: 574986060@qq.com
 */

public class Deno {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");
        list.add("EE");
        list.add("FF");
        System.out.println(list.get(1));

        EnumerationTest enumerationTest = new EnumerationTest(list, list.size(), 0);
        while (enumerationTest.hasMoreElements()) {
            System.out.println(enumerationTest.nextElement());
        }



    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");
        list.add("EE");
        list.add("FF");

    }
}
