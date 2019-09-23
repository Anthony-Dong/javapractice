package com.javase.Keyword.extend_package;

/**
 * TODO
 *
 * @date:2019/9/6 23:39
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Son extends Person {
    static Integer integer = 10;
    Integer integers = 10;

    private Integer pp = 10;

    public Son(Integer pp) {
        super();
        System.out.println(pp);
    }



    @Override
    public void show() {
        System.out.println("son");
    }


    public  Son(){
        System.out.println("yyyyyyyyyyyyyyyy");
    }



}
