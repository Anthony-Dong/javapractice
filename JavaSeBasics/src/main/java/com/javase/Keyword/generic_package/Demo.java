package com.javase.Keyword.generic_package;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @date:2019/9/16 12:13
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {
        ArrayList<? super Object> strings = new ArrayList<>();


        strings.add("1");
        System.out.println(strings.get(0) instanceof Object);


        Test<Object> objectTest = new Test<>();

        int[] arr = {1, 2, 3, 4};




    }


}


class Test<T> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
