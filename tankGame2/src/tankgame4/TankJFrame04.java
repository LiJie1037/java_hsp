package tankgame4;

import javax.swing.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 21:00
 */
public class TankJFrame04 extends JFrame {
    private MyPanel mp = null;
    static int width = 800;
    static int height = 600;

    public static void main(String[] args) {
        new TankJFrame04();
//        System.out.println("end");
    }

    public TankJFrame04() {
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.setSize(width + 20, height + 40);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
