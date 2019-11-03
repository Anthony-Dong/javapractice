package com.semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 *
 * @date:2019/10/27 14:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class SemaphorePool {

    private static final int MAX_AVAILABLE = 100;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x))
            available.release();
    }

    protected static Object[] items = new Object[100];

    static {
        int count = 0;
        for (Object item : items) {
            item = ++count;
        }
    }

    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                System.out.println("item : "+item);
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphorePool semaphorePool = new SemaphorePool();
        Object item = semaphorePool.getItem();
        System.out.println(item);
        semaphorePool.putItem(item);
    }
}
