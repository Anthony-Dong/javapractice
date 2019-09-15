package com.javase.day07.syntactic_sugar.try_with_resources;

import lombok.var;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * ClassName:Demo
 * Package:com.javase.day07.syntactic_sugar.try_with_resources
 * Description:
 *
 * @date:2019/7/13 0:42
 * @author: 574986060@qq.com
 */

public class Demo {

    /**
     * try-with-resources语句
     * option: --tryresources false
     */

    public void tryWithResourcesTest() throws IOException {
        try (final StringWriter writer = new StringWriter();
             final StringWriter writer2 = new StringWriter()) {
            writer.write("This is qingshanli1");
            writer2.write("this is qingshanli2");
        }
    }

    @Test
    public  void test() throws Exception{

    }

    /**
     * 局部变量类型推断, JDK10开始支持
     * option: 不需要参数
     */
    @Test
    public void varTest() {
        //初始化局部变量
        var string = "强无敌";
        //初始化局部变量
        var stringList = new ArrayList<String>();
        stringList.add("九幽阴灵，诸天神魔，以我血躯，奉为牺牲。");
        stringList.add("三生七世，永堕阎罗，只为情故，虽死不悔！");
        stringList.add("blog:http://www.cnblogs.com/qingshanli/");
        //增强for循环的索引
        for (var s : stringList){
            System.out.println(s);
        }
        //传统for循环的局部变量定义
        for (var i = 0; i < stringList.size(); i++){
            System.out.println(stringList.get(i));
        }
    }
}
