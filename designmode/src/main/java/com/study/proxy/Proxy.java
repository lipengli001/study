package com.study.proxy;

/**
 *
 */
public class Proxy implements Subject {

    private RelaSubject relaSubject;

    public void request () {
        if (null == relaSubject) {
            relaSubject = new RelaSubject();
        }

        preRequest();
        relaSubject.request();
        postRequest();
    }

    public void preRequest () {
        System.out.println("访问真实主题之前的预处理。");
    }

    public void postRequest () {
        System.out.println("访问真实主题之后的后续处理。");
    }

}
