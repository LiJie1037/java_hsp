package draw;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 20:19
 */
public class DrawCircle extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        // 初始化面板
        mp = new MyPanel();
        // 把面板添加进JFrame
        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("调用画笔");
//        g.drawOval(10, 10, 100, 100);

        g.setColor(Color.cyan);
        //演示绘制不同的图形
        //画直线 drawLine(int x1,int y1,int x2,int y2)
        //g.drawLine(10, 10, 100, 100);
        //画矩形边框 drawRect(int x, int y, int width, int height)
        //g.drawRect(10, 10, 100, 100);
        //画椭圆边框 drawOval(int x, int y, int width, int height)
        //填充矩形 fillRect(int x, int y, int width, int height)
        //设置画笔的颜色
//        g.setColor(Color.blue);
//        g.fillRect(10, 10, 100, 100);

        //填充椭圆 fillOval(int x, int y, int width, int height)
//        g.setColor(Color.red);
//        g.fillOval(10, 10, 100, 100);

        //画图片 drawImage(Image img, int x, int y, ..)
        //1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bg.png"));
        g.drawImage(image, 10, 10, 175, 221, this);
        //画字符串 drawString(String str, int x, int y)//写字
        //给画笔设置颜色和字体
//        g.setColor(Color.red);
//        g.setFont(new Font("楷书", Font.BOLD, 20));
        g.setFont(new Font("隶书", Font.BOLD, 50));
        //这里设置的 100， 100， 是 "北京你好"左下角
        g.drawString("北京你好", 100, 100);
        //设置画笔的字体 setFont(Font font)
        //设置画笔的颜色 setColor(Color c)
    }
}
