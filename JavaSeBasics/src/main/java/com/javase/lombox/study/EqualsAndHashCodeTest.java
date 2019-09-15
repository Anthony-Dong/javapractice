package com.javase.lombox.study;

public class EqualsAndHashCodeTest {
    public static void main(String[] args) {
        XiaomiTv tv1 = new XiaomiTv("12",100L);
        XiaomiTv tv2 = new XiaomiTv("12",100L);
        System.out.println(tv1.equals(tv2.equals(tv1)));

    }
}