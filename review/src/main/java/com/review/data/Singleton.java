package com.review.data;

/**
 *
 */
public class Singleton {

    private volatile static Singleton instance;

    public static Singleton getInstance () {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        Thread thread = new Thread();
        try {
            thread.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }

    private Singleton () {
    }

    public static void main (String[] args) {
        Singleton.getInstance();
    }

}
