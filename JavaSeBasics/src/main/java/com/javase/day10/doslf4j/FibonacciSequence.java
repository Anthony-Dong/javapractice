package com.javase.day10.doslf4j;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName:FibonacciSequence
 * Package:com.javase.day10.doslf4j
 * Description:
 *
 * @date:2019/7/23 15:27
 * @author: 574986060@qq.com
 */

public class FibonacciSequence {

    @Test
    public void test(){
        int[] ints = arrayFibonacci(3);

        Arrays.stream(ints).forEach(System.out::println);
    }

    public int[] arrayFibonacci(int count) {
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                arr[0] = 1;
            }
            if (i == 1) {
                arr[1] = 1;
            }
            if (i > 1) {
                arr[i] = arr[i - 2] + arr[i-1];
            }
        }
        return arr;
    }


    @Test
    public void test01(){
        System.out.println("<--------------------->");
        String msg = "我A我A我我11AA11";
        findMax(msg).forEach(System.out::print);
    }


    @Test
    public void test03(){

        int[] ints = arrayFibonacci(10);

        Arrays.stream(ints).forEach(System.out::print);
        System.out.println();

        String msg = "public static boolean isUpperCase(char ch)";
        findMax(msg).forEach(System.out::print);
        System.out.println();

        findArr(100).forEach(System.out::print);
    }

    public List<Character>  findMax(String msg){
        List<Integer> list = find(findMaxcha(msg));
        List<Character> cs = new ArrayList<>();
        for (Integer integer : list) {
            char c = msg.charAt(integer);
            cs.add(c);
        }
        return cs.stream().distinct().collect(Collectors.toList());
    }

    //   vdaaa
    public int[] findMaxcha(String arr) {
        char[] chars = arr.toCharArray();
        int[] ints = new int[arr.length()];
        int count = 0;
        for (char aChar : chars) {
            int sum = 0;
            for (char bChar : chars){
                if (aChar == bChar) {
                    sum++;
                    ints[count] = sum;
                }
            }
            count++;
        }
        return ints;
    }

    public List<Integer> find(int[] ints) {
        int max = Arrays.stream(ints).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == max) {
                list.add(i);
            }
        }
        return list;
    }


    public List<Integer>  findArr(Integer num){
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            double pow = Math.pow(2, i);
            list.add((int) pow);
            sum+= pow;
            if (sum >= num) {
                break;
            }
        }
        return list;
    }
}
