package com.mall.common.pool;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义线程池
 */
public class MyThreadPool {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main (String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        //获取当前机器线程数
        /*System.out.println(Runtime.getRuntime().availableProcessors());
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回值！");
        });
        System.out.println(future.get());

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> submit = service.submit(() -> {
            return "abc";
        });*/
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.getAndIncrement();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(atomicInteger.get());
    }

}
