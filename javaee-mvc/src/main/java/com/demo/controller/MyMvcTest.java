package com.demo.controller;


import com.demo.annotation.RequestMapping;
import com.demo.config.RequestMethod;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;


/**
 * controller 层
 *
 * @date:2019/9/15 14:14
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Controller
public class MyMvcTest {

    // 必须加下划线
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String get(String name, HttpServletRequest request) {
        request.setAttribute("hello", name);

        return "hello";
    }


    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String get2(){
        return "hello";
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String get3(String name, HttpServletRequest request) {

        request.setAttribute("hello", name);
        return "hello";
    }



}
