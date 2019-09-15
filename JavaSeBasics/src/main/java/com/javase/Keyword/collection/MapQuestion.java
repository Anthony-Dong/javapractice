package com.javase.Keyword.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * TODO
 *
 * @date:2019/9/11 21:13
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MapQuestion {


    public static void main(String[] args) {

        Hashtable<Object, Object> hashtable = new Hashtable<>();
//        hashtable.put(null, null);


        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(null, null);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, null);


        ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();
        map.put(1, 1);
        map.put(3, 3);
        map.put(2, 2);
        System.out.println(map.size());

        System.out.println(map);



    }


}
