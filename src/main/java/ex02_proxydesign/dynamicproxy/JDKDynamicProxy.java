package ex02_proxydesign.dynamicproxy;

import ex02_proxydesign.ProxyAble;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements ProxyAble {
    public void doSomething() {
        System.out.println("JDKDynamicProxy execute doSomething method");
    }
}

class JdkMainClass {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        ProxyAble proxy = (ProxyAble)Proxy.newProxyInstance(ProxyAble.class.getClassLoader(),
                new Class[]{ProxyAble.class},
                new LogInvocationHandle(new JDKDynamicProxy()));
        proxy.doSomething();
    }
}

class LogInvocationHandle implements InvocationHandler {
    ProxyAble proxyAble;

    public LogInvocationHandle(ProxyAble proxyAble){
        this.proxyAble = proxyAble;
    }

    public void before(){
        System.out.println("log before");
    }

    public void after(){
        System.out.println("log after");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(proxyAble, args);
        after();
        System.out.println("invoke 调用返回结果: " + invoke);
        return invoke;
    }
}


