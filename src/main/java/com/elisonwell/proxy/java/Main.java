package com.elisonwell.proxy.java;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        ICar car = new Biyadi();
        CarHandler handler = new CarHandler(car);
        ICar proxy = (ICar) Proxy.newProxyInstance(handler.getClass().getClassLoader(),new Class[]{ICar.class},handler);
        proxy.move();
    }
}
