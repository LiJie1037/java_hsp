package tankgame4;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 20:54
 */
public class Tank {
    private int x;
    private int y;  // 坦克左上角坐标
    private int direct; // direct 表示坦克方向(0:向上 1:向右 2:向下 3:向左 )
    private int speed = 4;  // 坦克速度
    boolean isLive = true;  // 坦克存活状态

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // 上下左右移动
    public void moveUp() {
        if (y - speed >= 0) {
            y -= speed;
        }
    }

    public void moveDown() {
        if (y + speed <= TankJFrame04.height - 60) {
            y += speed;
        }
    }
    public void moveLeft() {
        if (x - speed >= 0) {
            x -= speed;
        }
    }
    public void moveRight() {
        if (x + speed <= TankJFrame04.width - 60) {
            x += speed;
        }
    }
}
