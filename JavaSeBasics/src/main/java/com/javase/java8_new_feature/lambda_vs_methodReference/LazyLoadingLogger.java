package com.javase.java8_new_feature.lambda_vs_methodReference;

/**
 * TODO
 *
 * @date:2019/9/20 13:34
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class LazyLoadingLogger {
    private static void log(int level, Fun builder) {
        if (level == 1) {
            System.out.println(builder.build());
        }

    }

    private static void log(int level, String msg) {

        if (level == 1) {
            System.out.println(msg);
        }

    }
    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        log(2, () ->{
            System.out.println("执行了");
            return  msgA + msgB + msgC;
        });


        log(2, msgA + msgB + msgC);

    }



}

@FunctionalInterface
interface Fun{

    String build();
}
