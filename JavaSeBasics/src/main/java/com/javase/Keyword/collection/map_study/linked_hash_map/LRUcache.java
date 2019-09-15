package com.javase.Keyword.collection.map_study.linked_hash_map;

import java.util.*;

/**
 *
 *
 * @date:2019/9/13 12:07
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class LRUcache {

    private  LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    private int capacity;

    public LRUcache(int capacity) {
        this.capacity = capacity;
    }
    public Integer get(Integer key){
        Integer integer = map.get(key);
        if (null == integer) {
            return -1;
        }
        // 每次用的时候先删除,然后把他插入到队未
        map.remove(key);
        map.put(key, integer);
        return integer;
    }
    public void put(Integer key, Integer value) {
        map.put(key, value);
        if (map.size() > capacity) {
            Set<Integer> integers = map.keySet();
            Optional<Integer> first = integers.stream().findFirst();
            map.remove(first.get());
        }
    }

    public static void main(String[] args) {
        LRUcache lrUcache = new LRUcache(2);
        lrUcache.put(1, 1);
        lrUcache.put(2, 2);
        System.out.println(lrUcache.get(1));
        lrUcache.put(3, 3);
        System.out.println(lrUcache.get(2));
        lrUcache.put(4, 4);
        System.out.println(lrUcache.get(1));
        System.out.println(lrUcache.get(3));
        System.out.println(lrUcache.get(4));
    }
}
