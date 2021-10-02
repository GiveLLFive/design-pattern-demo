package ex03_observe.v2;

public class InvokeChildWakeUp {

    public static void main(String[] args) throws InterruptedException {
        Child child = Child.getInstance();
        System.out.println(child.hashCode());
        child.wakeUp();
        Thread.sleep(100000);
    }

}
