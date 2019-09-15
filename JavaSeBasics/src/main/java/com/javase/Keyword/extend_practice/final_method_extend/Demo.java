package com.javase.Keyword.extend_practice.final_method_extend;

/**
 * TODO
 *
 * @date:2019/9/10 12:49
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) {
        try {
            Person person = new Person();
            person.write2();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("111111111111");
        }


    }

}
