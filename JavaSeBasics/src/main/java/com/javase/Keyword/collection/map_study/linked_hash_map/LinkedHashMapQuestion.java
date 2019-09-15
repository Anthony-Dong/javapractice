package com.javase.Keyword.collection.map_study.linked_hash_map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 理解和学习LinkedHashMap的魅力
 *
 * @date:2019/9/13 13:06
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class LinkedHashMapQuestion {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> lmap = new LinkedHashMap<>();
        lmap.put("语文", 1);
        lmap.put("数学", 2);
        lmap.put("英语", 3);
        lmap.put("历史", 4);
        lmap.put("政治", 5);
        lmap.put("地理", 6);
        lmap.put("生物", 7);
        lmap.put("化学", 8);
        for(Map.Entry<String, Integer> entry : lmap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        LinkedHashMap<Object, Object> map = new LinkedHashMap<>(10, 1, true);


        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        for(Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        map.get(2);
        for(Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }



}
