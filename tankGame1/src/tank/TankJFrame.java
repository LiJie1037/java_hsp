package tank;

import javax.swing.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 21:00
 */
public class TankJFrame extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {
        new TankJFrame();
        System.out.println("end");
    }

    public TankJFrame() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 800);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
