import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 22:48
 */
public class EnemyTank extends Tank{
    Vector<Bullet> bullets = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
