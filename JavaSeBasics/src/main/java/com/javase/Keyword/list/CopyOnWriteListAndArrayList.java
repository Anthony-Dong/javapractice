package com.javase.Keyword.list;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 比较两者 执行写操作时的差距
 *
 * @date:2019/9/7 17:27
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class CopyOnWriteListAndArrayList {

    public static void main(String[] args) {
        int i = 100000;
        ArrayList<Integer> arrayList = new ArrayList<Integer> ();
        long start1 = System.currentTimeMillis();
        for (int i1 = 0; i1 < i; i1++) {
            arrayList.add(i1);
        }
        System.out.println(System.currentTimeMillis() - start1);

        int j = 100000;
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList <Integer> ();
        long start2 = System.currentTimeMillis();
        for (int i1 = 0; i1 < j; i1++) {
            list.add(i1);
        }
        System.out.println(list.size());
        System.out.println(System.currentTimeMillis() - start2);
    }

}
