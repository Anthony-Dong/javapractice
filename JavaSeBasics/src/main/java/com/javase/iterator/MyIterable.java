package com.javase.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * TODO
 *
 * @date:2019/10/23 20:31
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyIterable<E> implements Iterable<E> {
    private List<E> list ;

    public MyIterable(List<E> list) {
        this.list = list;
    }
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<E> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return list.size()>0;
        }
        @Override
        public E next() {
            return list.remove(index);
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        MyIterable<String> strings = new MyIterable<String>(list);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(strings.iterator().hasNext());
    }
}
