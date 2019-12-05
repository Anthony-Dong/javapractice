package com.anthony;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaeeSpringbootApplicationTests {



    @Autowired
    private WebApplicationContext context;


    protected MockMvc mvc;

    @Before
    public void setContext() {

        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void test() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/async/me/1");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }


}
