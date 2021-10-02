package ex03_observe.v2;

public class Main {

    public static void main(String[] args) {
        Child child = Child.getInstance();
        System.out.println(child.hashCode());
        while (child.isCry() == 1) {
            try {
                Thread.sleep(1000);
                System.out.println(child.isCry());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + ": observing...");
        }
    }

}



