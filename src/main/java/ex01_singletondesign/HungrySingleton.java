package ex01_singletondesign;

/**
 * 饿汉式
 * 优点：在类加载阶段就完成了实例化，不需要考虑线程安全问题，就不会有加锁性能损耗问题
 * 缺点：由于在类加载阶段就完成了实例化，会产生内存浪费问题
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    //私有构造方法，防止构造
    private HungrySingleton(){}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
