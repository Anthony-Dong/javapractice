package com.javase.Keyword.collection.map_study.map;

/**
 * ClassName:Map
 * Package:com.javase.Keyword.collection.map_study.map
 * Description:
 *
 * @date:2019/7/7 0:31
 * @author: 574986060@qq.com
 */

public interface Map<K, V> {
    V get(K k);

    V put(K k, V v);

    int size();

    interface Entry<K,V>{
        K getKey();

        V getValue();
    }
}
