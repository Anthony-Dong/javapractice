package com.javase.day07.syntactic_sugar.assert_test;

import org.junit.Test;

import java.util.*;

import org.springframework.util.CollectionUtils;

/**
 * ClassName:Demo
 * Package:com.javase.day07.test.demo01
 * Description:
 *
 * @date:2019/7/11 13:49
 * @author: 574986060@qq.com
 */

public class Demo {

    /**
     * assert  断言  jvm默认 不支持  需要 手动去支持
     * <p>
     * （1）assert [boolean 表达式]
     * <p>
     * 如果[boolean表达式]为true，则程序继续执行。
     * <p>
     * 如果为false，则程序抛出AssertionError，并终止执行。
     * <p>
     * （2）assert[boolean 表达式 : 错误表达式 （日志）]
     * <p>
     * 如果[boolean表达式]为true，则程序继续执行。
     * <p>
     * 如果为false，则程序抛出java.lang.AssertionError，输出[错误信息]。
     * <p>
     * 说白了就是设置一下jvm的参数，参数是-ea或者-enableassertions
     *
     * @param s
     */
    public static void assertTest(String s) {
        assert (s.equals("OK")) : "垃圾";
        System.out.println(s);
    }

    @Test
    public void test01() {
        assertTest("OKK");
    }

    /**
     * 枚举与Switch语句
     * option: --decodeenumswitch false
     */
    public static int switchEnumTest(EnumTest e) {
        switch (e) {
            case FOO:
                return 1;
            case BAP:
                return 2;
        }
        return 0;
    }

    /**
     * 枚举, JDK1.5开始支持
     *当我们自定义一个枚举类型时, 编译器会自动创建一个被final修饰的同名类 来继承Enum(Enum是一个 抽象类),
     * 所以自定义枚举类型是无法继承和被继承的。当枚举类初始化时, 枚举字段引用该枚举类的一个静态常量对象,
     * 并且所有的枚举字段都用常量数组$VALUES来存储。values()方法内则调用Object的clone()方法,
     * 参照$VALUES数组对象复制一个新的数组, 新数组会有所有的枚举字段。
     *
     * option: --sugarenums false
     */
    public enum EnumTest {
        FOO,
        BAR,
        BAP
    }





    @Test
    public void test02() {
        System.out.println(switchEnumTest(EnumTest.BAR));
    }

    /**
     * 字符串与Switch语句
     * switch支持字符串是通过hashCode()和equals()方法来实现的, 先通过hashCode()返回的哈希值进行switch,
     * 然后通过equals()方法比较进行安全检查, 调用equals()是为了防止可能发生的哈希碰撞。
     * option: --decodestringswitch false
     */
    public static int switchStringTest(String s) {
        switch (s) {
            default:
                System.out.println("Test");
                break;
            case "BB":  // BB and Aa have the same hashcode.
                return 12;
            case "Aa":
            case "FRED":
                return 13;
        }
        System.out.println("Here");
        return 0;
    }

    @Test
    public void test03() {
        System.out.println(switchStringTest("Aa"));
    }

    /**
     * 可变参数
     * option: --arrayiter false
     */
    public static void varargsTest(String... arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }

    @Test
    public void test04() {
        varargsTest("aa", "aaa");
    }


    /**
     * 自动装箱/拆箱
     * 首先我们知道, 基本类型与包装类型在某些操作符的作用下,
     * 包装类型调用valueOf()方法的过程叫做装箱, 调用xxxValue()方法的过程叫做拆箱
     * 。所以上面的结果很容易看出, 先对两个包装类进行拆箱, 再对运算结果进行装箱。
     * option: --sugarboxing false
     */
    public static Double autoBoxingTest(Integer i, Double d) {
        return d + i;
    }


    @Test
    public void test05() {
        Double d = 1.7;
        System.out.println(d.intValue());
        System.out.println(autoBoxingTest(1,1.0));
    }


    /**
     * 泛型擦除
     * 在JVM中没有泛型这一概念,  只有普通方法和普通类, 所有泛型类的泛型参数都会在编译时期被擦除,
     * 所以泛型类并没有自己独有的Class类对象比如List<Integer>.class, 而只有List.class对象。
     * option:
     */
    public void genericEraseTest() {
        List<String> list =  new ArrayList<String>();
    }


    /**
     * 增强for循环
     * 很明显, 增强for循环的底层其实还是通过迭代器来实现的,
     * 这也就解释了为什么增强for循环中不能进行对 数组的增删改操作。
     *
     * option: --collectioniter false
     */
    public void forLoopTest() {
        String[] qingshanli = {"haha", "qingshan", "helloworld", "ceshi"};
        List<String> list =  Arrays.asList(qingshanli);
        for (Object s : list) {
            System.out.println(s);
        }
    }

    public static void testIterator(List list) {
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            next = "aaa";
            System.out.println(next);
        }
    }

    @Test
    public void test06() {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        testIterator(list);

        for (Object s : list) {
            s = "aaaa";
            System.out.println(s.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            list.add("aaaaaa");
            if (list.size() == 11) {
              break;
            }
        }
        for (Object s : list) {

            System.out.print(s.toString());
        }
    }


    /**
     * lambda表达式
     * option: --decodelambdas false
     */
    @Test
    public void lambdaTest() {
        String[] qingshanli = {"haha", "qingshan", "helloworld", "ceshi"};
        List<String> list =  Arrays.asList(qingshanli);
        // 使用lambda表达式以及函数操作
        list.forEach((str) -> System.out.print(str + "; "));
        // 在JDK8中使用双冒号操作符
        list.forEach(System.out::println);
    }




    @Test
    public void test08(){
        int i=100;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Math.round(1/2));

        System.out.println(Arrays.toString(binary(100).toArray()));
    }
    // 100%10= 10 ...0  10/10= 1...0   0/10=1...0
    public static List<Integer>  decimalism (int i){
        List<Integer> list = new ArrayList<>();
        while (i%10!=0) {
            list.add((i%10));
            i /= 10;
        }
        return list;
    }
    // 100%2= 50 ...0  50/2= 25...0  25/2=1...0
    public static List<Integer>  binary (double i){
        List<Integer> list = new ArrayList<>();
        while (Math.round(i/2)!=0) {
            list.add((int) (i%2));
            i /= 2;
        }

        return list;
    }



}