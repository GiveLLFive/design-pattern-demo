package ex03_observe.v2;

public class Child {
    private static volatile Child instance = null;
    private Child(){}
    public static Child getInstance(){
        if(instance == null){
            synchronized(Child.class){
                if(instance == null){
                    instance = new Child();
                }
            }
        }
        return instance;
    }


    private volatile int isCry = 1;

    public int isCry() {
        return isCry;
    }

    public void setCry(int cry) {
        isCry = cry;
    }

    public void wakeUp() {
        System.out.println(Thread.currentThread().getId() + ": child wake up, wuwuwu...");
        synchronized (this) {
            setCry(0);
        }
    }
}
