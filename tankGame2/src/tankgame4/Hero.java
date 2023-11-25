package tankgame4;

import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 20:56
 */
public class Hero extends Tank {
    public Bullet bullet = null;
    Vector<Bullet> heroBullets = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public void fire() {

        if (heroBullets.size() == 5) {
            return;
        }

        switch (getDirect()) {
            case 0: //向上
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1: //向右
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2: //向下
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3: //向左
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }
        heroBullets.add(bullet);
        new Thread(bullet).start();
    }

}
