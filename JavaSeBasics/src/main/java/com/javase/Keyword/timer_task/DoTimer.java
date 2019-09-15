package com.javase.Keyword.timer_task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO
 *
 * @date:2019/9/7 21:42
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DoTimer {
    public static void main(String[] args) {

        Integer cacheTime = 1000;
        Timer timer = new Timer();
        // (TimerTask task, long delay, long period)任务，延迟时间，多久执行
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 1000, cacheTime);
    }

}
