package com.elisonwell.proxy.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarHandler implements InvocationHandler {
    private ICar car;

    public CarHandler(ICar car) {
        this.car = car;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy class:"+proxy.getClass());
        System.out.println("proxy method:"+method.getName());
        method.invoke(car,args);
        return null;
    }
}
