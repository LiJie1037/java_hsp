package threaduse;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 14:04
 */
public class Thread03 {
    public static void main(String[] args) {
//        T3 t3 = new T3();
//        T4 t4 = new T4();
//        Thread thread = new Thread(t3);
//        thread.start();
//        Thread thread1 = new Thread(t4);
//        thread1.start();

//        new Thread(new T4()).start();

        T1 t1 = new T1();
        t1.start();
    }
}

class T1 extends Thread {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello world" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }
    }
}

class T3 implements Runnable {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello world" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }
    }
}

class T4 implements Runnable {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 5) {
                break;
            }
        }
    }
}