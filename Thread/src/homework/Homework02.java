package homework;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 17:22
 */
public class Homework02 {
    public static void main(String[] args) {
        Money money = new Money();
        Thread t1 = new Thread(money);
        t1.setName("t1");
        Thread t2 = new Thread(money);
        t2.setName("t2");

        t1.start();
        t2.start();

    }
}

class Money implements Runnable {
    private static int balance = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {//
                //判断余额是否够
                if (balance < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                balance -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取出了1000 当前余额=" + balance);
            }

            //休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}