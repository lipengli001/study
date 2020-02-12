package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class DynamixProxy implements InvocationHandler {

    //private Object obj;

    public DynamixProxy () {
    }

    /*public DynamixProxy (Object obj) {
        this.obj = obj;
        //return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }*/

    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是前置动态代理");
        Object invoke = method.invoke(proxy, args);
        System.out.println("我是后置动态代理");
        return invoke;
    }

}
