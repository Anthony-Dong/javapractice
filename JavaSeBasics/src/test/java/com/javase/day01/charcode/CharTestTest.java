package com.javase.day01.charcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName:CharTestTest
 * Package:com.javase.day01.charcode
 * Description:
 *java 内部 采用 Unicode编码方式  都是 两个字节
 * @date:2019/6/28 10:20
 * @author: 574986060@qq.com
 */

public class CharTestTest {


    @Test
    public void test01(){
        char a = 'a';
        char b = '安';

        System.out.println(a);
        System.out.println(b);
    }

}