package com.javase.demo;

import java.util.Scanner;

/**
 * TODO
 *
 * @date:2019/9/8 14:19
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

class Main1 {


    public static void main(String[] args) {
        int n ,m;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int count = 0;
            for (int i = n; i <= m; i++) {

                int num = i;
                int num1 = num % 10;
                num /= 10;

                int num2= num % 10;
                num /= 10;

                int num3= num % 10;

                int sum = (int) (Math.pow(num1, 3) + Math.pow(num2, 3) + Math.pow(num3, 3));
                if (i == sum) {
                    count++;
                    System.out.printf("%s\t",i);
                }
            }

            if (count == 0) {
                System.out.println("no");
            }
            System.out.println();
        }

    }



}
