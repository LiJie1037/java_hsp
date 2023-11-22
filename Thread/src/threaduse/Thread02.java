package threaduse;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 13:34
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);    // 代理模式
        thread.start();
    }
}

class Dog implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while(true) {
            System.out.println("小狗汪汪叫 " + (++count) + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                e.printStackTrace();
            }
        }
    }
}