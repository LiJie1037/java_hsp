import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 17:26
 */
public class MyPanel extends JPanel implements KeyListener, Runnable{
    private Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemySize = 8;

    // 子弹击中tank时，增加Bomb对象
    Vector<Bomb> bombs = new Vector<>();

    // 定义三张图片，显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(int key) {

        File file = new File(Recorder.getRecordFile());
        if (!file.exists()) {
            key = 0;
        }

        switch (key) {
            case 0:// 新游戏
                // 初始化Recorder
                Recorder.setEnemyTanks(enemyTanks);

                // 初始化hero
                hero = new Hero(500, 500, 0);

                // 初始化enemyTank
                for (int i = 0; i < enemySize; i++) {
                    EnemyTank enemyTank = new EnemyTank(80 * i, 0, 2);
                    enemyTank.setEnemyTanks(enemyTanks);
                    new Thread(enemyTank).start();

                    // 初始化enemyTank的子弹
                    for (int j = 0; j < enemyTank.bulletSize; j++) {
                        Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                        enemyTank.bullets.add(bullet);
                        new Thread(bullet).start();
                    }

                    enemyTanks.add(enemyTank);
                }
                break;
            case 1:// 继续
                Recorder.setEnemyTanks(enemyTanks);

                hero = new Hero(500, 500, 0);


                // read recorderInfo并赋给enemyTanks
                enemyTanks = Recorder.loadRecorder(enemyTanks);
                // 初始化enemyTank
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    System.out.println((i+1) + " " + enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect());
                    enemyTank.setEnemyTanks(enemyTanks);
                    new Thread(enemyTank).start();

                    // 初始化enemyTank的子弹
                    for (int j = 0; j < enemyTank.bulletSize; j++) {
                        Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                        enemyTank.bullets.add(bullet);
                        new Thread(bullet).start();
                    }

                }
                break;
        }

        // 初始化Image
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("./bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("./bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("./bomb_3.gif"));

        // 播放音频
        new AePlayWave("./src./111.wav").start();
    }

    public void showInfo(Graphics g) {
        g.setFont(new Font("宋体", Font.BOLD, 25));
        g.drawString("您累积击毁敌方坦克：", MyFrame.width + 20, 30);

        drawTank(MyFrame.width + 20, 50, g, 1, 0);
        g.setColor(Color.black);
        g.drawString(String.valueOf(Recorder.getHitCount()), MyFrame.width + 100, 90);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, MyFrame.width, MyFrame.height);

        showInfo(g);

        // 画hero
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, 0, hero.getDirect());
        }

        // 画hero所有bullet
        for (int i = 0; i < hero.bullets.size(); i++) {
            Bullet bullet = hero.bullets.get(i);
            if (bullet != null && bullet.isLive) {
                drawBullet(bullet, g);
            } else {
                hero.bullets.remove(bullet);
            }
        }

        // 画所有enemyTank和子弹
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                // 画enemyTank
                drawTank(enemyTank.getX(), enemyTank.getY(), g, 1, enemyTank.getDirect());
                // 画子弹
                for (int j = 0; j < enemyTank.bullets.size(); j++) {
                    Bullet bullet = enemyTank.bullets.get(j);
                    if (bullet != null && bullet.isLive) {
                        drawBullet(bullet, g);
                    } else {
                        enemyTank.bullets.remove(bullet);
                    }
                }
            }
        }

        // 画出bomb效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 40, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 40, this);
            } else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 40, this);
            }

            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
    }

    public void drawTank(int x, int y, Graphics g, int type, int direct) {
        switch (type) {
            case 0: // hero
                g.setColor(Color.yellow);
                break;
            case 1:
                g.setColor(Color.cyan);
                break;
        }

        switch (direct) {
            case 0: // up
                g.fill3DRect(x, y, 10, 60, false);  // left wheel
                g.fill3DRect(x + 30, y, 10, 60, false); // right wheel
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);// 画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);// barrel
                break;
            case 1: // right
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: // down
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: // left
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    public void drawBullet(Bullet bullet, Graphics g) {
        g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
    }

//    public void drawBullets(Tank tank, Graphics g) {
//        for (int i = 0; i < tank.bullets.size(); i++) {
//            Bullet bullet = tank.bullets.get(i);
//            if (bullet != null && bullet.isLive) {
//                drawBullet(bullet, g);
//            } else {
//                hero.bullets.remove(bullet);
//            }
//        }
//    }

    public void hitTanks(Bullet bullet, Tank tank) {
        switch(tank.getDirect()) {
            case 0:
            case 2:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 40
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 60) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    enemyTanks.remove(tank);
                    if (tank instanceof EnemyTank) {
                        Recorder.addHitCount();
                    }
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
                    if (tank instanceof EnemyTank) {
                        Recorder.addHitCount();
                    }
                }
                break;
        }
    }

    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.bullets.size(); j++) {
                Bullet bullet = enemyTank.bullets.get(j);
                if (bullet != null && bullet.isLive && hero.isLive) {
                    hitTanks(bullet, hero);
                }
            }
        }
    }

    public void hitEnemyTank() {
        for (int i = 0; i < hero.bullets.size(); i++) {
            Bullet bullet = hero.bullets.get(i);
            if (bullet != null & bullet.isLive) {
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTanks(bullet, enemyTank);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            hero.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.fire();
        }
        
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void run() {
        //每隔 100毫秒，重绘区域, 刷新绘图区域, 子弹就移动
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            hitHero();
            hitEnemyTank();

            this.repaint();
        }
    }
}
