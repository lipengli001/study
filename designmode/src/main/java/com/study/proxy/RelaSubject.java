package com.study.proxy;

/**
 * 真实主题
 */
public class RelaSubject implements Subject {

    public void request () {
        System.out.println("访问真实主题的方法");
    }

}
