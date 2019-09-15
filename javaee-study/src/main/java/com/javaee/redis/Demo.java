package com.javaee.redis;

import org.apache.commons.lang3.ObjectUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * ClassName:Demo
 * Package:com.jedis.test
 * Description:
 *
 * @date:2019/8/10 13:52
 * @author: 574986060@qq.com
 */

public class Demo {
    private static Jedis jedis = new Jedis("192.168.58.129", 6379);
    private static int dbcunt = 0;
    private static List<Person> peoples = new ArrayList<Person>();
    static {
        peoples.add(new Person("tom", 0));
        peoples.add(new Person("tom1", 1));
        peoples.add(new Person("tom2", 2));
        peoples.add(new Person("tom3", 3));
        peoples.add(new Person("tom4", 4));
        peoples.add(new Person("tom5", 5));
    }


    public static void main(String[] args) {

//        String set = jedis.set("lock", "1", "nx", "ex", 10);
//        System.out.println(set);
//        JedisCluster cluster = new JedisCluster();
        Demo demo = new Demo();

        List<Integer> requests = new ArrayList<Integer>();

        for (int i = 0; i < 1000; i++) {
            requests.add(new Random().nextInt(11));
        }

        for (Integer request : requests) {
            System.out.println("username = " + demo.testPress(request));
        }

    }


    public  String testPress(Integer id){

//这里 没有做 异常操作 其实对于 获取对象异常的问题 是 可以直接throw  不然 线程就卡死了

//       一. 缓存穿透  某些恶意攻击的人
        //1.用户请求,首先要去 redis里面取数据
        String name = jedis.get(id.toString());
//        2. 不为空 ,则直接返回值
        if (ObjectUtils.allNotNull(name)) {
            System.out.println("从redis里面取");
            return name;
        } else {

//   二.缓存雪崩和缓存击穿;都是因为某时间段 key 消失;但是请求缺急剧上升;没毫秒都是很多的;这时候需要 拿令牌去访问数据库
//            我觉得设置 到这里比较好;因为是  如果每个请求都要拿到令牌去访问redis会给redis造成很大压力
//            所以在没有数据的情况下 才要执行
            String uuid = UUID.randomUUID().toString();
            String set = jedis.set("user_lock", uuid, "nx", "ex", 1000);

            if (ObjectUtils.allNotNull(set) && set.equalsIgnoreCase("ok")) {

                //3.如果为空则请求数据库
                System.out.println("从数据库中取");
                dbcunt++;
                System.out.println("[从数据库中请求次数] :" + dbcunt);
                Person info = getInfo(id);
//            4.如果数据库中的数据不为空,则返回 数据数据库中的数据 并且把数据存入到redis中
                if (ObjectUtils.allNotNull(info)) {
                    System.out.println("存入到redis中");
                    jedis.setex(id.toString(), 60, info.getName());

//                 2.2 问题 :如果数据库操作比较久 ;可能很长实现 ;超出了 你所设置的锁的时间; 此时 锁已经么了 ;又有访问了;这里 我没有想到解决思路
//                    用的最简单的方式 直接给 锁加很长时间 ;解锁的唯一条件就是 拿到锁的值;才能解锁
                        if (uuid.equals(jedis.get("user_lock"))){
                            jedis.del("user_lock");
                        }
                    return jedis.get(id.toString());
                } else {
//                5.如果数据库中的数据为空,则应该给 存入给redis一个空值
                    jedis.setex(id.toString(), 30, "用户不存在");
                    if (uuid.equals(jedis.get("user_lock"))){
                        jedis.del("user_lock");
                    }
                    return jedis.get(id.toString());
                }
            } else {
                try {
//                    这里 就是 设置 一个  自旋锁
                    Thread.sleep(2000);
                    return testPress(id);
                } catch (InterruptedException e) {
                    throw new RuntimeException("你是爸爸 ,你能走到这里");
                }
            }
        }
    }

//模拟 数据库 操作
    public  Person getInfo(Integer id){
        try {
            Person person = peoples.get(id);
            return person;
        } catch (Exception e) {
            return null;
        }
    }
}

class Person{
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}