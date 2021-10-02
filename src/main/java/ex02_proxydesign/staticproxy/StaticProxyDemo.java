package ex02_proxydesign.staticproxy;

import ex02_proxydesign.ProxyAble;

public class StaticProxyDemo implements ProxyAble {
    public void doSomething() {
        System.out.println("StaticProxyDemo execute method doSomething");
    }
}

//现在我想对这个类进行静态代理，代理的本质就是对功能进行增强
class StaticProxyDemoProxy implements ProxyAble{
    //慎用继承，采用组合的方式进行编码，防止类爆炸
    private ProxyAble proxyAble;

    void before() {
        System.out.println("before");
    }

    void after(){
        System.out.println("after");
    }

    public void doSomething() {
        before();
        proxyAble.doSomething();
        after();
    }
}

