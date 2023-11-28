package tankgame4;

import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 22:48
 */
public class EnemyTank extends Tank implements Runnable {
    Vector<Bullet> bullets = new Vector<>();
    int bulletSize = 3;
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            // 移动并改变方向
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            setDirect((int)(Math.random() * 4));    // 随机改变方向

            // 根据方向创建子弹对象
            if (isLive && bullets.size() < 5) {
                Bullet bullet = null;
                switch (getDirect()) {
                    case 0:
                        bullet = new Bullet(getX() + 20, getY(), getDirect());
                        break;
                    case 1:
                        bullet = new Bullet(getX() + 60, getY() + 20, getDirect());
                        break;
                    case 2:
                        bullet = new Bullet(getX() + 20, getY() + 60, getDirect());
                        break;
                    case 3:
                        bullet = new Bullet(getX(), getY() + 20, getDirect());
                        break;
                }
                bullets.add(bullet);
                new Thread(bullet).start();
            }

            // 如果坦克被击中，就停止
            if (!isLive) {
                break;
            }

        }
    }
}
