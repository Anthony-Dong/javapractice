package com.string;

/**
 * TODO
 *
 * @date:2019/11/12 20:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class StringToInt {

    public static void main(String[] args) {
        System.out.println("\"+888888\" = " + stringToInteger("+888888"));
        System.out.println("\"55412312\" = " + stringToInteger("55412312"));
        System.out.println("\"-132313\" = " + stringToInteger("-132313"));
    }
    

    public static int stringToInteger(String str) {
        int start = 0, offset = 48;
        boolean positive = false, negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
            start = 1;
        } else if (str.charAt(0) == '+') {
            start = 1;
        } else {
            positive = true;
            start = 0;
        }
        return positive ? arrayToInt(stringToArr(str, start, offset)) //不带 +
                : negative ? arrayToInt(stringToArr(str, start, offset))// 带-
                : arrayToInt(stringToArr(str, start, offset)); // 带+
    }

    private static int arrayToInt(int[] ints) {
        int result = 0;
        int count = 0;
        for (int anInt : ints) {
            result += anInt * pow(10, count);
            count++;
        }
        return result;
    }

    private static int[] stringToArr(String str, int start, int offset) {
        int[] arr = new int[str.length() - start];
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = (int) str.charAt(start + i) - offset;
        }
        return arr;
    }

    // 找的位运算算法,  可能出现超出int最大值  32位 2147483647
    private static int pow(int x, int n) {
        int val;
        val = 1;
        if (n > 0) {
            if (n % 2 == 1)
                val = val * x;
            val = val * pow(x * x, n / 2);
        }
        return val;
    }


    private static void find() {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 6},
                {3, 4, 5},
                {4, 5, 6}
        };
        int k = 5;
        //
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] <= k) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == k) {
                        System.out.println("第" + (i + 1) + "行 , 第" + (j + 1) + "列");
                        // return;
                    }
                }

            }
        }
    }


}
