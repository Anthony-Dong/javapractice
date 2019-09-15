package com.javase.day07.test;

import org.junit.Test;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.security.SecureRandom;

/**
 * ClassName:DoRandom
 * Package:com.javase.day07.test
 * Description:
 *
 * @date:2019/7/12 22:31
 * @author: 574986060@qq.com
 */

public class DoRandom {

    @Test
    public void test01(){
        Random random = new Random();
//        ThreadLocalRandom threadLocalRandom = new ThreadLocalRandom();
        SecureRandom secureRandom = new SecureRandom();
        SplittableRandom splittableRandom = new SplittableRandom();

    }
}
