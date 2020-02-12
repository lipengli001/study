package com.mall.common.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 是用lock锁实现三个线程轮流打印ABC
 */
public class LockThread {

    private int once;

    private static Lock lock = new ReentrantLock();

    public LockThread (int once) {
        this.once = once;
    }

    public void print (Condition pre, Condition cur) {
        for (int i = 0; i < once; i++) {
            try {
                lock.lock();
                cur.signal();
                System.out.println(Thread.currentThread().getName());
                pre.await();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main (String[] args) {
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();

        LockThread thread = new LockThread(10);

        new Thread(() -> {
            thread.print(c, a);
        }, "A").start();
        new Thread(() -> {
            thread.print(a, b);
        }, "B").start();
        new Thread(() -> {
            thread.print(b, c);
        }, "C").start();
    }

}
