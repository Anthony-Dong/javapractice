package com.sort;

import java.util.Arrays;

/**
 * 桶排序
 *
 * @date:2019/11/27 16:54
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class BucketSort {

    public static void main(String[] args) {

        int[] arr = {100, 9, 2, 3, 4, 5, 6, 1, 0, 19, 20};

        bucketSort(arr, 3);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    /**
     * @param arr 数组
     * @param bucketCount 桶的个数
     */
    public static void bucketSort(int[] arr, int bucketCount) {
        int len = arr.length;
        if (len <= 1 || bucketCount <= 0) {
            return;
        }

        // 遍历一次找到最大值 最小值
        int max = arr[0], min = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        /**
         * 划分区间 , 比如  5 - 11 ,此时我们需要 / 桶数量 (假如 是 2), 如果我们不+1 , 6 / 2 = 3 ,那么 (11-5)/3=2 , 此时坐标2这个桶
         *
         * 所以区间需要+1 操作 , 所以上面就是 7/2=3.5=4 , (11-5)/4=1
         */
        int range = ((max - min + 1) % bucketCount) == 0 ? (max - min + 1) / bucketCount : (max - min + 1) / bucketCount + 1;


        // 创建桶 ,是一个二维数组
        int[][] bucket = new int[bucketCount][];

        for (int i : arr) {
            bucket[(i - min) / range] = arrAppend(bucket[(i - min) / range], i);
        }


        for (int[] ints : bucket) {
            InsertSort.sort(ints);
        }

        int count = 0;
        for (int[] ints : bucket) {
            if (ints != null) {
                for (int anInt : ints) {
                    arr[count++] = anInt;
                }
            }
        }


    }

    /**
     * 数组拷贝
     *
     * @param arr
     * @param value
     * @return
     */
    private static int[] arrAppend(int[] arr, int value) {
        //数组如果为空, 新建一个数组,
        if (arr == null) {
            arr = new int[0];
        }
        // 数组拷贝 , 其实就是长度+1
        arr = Arrays.copyOf(arr, arr.length + 1);
        // 将值复制
        arr[arr.length - 1] = value;

        //返回
        return arr;
    }

}
