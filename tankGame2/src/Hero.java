/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 20:56
 */
public class Hero extends Tank {
    public Bullet bullet = null;

    public Hero(int x, int y, Bullet bullet) {
        super(x, y);
        this.bullet = bullet;
    }

    public void fire() {
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

        new Thread(bullet).start();
    }


}
