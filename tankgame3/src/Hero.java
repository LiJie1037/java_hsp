import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 17:45
 */
public class Hero extends Tank {
    public Bullet bullet = null;
    Vector<Bullet> bullets = new Vector<>();

    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }

    public void fire() {
        if (bullets.size() == 3) {
            return;
        }

        //根据方向创建 bullet 对象
        switch (getDirect()) {
            case 0:
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }

        bullets.add(bullet);
        new Thread(bullet).start();
    }

}
