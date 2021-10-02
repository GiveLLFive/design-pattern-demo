package ex01_singletondesign;

/**
 * 懒加载
 * 优点：在实例第一次被调用的过程中才会进行实例化，不会产生内存浪费
 * 缺点：需要通过枷锁保证线程安全问题，会消耗一定的效率
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){}

    public synchronized LazySingleton getInstance(){
        if (null == instance) {
            return new LazySingleton();
        }
        return instance;
    }

}
