package threadlocal_test;

import java.util.UUID;

/**
 * TODO
 *
 * @date:2019/9/28 14:32
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestThread {

    private ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();

    private ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();


    public void set() {
        System.out.println("---"+Thread.currentThread().getId());
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(UUID.randomUUID().toString());
    }

    public long getLong() {
        return longThreadLocal.get();
    }

    public String getString() {
        return stringThreadLocal.get();
    }

    public void remove(){
        stringThreadLocal.remove();
        longThreadLocal.remove();
    }

    public static void main(String[] args) {

        TestThread testThread = new TestThread();

        testThread.set();

        System.out.println(testThread.getLong() + "----" + testThread.getString());


        new Thread(() -> {
            testThread.set();
            System.out.println(testThread.getLong());
        }).start();

        new Thread(() -> {
            System.out.println("--------------");
            testThread.set();
            System.out.println(testThread.getString());
            testThread.set();
            System.out.println(testThread.getString());
            testThread.remove();
            System.out.println(testThread.getString());
            System.out.println("--------------");
        }).start();

        new Thread(() -> {
                testThread.set();
            System.out.println(testThread.getLong());
        }).start();
    }

}
