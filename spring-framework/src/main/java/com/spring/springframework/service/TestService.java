package com.spring.springframework.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @date:2019/10/1 23:59
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Service
public class TestService {


    public void test01(@NonNull String s) {

        System.out.println(s);
    }

}
