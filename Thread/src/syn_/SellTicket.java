package syn_;

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

    }
}

class SellWindow extends Thread {
    static int tickets = 50;
    private boolean loop = true;

    public synchronized void sell() {
        if (tickets <= 0) {
            System.out.println("售票结束");
            loop = false;
            return;
        }
        System.out.println("售票,还剩余票" + (--tickets));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}


class SellWindowR implements Runnable {
    static int tickets = 50;
    private boolean loop = true;

    public synchronized void sell() {
        if (tickets <= 0) {
            System.out.println("售票结束");
            loop = false;
            return;
        }
        System.out.println("售票,还剩余票" + (--tickets));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}