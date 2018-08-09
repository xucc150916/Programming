/**
 * 主线程走十次，子线程走五次，重复三次
 */

class Child {

    private boolean flag = false;

    public synchronized void mainMethod() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i < 11; i++) {
            System.out.println("main method times: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = !flag;
        notify();

    }

    public synchronized void childMethod() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i < 6; i++) {
            System.out.println("child method times: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        flag = !flag;
        notify();
    }

}

public class ThredDemo {

    public static void main(String[] args) {
        Child child = new Child();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    child.mainMethod();
                }
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            child.childMethod();
        }

    }


}
