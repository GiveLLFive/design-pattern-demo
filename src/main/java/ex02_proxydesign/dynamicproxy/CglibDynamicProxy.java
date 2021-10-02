package ex02_proxydesign.dynamicproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class CglibDynamicProxy {

    static void doSomething(){
        System.out.println("CglibDynamicProxy execute doSomething method");
    }

}

class CglibMainClass{

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/lilei/Documents");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibDynamicProxy.class);
        enhancer.setCallback(new LogMethodInterceptor());

        CglibDynamicProxy proxy = (CglibDynamicProxy)enhancer.create();
        proxy.doSomething();
    }
}

class LogMethodInterceptor implements MethodInterceptor {
    public void before(){
        System.out.println("log before");
    }

    public void after(){
        System.out.println("log after");
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        methodProxy.invokeSuper(o, objects);
        after();
        return null;
    }
}
