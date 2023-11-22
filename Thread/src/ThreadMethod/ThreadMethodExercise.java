package ThreadMethod;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 15:28
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Sub());
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi" + i);
            Thread.sleep(100);
            if (i == 5) {
                thread.start();
                thread.join();
            }
        }
        System.out.println("主线程结束");
    }
}

class Sub implements Runnable {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello" + (++count));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                System.out.println("子线程结束");
                break;
            }
        }
    }
}