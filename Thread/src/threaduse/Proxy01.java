package threaduse;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/22 13:57
 */
public class Proxy01 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ProxyThread proxyThread = new ProxyThread(tiger);
        proxyThread.start();
    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫");
    }
}

class ProxyThread implements Runnable {
    private Runnable target = null;

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public ProxyThread(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();
    }

    public void start0() {
        run();
    }
}