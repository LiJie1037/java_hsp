import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 17:24
 */
public class MyFrame extends JFrame {
    private MyPanel mp;
    static int width = 800;
    static int height = 700;


    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame() throws HeadlessException {
        this.setSize(width + 350, height + 40);

        System.out.println("新游戏还是继续(0:新游戏 1:继续)：");
        int key = scanner.nextInt();

        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                System.out.println("监听到关闭窗口");
                Recorder.saveRecorder();
                System.exit(0);
//                super.windowClosing(e);
            }
        });
    }
}
