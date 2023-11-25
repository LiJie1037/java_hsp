package tankgame4;

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
public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;

    Vector<EnemyTank> enemyTanks = new Vector<>();

    int enemySize = 3;
    // 当子弹击中坦克时，增加bomb
    Vector<Bomb> bombs = new Vector<>();

    // 定义三张图片，显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {

        // 初始化hero坦克
        hero = new Hero(100, 100);

        // 初始化敌方坦克及子弹
        for (int i = 0; i < enemySize; i++) {
            // 创建坦克对象
            EnemyTank enemyTank = new EnemyTank(150 * (i + 1), 0);
            enemyTank.setDirect(2);

            // 创建敌方坦克线程
            new Thread(enemyTank).start();

            // 创建敌方坦克子弹对象
            for (int j = 0; j < enemyTank.bulletSize; j++) {
                Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                enemyTank.bullets.add(bullet);
                new Thread(bullet).start();
            }
//            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
//            enemyTank.bullets.add(bullet);
//            new Thread(bullet).start();
            enemyTanks.add(enemyTank);
        }

        // 初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, TankJFrame04.width, TankJFrame04.height);

        // 画hero坦克
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }

        //        // 画hero单颗子弹
//        if (hero.bullet != null && hero.bullet.isLive) {
//            g.draw3DRect(hero.bullet.getX(), hero.bullet.getY(), 2, 2, false);
//        }
        // 画hero所有子弹
        for (int i = 0; i < hero.heroBullets.size(); i++) {
            Bullet bullet = hero.heroBullets.get(i);
            if (bullet != null && bullet.isLive) {
                g.draw3DRect(bullet.getX(), bullet.getY(), 2, 2, false);
            } else {
                hero.heroBullets.remove(bullet);
            }
        }

        // 画敌方坦克及其所有子弹
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            // 当坦克存活时，画出坦克
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                // 画出敌方坦克的所有子弹
                for (int j = 0; j < enemyTank.bullets.size(); j++) {
                    Bullet bullet = enemyTank.bullets.get(j);
                    if (bullet.isLive) {
                        g.draw3DRect(bullet.getX(), bullet.getY(), 2, 2, false);
                    } else {
                        enemyTank.bullets.remove(bullet);
                    }
                }
            }
        }

        // 画bomb效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }

            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
    }

    // 画坦克封装方法
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

    // 击中hero坦克判定
    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            // 取出所有坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.bullets.size(); j++) {
                // 取出所有子弹
                Bullet bullet = enemyTank.bullets.get(j);
                if (bullet != null && bullet.isLive) {
                    hitTanks(bullet, hero);
                }
            }
        }
    }

    // 击中enemyTank坦克判定
    public void hitEnemy() {
        // 遍历hero所有的子弹
        for (int i = 0; i < hero.heroBullets.size(); i++) {
            Bullet bullet = hero.heroBullets.get(i);
            // 当子弹非空且存活
            if (bullet != null && bullet.isLive) {
                // 遍历所有enemyTank
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTanks(bullet, enemyTank);
                }
            }
        }
    }

    public void hitTanks(Bullet bullet, Tank tank) {
        switch (tank.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 40
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 60) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    enemyTanks.remove(tank);
                }
                break;
            case 1:
            case 3:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 60
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 40) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    enemyTanks.remove(tank);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

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

        if ((char)e.getKeyCode()  == KeyEvent.VK_J) {

//            // 单颗子弹
//            if (hero.bullet == null || !hero.bullet.isLive) {
//                hero.fire();
//            }

            hero.fire();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            hitEnemy();
            hitHero();

            this.repaint();
        }
    }
}
