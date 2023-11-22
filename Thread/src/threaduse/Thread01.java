package threaduse;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 12:45
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();  // 启动线程
//        cat.run();  // run方法是一个普通方法，没有启动线程，会执行run方法
        System.out.println("主线程继续执行" + Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 i = " + i);
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
//        super.run();
        while (true) {
            System.out.println("喵喵,我是小猫" + (++times) + Thread.currentThread().getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
//            throw new RuntimeException(e);
                e.printStackTrace();
            }
            if (times == 20) {
                break;
            }
        }
    }
}