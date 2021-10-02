package ex01_singletondesign;

/**
 * Double check 单例模式
 * 优点：1.在第一次使用的时候才会被初始化，不会产生内存浪费问题 2.性能安全
 * 缺点：1.由于需要加锁操作，会降低一定的效率
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton(){}

    public DoubleCheckSingleton getInstance(){
        if (null == instance) {
            synchronized (this) {
                if (null == instance) {
                    return new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
