package com.javase.day07.fork_join;

import org.junit.Test;

import java.time.Year;
import java.util.stream.LongStream;

/**
 * ClassName:MyTaskDemo
 * Package:com.javase.day07.fork_join
 * Description:
 *
 * @date:2019/7/13 16:32
 * @author: 574986060@qq.com
 */

public class MyTaskDemo {

    @Test
    public void test(){
        long reduce = LongStream.rangeClosed(0, 100000000L).parallel().reduce(0, Long::sum);
        System.out.println(reduce);
    }

}
