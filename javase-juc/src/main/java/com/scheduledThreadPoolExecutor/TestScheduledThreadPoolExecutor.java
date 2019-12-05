package com.scheduledThreadPoolExecutor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @date:2019/11/10 12:46
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestScheduledThreadPoolExecutor {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

        //默认情况下，这样一个被取消的任务在延迟过期之前不会自动从工作队列中删除。虽然这可以进行进一步的检查和监视，但也可能导致取消的任务被无限保留。
        // 为了避免这种情况，将setRemoveOnCancelPolicy设置为true，这会导致在取消时立即将任务从工作队列中删除。
        executor.setRemoveOnCancelPolicy(true);



        ScheduledFuture<?> future = executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("安星是个大傻啊 , " + System.currentTimeMillis() + " , " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 100, TimeUnit.MILLISECONDS);




    }


}
