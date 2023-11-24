/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/23 10:58
 */
public class Bullet implements Runnable{
    private int x;
    private int y;
    private int direct;
    private int speed = 5;
    boolean isLive = true;

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    //direct 表示方向(0:向上 1:向右 2:向下 3:向左 )
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (direct) {
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

            System.out.printf("子弹坐标%d, %d\n", x, y);

            // 当子弹在出界 或 子弹碰撞时，子弹销毁
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 800 && isLive) ) {
                isLive = false;
                break;
            }
        }
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
}
