package com.spring.springframework;

import com.spring.springframework.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFrameworkApplicationTests {

    @Autowired
    private TestService service;


    @Test
    public void contextLoads() {

        service.test01(null);
    }

}
