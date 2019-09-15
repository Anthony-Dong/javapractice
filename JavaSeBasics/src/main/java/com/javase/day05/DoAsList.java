package com.javase.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:DoAsList
 * Package:com.javase.day05
 * Description:
 *
 * @date:2019/7/3 9:50
 * @author: 574986060@qq.com
 */

/**
 * Arrays.asList  返回的是 arrays里面的一个 arraysList 的 内部类
 * 其中这个ArrayList继承了 abstractList 中
 * 对于 add set remove 方法 都是返回一个 unsupportedOperationException 异常、
 *
 * 其中对于 Arrays.asList  的参数 如果放入 基本数据类型 会出现只存在地址；无法读取的 一个对象
 * 所以 一般必须放入一个 引用类型的对象
 */
public class DoAsList {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<int[]> ints = Arrays.asList(arr);
        System.out.println(ints.size());
        int[] arr2 = ints.get(0);
        System.out.println(""+ Arrays.toString(arr2));


        Integer[] arrys = {1, 2, 4};
        List<Integer> integers = Arrays.asList(arrys);
//        integers.add(1);
        System.out.println(integers);

        String msg = "qwe";
        byte[] bytes = msg.getBytes();

        msg = new String(bytes,0,bytes.length);

    }


}
