package tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 20:57
 */
public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemySize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);
        hero.setSpeed(4);

        for (int i = 0; i < enemySize; i++) {
            EnemyTank enemyTank = new EnemyTank(200 * (i + 1), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 800);
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);

        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        }

    }

    //direct 表示方向(0:向上 1:向右 2:向下 3:向左 )
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0://hero我们的坦克
                g.setColor(Color.yellow);
                break;
            case 1://Tank敌人的坦克
                g.setColor(Color.cyan);
                break;
        }

        // 根据坦克方向来画坦克
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if ((char)e.getKeyCode()  == KeyEvent.VK_DOWN) {
            hero.setDirect(2);
            hero.moveDown();
        }else if ((char)e.getKeyCode()  == KeyEvent.VK_UP) {
            hero.setDirect(0);
            hero.moveUp();
        }else if ((char)e.getKeyCode()  == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            hero.moveLeft();
        }else if ((char)e.getKeyCode()  == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            hero.moveRight();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
