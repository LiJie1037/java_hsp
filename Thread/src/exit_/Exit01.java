package exit_;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 15:06
 */
public class Exit01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        Thread.sleep(5 * 1000);
        t.setLoop(false);
    }
}

class T extends Thread {
    int times = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            System.out.println("正在运行" + (++times) + Thread.currentThread().getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}