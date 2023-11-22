package event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 21:35
 */
public class BallMove extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove();
        System.out.println("结束");
    }

    public BallMove() throws HeadlessException {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(500, 300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}

class MyPanel extends JPanel implements KeyListener {
    // MyPanel相当于事件监听器接口
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 相当于事件，保存事件源(键盘)的状态改变，比如键盘的code值
        if ((char)e.getKeyCode()  == KeyEvent.VK_DOWN) {
            y++;
        }else if ((char)e.getKeyCode()  == KeyEvent.VK_UP) {
            y--;
        }else if ((char)e.getKeyCode()  == KeyEvent.VK_LEFT) {
            x--;
        }else if ((char)e.getKeyCode()  == KeyEvent.VK_RIGHT) {
            x++;
        }
//        System.out.println((char)e.getKeyCode() + "被按下");
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

//        System.out.println((char)e.getKeyCode() + "被释放");
    }
}