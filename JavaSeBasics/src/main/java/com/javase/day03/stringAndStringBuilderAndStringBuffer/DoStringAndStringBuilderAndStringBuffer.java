package com.javase.day03.stringAndStringBuilderAndStringBuffer;

/**
 * ClassName:DoStringAndStringBuilderAndStringBuffer
 * Package:com.javase.day03.DoStringAndStringBuilderAndStringBuffer
 * Description:
 *
 * @date:2019/7/1 11:15
 * @author: 574986060@qq.com
 */


import org.junit.Test;

/**
 * stringBuilder 的方法实现了 Serializable接口   但是没有被 synchronized 修饰
 * 所以 stingBuilder  效率最高
 * stringBuffer  实现了 serializable接口  方法也使用了        synchronize
 *
 * string 只要修改 就要 变更地址  占用内存
 *
 * string 的 加号主要是 使用了 stringBuilder
 *
 * string 直接 字面量 会放到常量池中 ；如果 去new 一个string 会 加载到 堆中 无法和常量池中的去比较
 * string.intern()  是把运行时的常量 强制去和 常量池中的去查找  有就添加到常量池中
 *static final  也是常量区中
 *
 */
public class DoStringAndStringBuilderAndStringBuffer {
    public static final String s8 = "program";
    public static final String s9 = "ming";
    public static final String s10;
    public static final String s11;
    static {
        s10 = "program";
        s11 = "ming";
    }
    @Test
    public void test(){
        String s1 = "programming";
        String s2 = "program"+"ming";
        String s3 = "program";
        String s4 = "ming";
        String s5 ="program"+new String("ming");
        String s6 =new StringBuilder().append("program").append("ming").toString().intern();
        System.out.println(s1 == s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1 == (s3 + s4));
        System.out.println(s1 == (s3 + s4).intern());
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s8+s9);
        System.out.println(s1 == s10+s11);
        System.out.println(s1 == (s10+s11).intern());
    }

}
