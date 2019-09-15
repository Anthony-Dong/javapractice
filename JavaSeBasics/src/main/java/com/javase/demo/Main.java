package com.javase.demo;



import java.util.Scanner;


class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n, m;
        float sum = 1;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            int num1 = m + n;
            int x = num1 / 3;
            int count = 0;
            for (int j = 0; j < x+1; j++) {
                for (int i = 1; i <= 3; i++) {

                    if (n < num1) {
                        sum *= ((float) n / (float) num1);
                        count++;
                        if (count % 3 == 1) {

                            sum += ((float) n / (float) num1);

                        }
                    }
                    num1--;
                }
            }

            System.out.println(sum*2/3);

        }

    }


}
