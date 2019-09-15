package com.javase.day10.doslf4j;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName:doSlf4j
 * Package:com.javase.day10
 * Description:
 *
 * @date:2019/7/22 19:48
 * @author: 574986060@qq.com
 */
@Slf4j
public class doSlf4j {


    public static void test(){
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("[运行异常] 信息：{}", e.getMessage());
           return;
        }
    }


    @Test
    public void test01() {
        char a = 'b';
        System.out.println((int) a);
        String str = "a";
        for (byte aByte : str.getBytes()) {
            System.out.println(aByte);
        }
    }


    public static Supplier<Integer> testClosure(){
        final int i = 1;
        return new Supplier<Integer>() {
            @Override
            public Integer get() {
                return i;
            }
        };
    }
    public interface Supplier<T> {
        T get();
    }

    @Test
    public void test02(){
        Supplier<Integer> integerSupplier = testClosure();
        System.out.println(integerSupplier.get());
    }


    static int n = 1;
    public void convert(){
        n = 100;
    }
    @Test
    public void test03(){
//        convert();
//        System.out.println(n);

//
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.offer(0);
//        queue.offer(1);
//
//
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue);


//
//        Queue queue = new PriorityQueue();
//        for(int i=9;i>=0;i--)
//        {
//            queue.offer(i);
//            System.out.print(queue);
//            System.out.println(queue.peek());
//        }
//        System.out.println(queue);
//        queue.forEach(System.out::println);

//        int a = 237;
//        byte b = 121;
//        byte c = (byte) (a + b);
//        System.out.println(c);


        System.out.println(test02(3, 20));
    }


    public double  test02(int N, int D) {
        double a = 75.0 / 18.0;     //4.166
        double b = 75.0 / 15.0;     //5
        double c = 45.0 / 10.0;     //4.5

        switch (N) {
            case 1:
                if (D > 15) {
                    return 0;
                }
                return a*D;
            case 2:
                if (D > 15 + 18) {
                    return 0;
                }
                if (D < 15 ) {
                    return b * D;
                }
                return 75 + a * (D- 15);
            case 3:
                if (D < 15 ) {
                    return b * N;
                }
                if (D>15&&D < 15 + 18) {
                    return 75 + a * (D- 15);
                }
                if (D > 15 + 18 && D < 15 + 18 + 15) {
                    return 75 + 75 + c * (D - 15 - 18);
                }
                break;
            default:
                return 0;
        }

        return 0;
    }

    public double[] count(int[] store,int[] totalPrice) {

        double[] price = new double[store.length];
        for (int i = 0; i < store.length; i++) {
            price[i] = (double)totalPrice[i] / (double)store[i];
        }
        Arrays.sort(price);
        return price;
    }


    @Test
    public void test04() {
        int i = 10;
        Integer integer = Integer.valueOf(10);
        System.out.println(integer);


    }
}
