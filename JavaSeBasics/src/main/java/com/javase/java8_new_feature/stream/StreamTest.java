package com.javase.java8_new_feature.stream;

import com.javase.java8_new_feature.lambdaTest.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName:StreamTest
 * Package:com.javase.java8_new_feature.stream
 * Description:
 *
 * @date:2019/7/11 22:31
 * @author: 574986060@qq.com
 */
@Slf4j
public class StreamTest {

    List<Person> persons = Arrays.asList(
            new Person("儿子7", 19),
            new Person("儿子3", 13),
            new Person("儿子1", 11),
            new Person("儿子7", 17),
            new Person("儿子7", 17),
            new Person("儿子7", 17),
            new Person("儿子4", 14),
            new Person("儿子2", 12),
            new Person("儿子5", 15),
            new Person("儿子7", 18),
            new Person("儿子6", 16)
    );

    /**
     * 创建流  .stream() arrays.stream() 获取普通流   parallelStream获取并行流
     * 中间操作
     * 1、filter ( (Predicate)   boolean test(T t);
     * skip() 跳过
     * limit() 限制数量 短路操作
     * distinct()  去处重复  比较 hashcode值 和 equal方法  实体类必须实现
     * 2、map(Function )     R apply(T t);
     * .flatMap()  可以进行多个 stream流的操作；进行混合处理  和 add（）与 addAll（）的区别一样
     * 3、sorted(Comparator)  int compare(T o1, T o2); 或者 Comparator.comparingInt(Person::getAge)
     * 默认 不带参数的 默认实现的是 Comparable接口的 方法 compareTo方法
     * 结束流  terminate
     * 1、anyMatch  allMatch noneMatch (predicate)
     * 2、findFirst  findAny 无参数
     * 3、count 无惨
     * 4、min（）  max（Comparator）
     * 5、reduce 归纳函数    list.stream().reduce(0, (x, y) -> x + y);
     * 7、collect 收集函数  接收一个实现collector的接口实现 用于stream中的汇总
     *  <R, A> R collect(Collector<? super T, A, R> collector);  也可以用    的方法 返回 list
     *  多级分组 分组
     *  java.util.stream.Collectors
     *  joining
     *  summarizingInt
     *  groupingBy
     *  toMap
     *  toCollection(HashSet::new)
     */
    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        persons.stream().filter(person -> person.getAge() > 12).skip(2).distinct().map(Person::getAge).forEach(System.out::println);
    }

    @Test
    public void test05() {

        persons.stream().map(
                (person) -> {
                    if (person.getAge() > 15) {
                        return person.getAge();
                    }
                    return null;
                }
        ).forEach(System.out::println);
    }

    @Test
    public void test06() {

        persons.stream().sorted((p1, p2) -> {
            if (p1.getAge() == p2.getAge()) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        }).forEach((person -> System.out.println(person)));
    }

    @Test
    public void test07() {
        persons.parallelStream().map(Person::getName).forEach((person -> System.out.println(person)));
    }

    @Test
    public void test08() {

        boolean b = persons.stream().anyMatch(person -> person.getAge() == 11);
        boolean b2 = persons.stream().allMatch(person -> person.getAge() == 11);
        boolean b3 = persons.stream().noneMatch(person -> person.getAge() == 11);
        System.out.println(b);
        System.out.println(b2);
        System.out.println(b3);
        Optional<Person> first = persons.stream().findFirst();
        System.out.println(first.get());
        Optional<Person> first1 = persons.parallelStream().findAny();
        System.out.println(first1.get());

        long count = persons.stream().count();
        System.out.println(count);

        Optional<Person> max = persons.stream().max(Comparator.comparingInt(Person::getAge));
        System.out.println("----------->" + max.get());
        Optional<Integer> min = persons.stream().map(Person::getAge).min(Comparator.comparingInt(p -> p));
        System.out.println("min" + min.get());

        List<Person> list = new ArrayList<>();
        Optional<Person> max2 = list.stream().max(Comparator.comparingInt(Person::getAge));
        System.out.println(max2);

    }

    @Test
    public void test09() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().map(x -> x * 2).filter(x -> x > 10).reduce(0, (x, y) -> x + y);
        log.info(reduce.toString());

        Optional<Integer> reduce1 = persons.stream().map(Person::getAge).reduce(Integer::sum);
        log.info(reduce1.get().toString());

    }
    @Test
    public void test10(){
        Set<String> collect = persons.stream().map(Person::getName).collect(Collectors.toSet());
        collect.forEach(System.out::println);

        Set<String> collect02 = persons.stream().map(Person::getName).collect(Collectors.toCollection(HashSet::new));
        collect02.forEach(System.out::println);

        Map<Integer, String> collect1 = persons.stream().distinct().collect(Collectors.toMap(
                Person::getAge,
                Person::getName
        ));

        Set<Integer> strings = collect1.keySet();
        Iterator iterator = strings.iterator();
        while (iterator.hasNext()) {
            Integer next = (Integer) iterator.next();
            System.out.println(next + "--------->" + collect1.get(next));
        }

        CollectionUtils.isEmpty(collect1);
        System.out.println(Arrays.toString(collect.toArray()));


        Map<String, List<Person>> collect2 = persons.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println(collect2);
    }
@Test
public void test11(){

    IntSummaryStatistics collect = persons.stream().collect(Collectors.summarizingInt(Person::getAge));
    System.out.println(collect.getAverage());

}

    @Test
    public void test12(){

        String collect = persons.stream().map(Person::getName).collect(Collectors.joining("-"));
        System.out.println(collect);

    }

    @Test
    public void test13(){

        String collect = persons.stream().map(Person::getName).collect(Collectors.joining("-"));
        System.out.println(collect);

    }
    @Test
    public void test14(){
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6, 8, 2, 1, 5);
        list.stream().distinct().forEach(
                System.out::println
        );

        list.stream().reduce(
                (a,b)->{
                    return a + b;
                }
        );

    }


    @Test
    public void test02() {
        String[] strs = new String[100];
        Arrays.stream(strs);
    }

    @Test
    public void test03() {
        Stream<? extends Serializable> stream = Stream.of("11", 1);
    }


    @Test
    public void test04() {
        Stream.generate(() -> new Random().nextInt(100)).limit(10).forEach(System.out::println);

    }

    public int test00(int i) {
        if (i > 10) {
            return i;
        }
        return 0;
    }
}
