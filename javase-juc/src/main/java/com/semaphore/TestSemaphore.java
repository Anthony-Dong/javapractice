package com.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @date:2019/10/25 18:03
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestSemaphore {


    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(2,false);
        System.out.println("----------Semaphore-----------");

        int i = 1;

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  开始");
            try {
                System.out.println(semaphore.availablePermits());
                semaphore.acquireUninterruptibly(2);
                System.out.println(Thread.currentThread().getName() + "  获取许可证");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "  等待完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "  释放许可证");
                semaphore.release(2);
            }
            System.out.println(Thread.currentThread().getName() + "  结束");
        }, "thread" + (i++));

        thread.start();


        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  开始");
            try {
                System.out.println(semaphore.availablePermits());
                semaphore.acquireUninterruptibly(2);
                System.out.println(Thread.currentThread().getName() + "  获取许可证");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "  等待完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "  释放许可证");
                semaphore.release(2);
            }
            System.out.println(Thread.currentThread().getName() + "  结束");
        }, "thread" + (i++));


        thread1.start();

        thread.join();

        thread1.join();





    }

}

//                    semaphore.acquire(); // 一次拿一个许可证
//                    semaphore.acquireUninterruptibly(5);  //需要 5个 许可证才能执行
