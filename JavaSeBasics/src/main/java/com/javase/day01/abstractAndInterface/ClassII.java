package com.javase.day01.abstractAndInterface;


/**
 * ClassName:ClassII
 * Package:com.javase.day01.abstractAndInterface
 * Description:
 *
 * @date:2019/6/28 10:30
 * @author: 574986060@qq.com
 */

public class ClassII implements ClassI{


    /**
     * static方法 和 default方法不用 重写
     * static 方法 不能重写  可以直接使用接口.方法 使用
     *
     * default 可以重写
     *
     * 成员变量不可以引用
     */

    @Override
    public void me() {

        System.out.println("@Override\n" +
                "    public void me()");
    }

    public static void main(String[] args) {
        // 1. 成员变量可以直接引用  因为是
        System.out.println(ClassI.a);
        ClassI classI = new ClassII();
        classI.me();
        ClassI.method02();


    }
}
