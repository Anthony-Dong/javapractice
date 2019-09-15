package com.javase.Keyword.implement_keyword;


/**
 * ClassName:ClassII
 * Package:com.javase.day01.abstractAndInterface
 * Description:
 *
 * @date:2019/6/28 10:30
 * @author: 574986060@qq.com
 */

public class ClassII implements ClassI{



    @Override
    public void me() {

        System.out.println("我是实例化对象,我可以重写父类的 final 方法");
    }

    public static void main(String[] args) {
        // 1. 成员变量可以直接引用  因为是
        System.out.println(ClassI.a);
        ClassI classI = new ClassII();
        // 2. 实例化对象 可以重写 default 方法
        classI.me();
        // 3. 但是不能重写 static方法
        ClassI.method02();


    }
}
