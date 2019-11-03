package com.javase.Keyword.collection.map_study.map;

/**
 * ClassName:demos
 * Package:com.javase.Keyword.collection.map_study.map
 * Description:
 *
 * @date:2019/7/7 1:05
 * @author: 574986060@qq.com
 */

public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            map.put("anxing" + i, "anxing" + i);
            System.out.println(map.get("anxing" + i));
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

}
