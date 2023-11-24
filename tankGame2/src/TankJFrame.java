import javax.swing.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 21:00
 */
public class TankJFrame extends JFrame {
    private MyPanel mp = null;
    private int width = 1000;
    private int height = 800;

    public static void main(String[] args) {
        new TankJFrame();
//        System.out.println("end");
    }

    public TankJFrame() {
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.setSize(width, height);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
