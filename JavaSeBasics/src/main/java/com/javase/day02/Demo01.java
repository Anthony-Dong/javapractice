package com.javase.day02;

/**
 * ClassName:Demo01
 * Package:com.javase.day02
 * Description:
 *
 * @date:2019/6/29 12:13
 * @author: 574986060@qq.com
 */

public class Demo01 {
    public static void main(String[] args) {
        System.out.println();
        for (int j = 0; j < 10;  ++j) {
            System.out.print(j);

        }
        System.out.println();
        for (int j = 0; j < 10;  j++) {
            System.out.print(j);
        }
        System.out.println();
        System.out.println("++j");
        int count = 0;
        for (int j = 0; j < 10;) {
            System.out.print("<--j前j:"+j+","+"count:"+(count++)+"前--->");
            System.out.print("<--j后j:"+(++j)+","+"count:"+(count++)+"后"+"-->");
            System.out.println();
        }
        System.out.println();
        int sum = 0;
        System.out.println("j++");
        for (int j = 0; j < 10; ) {
            System.out.print("<--j前j:"+j+","+"count:"+(sum++)+"前--->");
            System.out.print("<--j后j:"+(j++)+","+"count:"+(sum++)+"后"+"-->");
            System.out.println();
        }
        System.out.println();
        int i = 0;
        System.out.println(i++);
        int j = 0;
        System.out.println(++j);
    }
}
