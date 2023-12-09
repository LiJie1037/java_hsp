import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/9 14:05
 */

@SuppressWarnings({"all"})
public class HorseChessBoard {
    private static int X = 6;   // col
    private static int Y = 6;   // row

    private static int[][] chessBoard = new int[Y][X];  // 棋盘,0 表示走不通, 其他表示第 step 步
    private static boolean[] visited = new boolean[Y * X]; // 便是棋盘的位置被访问了
    private static boolean finished = false;    // 棋盘是否走通

    public static void main(String[] args) {

        int col = 5;
        int row = 4;

        long start = System.currentTimeMillis();
        transHorse(chessBoard, row, col, 1);
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));


        // 输出棋盘
        for (int[] rows : chessBoard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }


    }

    // 移动 Horse, 并记录是第 step 步
    public static void transHorse(int[][] chessBoard, int row, int col, int step) {
        chessBoard[row][col] = step;

        visited[row * X + col] = true;

        // 计算当前点(row, col) 下一步可走的位置
        ArrayList<Point> ps = next(new Point(col, row));
        sort(ps);

        while (!ps.isEmpty()) {
            // 取出一个可走的点
            Point p = ps.remove(0);

            // 判断点 p 是否被走过
            if (!visited[p.y * X + p.x]) { // 没有走过,就递归开始走
                transHorse(chessBoard, p.y, p.x, step+1);
            }
        }
        // 判断是否走完
        if (step < X * Y && !finished) {// 没有走完
            // 重置
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }

    // 对ps的各个位置 的 下一个可能的位置次数进行排序,从小到大
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }

    /*
      --------------------- X
      |  0	0	2	0	3	0
      |  0	1	0	0	0	4
      |  0	0	0	P	0	0
      |  0	8	0	0	0	5
      |  0	0	7	0	6	0
      |  0	0	0	0	0	0
      Y
    */
    // 根据当前点 curPoint 返回能走的位置 从1-8遍历判断
    public static ArrayList<Point> next(Point curPoint) {
        // 创建list 接收能走的位置
        ArrayList<Point> ps = new ArrayList<>();

        // 创建一个临时点
        Point p = new Point();

        // 判断1位置
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        // 判断2位置
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }
        // 判断3位置
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }
        // 判断4位置
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        // 判断5位置
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        // 判断6位置
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        // 判断7位置
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        // 判断8位置
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }

        return ps;
    }


}
