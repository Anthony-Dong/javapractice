package com.scheduledThreadPoolExecutor;

import java.util.concurrent.*;

public class CustomScheduledExecutor extends ScheduledThreadPoolExecutor {

     class CustomTask<V> implements RunnableScheduledFuture<V> {

         @Override
         public boolean isPeriodic() {
             return false;
         }

         @Override
         public long getDelay(TimeUnit unit) {
             return 0;
         }

         @Override
         public int compareTo(Delayed o) {
             return 0;
         }


         @Override
         public void run() {

         }


         @Override
         public boolean cancel(boolean mayInterruptIfRunning) {
             return false;
         }


         @Override
         public boolean isCancelled() {
             return false;
         }


         @Override
         public boolean isDone() {
             return false;
         }


         @Override
         public V get() throws InterruptedException, ExecutionException {
             return null;
         }

         @Override
         public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
             return null;
         }
     }

    public CustomScheduledExecutor(int corePoolSize) {
        super(corePoolSize);
    }


    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        return super.decorateTask(runnable, task);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task) {
        return super.decorateTask(callable, task);
    }
}