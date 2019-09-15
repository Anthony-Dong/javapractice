package com.thread_question;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadInfo;
import com.sun.management.ThreadMXBean;

/**
 * 关于线程信息的一些些东西
 *
 * @date:2019/9/10 15:10
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class AllThreadStackQuestion {


    public static void main(String[] args) {
        ThreadMXBean threadMXBean = (ThreadMXBean)ManagementFactory.getThreadMXBean();

        long[] allThreadIds = threadMXBean.getAllThreadIds();

        for (long allThreadId : allThreadIds) {

//            System.out.println(allThreadId);

            ThreadInfo threadInfo =
                    threadMXBean.getThreadInfo(allThreadId);
            System.out.println(threadInfo);

            long threadAllocatedBytes = threadMXBean.getThreadAllocatedBytes(allThreadId);


            System.out.printf("线程id[%d]: %s kb\n",allThreadId,threadAllocatedBytes / 1024);
        }
    }



}


