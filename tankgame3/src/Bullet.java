/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 18:41
 */
public class Bullet implements Runnable {
    private int x, y;
    private int direct = 0;
    public boolean isLive = true;
    int speed = 7;

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    @Override
    public void run() {
        // 子弹运动
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            // 子弹运动方向
            switch (getDirect()) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }

            // 子弹碰撞边界检测
            if (!(x >= 0 && x <= MyFrame.width
                    && y >= 0 && y <= MyFrame.height
                    && isLive)) {
                isLive = false;
                break;
            }
        }
    }
}
