package com.top_k;



import java.security.SecureRandom;
import java.util.Arrays;

/**
 * 冒泡排序法 的 算法复杂度为  O(n*k)   n为数组长度  k为需要的前n项
 *
 * @date:2019/10/3 18:44
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TopKBubble {


    public static void main(String[] args) {
        int count = 1000000;
        int[] arrs = new int[count];

        for (int i = count-1; i >=0; --i) {
            arrs[i] = new SecureRandom().nextInt(100000000);
        }


        long start = System.currentTimeMillis();
        int[] bubble = bubble(arrs, 100);
        System.out.println("冒泡-TOPK : "+(System.currentTimeMillis()-start));
        for (int i : bubble) {
            System.out.printf("%d\t",i);
        }


        System.out.println();
        long start2 = System.currentTimeMillis();
        int[] ints = TopKHeap.heapTopK(arrs, 100);
        System.out.println("堆排序-TOPK : "+(System.currentTimeMillis()-start2));

        for (int i : ints) {
            System.out.printf("%d\t",i);
        }


        System.out.println();
        long start3 = System.currentTimeMillis();
        Arrays.sort(arrs);
        System.out.println("快排全部遍历-TOPK : "+(System.currentTimeMillis()-start3));


    }



    public static int [] bubble(int[] arrs, int count) {

        int[] arr = new int[count];

        int length = arrs.length;

        // 冒泡排序 (限制外层只循环3次)
        for (int x = 0; x < count; ++x) {

            //
            for (int j = length-1; j >x ; --j) {
                // 前面的数组大于 后面的
                if (arrs[j] > arrs[j-1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j-1];
                    arrs[j-1] = temp;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            arr[i] = arrs[i];
        }
        return arr;
    }


    private static String toStrings(int[] arr) {

        StringBuilder builder = new StringBuilder();

        for (int i : arr) {
            builder.append(i).append("  ");
        }

        return builder.toString();
    }


}
