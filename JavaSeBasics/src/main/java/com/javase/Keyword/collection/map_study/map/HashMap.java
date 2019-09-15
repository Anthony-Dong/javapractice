package com.javase.Keyword.collection.map_study.map;

/**
 * ClassName:HashMap
 * Package:com.javase.Keyword.collection.map_study.map
 * Description:
 *
 * @date:2019/7/7 0:34
 * @author: 574986060@qq.com
 */

public class HashMap<K, V> implements Map<K, V> {
    //    数组+ 链表
    /**
     * 创建数组
     */
    private Entry<K, V>[] table = null;
    private int size = 0;
    /**
     * 链表的默认大小
     */
    private static int defaultLength = 16;

    public HashMap() {
        table = new Entry[defaultLength];
    }

    /**
     * hash 算出的 index值 去数组中找 由于对应下标的链表 可能是一个 可能是多个所以 进行遍历
     * 找到entry中对应的 key 找出entry对应的value值
     * 其实是可以返回 void  因为 hashmap底层的实现也是 返回了 value值 没办法 咱也要学习
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        if (size == 0) {
            return null;
        }
        int index = hash(k);

        Entry<K, V> entry = getEntry(k, index);

        return entry == null ? null : entry.getValue();
    }

    private Entry<K, V> getEntry(K k, int index) {
        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.hash == index && (k == entry.getKey() || k.equals(entry.getKey()))) {
                return entry;
            }
        }
        return null;
    }

    /**
     * 1 ，2
     * 现在插入一个来了 0
     * Entry<K, V> entry = table[index]; 此时的 entry 是 1
     * 现在 需要插入一个entry对象  所以 需要指向 下一个 1，
     * table[index] = new Entry<>(k, v, entry, index);
     * 这是一个链表的实现
     *
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        size++;
//        key进行 hash 找到 ，对应的数组下标 ，判断是否为空 ，是否可以存储
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (null == entry) {
            table[index] = new Entry<>(k, v, null, index);
        } else {
            table[index] = new Entry<>(k, v, entry, index);
        }
        return table[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * hash算法 找到数组对应的坐标
     *
     * @param k
     * @return
     */
    private int hash(K k) {
        return Math.abs(k.hashCode() % (defaultLength - 1));
    }

    /**
     * 链表
     *
     * @param <K>
     * @param <V>
     */
    class Entry<K, V> implements Map.Entry<K, V> {

        private K k;
        private V v;
        private Entry<K, V> next;
        private int hash;

        public Entry(K k, V v, Entry<K, V> next, int hash) {
            this.k = k;
            this.v = v;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
