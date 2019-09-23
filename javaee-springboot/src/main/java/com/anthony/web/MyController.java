package com.anthony.web;

import com.anthony.api.ApiResponse;
import com.anthony.api.Page;
import com.anthony.core.BasicController;
import com.anthony.exception.ErrorCodeEnum;
import com.anthony.exception.MyException;
import lombok.Data;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;

/**
 * TODO
 *
 * @date:2019/9/20 20:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */


@RestController
public class MyController extends BasicController {
    private static Integer x = 0;

    @RequestMapping("/get")
    public ApiResponse<Integer> get(){
        Integer x = getX();
        ApiResponse<Integer> a = success(x);
        System.out.println("a.hashCode() = " + a.hashCode() +"   x: "+ MyController.x);

        return success(MyController.x);
    }


    @RequestMapping("/get1")
    public @ResponseBody Integer get1(){

        Integer x = getX();

        Singleton2 instance = Singleton2.getInstance(x);

        System.out.println("a.hashCode() = " + instance.hashCode() +"   x: "+ MyController.x);

        return x;
    }
    @RequestMapping("/get6")
    public @ResponseBody Integer get6(){


        Integer i = DoubleCheckSingleton.getInstance().hashCode();

        System.out.println("hashcode 值 : " + i);

        return i;
    }



    @RequestMapping("/get7")
    public @ResponseBody Singleton get7(){
        Singleton instance = Singleton.getInstance(null,null);
        return instance;
    }


    @RequestMapping("/get8")
    public @ResponseBody PrototyptBean get8(){
        PrototyptBean bean = new PrototyptBean();
        return bean;
    }



    @PostMapping("/get2")
    public ApiResponse<String> get2(@RequestParam("name") String name) {

        return success(HttpStatus.ACCEPTED, name);
    }


    @PostMapping("/get5")
    public ApiResponse<People> get5(@RequestBody People name) {

        return success(HttpStatus.ACCEPTED, name);
    }


    public void test(){
        System.gc();
    }



    @RequestMapping("/get3/{name}")
    public ApiResponse<Void> get3(@PathVariable("name") String name) {
        System.out.println(name);
        return success();
    }


    @RequestMapping("/get4")
    public ApiResponse<Page<String>> get4(){
        return success(new Page<String>(Arrays.asList("111","2222"), 1, 10, 10));
    }


     private synchronized Integer getX(){
         synchronized (MyController.class) {
             x++;
         }
//         if (x % 100==0) {
//             test();
//         }

         return x;
    }


}
@Data
class People{
    private String name;
    private String age;
}


class Singleton2 {


    Integer masg;

    public Singleton2(Integer masg) {
        this.masg = masg;
    }


    private static final Singleton2 SINGLETON_2;


    static {
        SINGLETON_2 = new Singleton2();
    }

    public Singleton2(){

    }



    public  Integer getMasg() {

            return this.masg;

    }



    public synchronized void  setMasg(Integer masg) {

            this.masg = masg;


    }



    public static synchronized Singleton2 getInstance(Integer msg){
        synchronized (msg) {
            SINGLETON_2.setMasg(msg);
        }
        return SINGLETON_2;
    }
}


class DoubleCheckSingleton {

    // 保证可见性
    private static volatile DoubleCheckSingleton instance;




    private DoubleCheckSingleton(){

    }

    public static DoubleCheckSingleton getInstance(){

        if (null == instance) {
            synchronized (DoubleCheckSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }

        return instance;
    }

}

class Singleton {
    //3.构造方法私有化
    private Singleton(){}


    private String name;

    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // 1.写一个静态内部类
    private static class SingletonInstance{
        private static final Singleton singleton = new Singleton();
    }

    // 2.实现加载
    public static Singleton getInstance(String name, Date date) {
        Singleton singleton = SingletonInstance.singleton;

        singleton.setDate(date);

        singleton.setName(name);
        return singleton;
    }

}


class PrototyptBean{

    private String name;

    private Date date;


    public PrototyptBean(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PrototyptBean(){}
}