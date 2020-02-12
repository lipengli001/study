package com.mall.common.thread;

/**
 * 使用synchronized实现，三个线程轮流打印ABC
 * 先尝试获取上一个锁，获取到了，说明上一个执行完毕，已经释放了。获取不到，说明还未执行完毕。
 * notify()唤醒等待获取该对象锁的随机的一个线程。
 * wait()使该线程进入等待，直到另一个线程调用此对象的notify或者notufyAll
 * 两个方法都是谁调用操作谁
 */
public class SynThread {

    private int once;

    public SynThread (int once) {
        this.once = once;
    }

    public void print (Object pre, Object cur) {
        for (int i = 0; i < once; i++) {
            synchronized (pre) {
                synchronized (cur) {
                    System.out.println(Thread.currentThread().getName());
                    cur.notify();
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main (String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        SynThread thread = new SynThread(10);
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
