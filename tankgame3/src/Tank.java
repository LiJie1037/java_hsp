import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 17:22
 */
public class Tank {
    private int x;
    private int y;
    // 0:up 1: right 2:down 3:left
    private int direct;
    boolean isLive = true;
    private int speed = 5;

    public Bullet bullet = null;
    Vector<Bullet> bullets = new Vector<>();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Tank(int x, int y, int direct) {
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

    public void moveUp() {
        if (y - speed >= 0) {
            y -= speed;
        }
    }

    public void moveRight() {
        if (x + speed <= MyFrame.width - 60) {
            x += speed;
        }
    }

    public void moveDown() {
        if (y + speed <= MyFrame.height - 60) {
            y += speed;
        }
    }

    public void moveLeft() {
        if (x - speed >= 0) {
            x -= speed;
        }
    }

}
