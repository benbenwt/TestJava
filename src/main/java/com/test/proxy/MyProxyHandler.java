package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

public class MyProxyHandler implements InvocationHandler {
    private Object object;
    public MyProxyHandler(Object object){
        this.object= object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before proxy"+method.getName());
        method.invoke(object,args);
        System.out.println("after proxy"+method.getName());
        return null;
    }

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        NowTime nowTime = new NowTime();

        InvocationHandler handler = new MyProxyHandler(nowTime);

        NowTimeInterface proxyHello = (NowTimeInterface) Proxy.newProxyInstance(nowTime.getClass().getClassLoader(), nowTime.getClass().getInterfaces(), handler);

        proxyHello.printTime();

        Integer i;
        String s;
    }
}
