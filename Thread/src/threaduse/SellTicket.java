package threaduse;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 14:25
 */
public class SellTicket {
    public static void main(String[] args) {
//        SellWindow sellWindow = new SellWindow();
//        SellWindow sellWindow1 = new SellWindow();
//        SellWindow sellWindow2 = new SellWindow();
//        sellWindow.start();
//        sellWindow1.start();
//        sellWindow2.start();

        SellWindowR sellWindowR = new SellWindowR();
        new Thread(sellWindowR).start();
        new Thread(sellWindowR).start();
        new Thread(sellWindowR).start();
        new Thread(sellWindowR).start();

    }
}

class SellWindow extends Thread {
    static int tickets = 50;

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0) {
                break;
            }
            System.out.println("售票,还剩余票" + (--tickets));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class SellWindowR implements Runnable {
    static int tickets = 50;

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0) {
                break;
            }
            System.out.println("售票,还剩余票" + (--tickets));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}