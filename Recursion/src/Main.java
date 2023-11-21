public class Main {
    public static void main(String[] args) {
        T test01 = new T();
        test01.test(5);
        test01.factorial(5);
        System.out.println(test01.factorial(5));    // 阶乘
        System.out.println(test01.Fabonacci(10));   // 斐波那契
        System.out.println(test01.peach(1));    // 吃桃子

        // 吃桃子
        int peachSum = 1;
        for (int i = 1; i < 10; i++) {
            peachSum = (peachSum + 1) * 2;
        }
        System.out.println(peachSum);

        // 迷宫
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[4][2] = 1;
        map[5][2] = 1;
        map[5][3] = 1;
        map[5][3] = 1;
        map[5][4] = 1;
        map[4][4] = 1;
        map[3][4] = 1;

        test01.labyrinth(map);
        System.out.println();

        test01.findway(map, 1, 1);
        test01.labyrinth(map);


        test01.honoi(3, 'A', 'B', 'C'); // 汉诺塔


        int[][] chess = new int[8][8];  // 八皇后



    }
}

class T {
    public void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }else {
            return factorial(n - 1) * n;
        }
    }

    public int Fabonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return Fabonacci(n - 1) + Fabonacci(n - 2);
        }
    }

    public int peach(int day) {
        if (day == 10) {
            return 1;
        }else if (day >= 1 && day <= 9){
            return (peach(day + 1) + 1) * 2;
        }else {
            System.out.println("day 在1-10");
            return -1;
        }
    }

    public void labyrinth(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // map数据含义：0：无障碍 1：有障碍 2：可以走通 3：走过但不通
    // 确定寻找策略：下->右->上->左
    public boolean findway(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 表示找到出口
            return true;
        }else {
            if (map[i][j] == 0) { // 表示当前位置无障碍
                map[i][j] = 2;
                if (findway(map, i + 1, j)) {   // down
                    return true;
                } else if (findway(map, i, j + 1)) { // right
                    return true;
                } else if (findway(map, i - 1, j)) { // up
                    return true;
                } else if (findway(map, i, j - 1)) { // left
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }

            }else { // map[i][j] = 1, 2, 3  map[6][5] != 2,此路不通,因此不走
                return false;
            }
        }
    }

    // num: number of pans, a:origin tower, b: middle tower, c: target tower
    public void honoi(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("move " + a + "->" + c);
            return;
        }else {
            honoi(num - 1, a, c, b);    // 将上面的num - 1借助c移动到b
            System.out.println("move " + a + "->" + c);    // 将最下面的1个从a移动到c
            honoi(num - 1, b, a, c);    // 将上面的num - 1借助a移动到c
        }
    }

    // chess数据含义：0：可以放, 1：不可以放, 2：已经放了皇后
    // 策略：第n个皇后在第n行，从第一列遍历到第八列
    public boolean eightQueens(int[][] chess, int i){   // 从第i行开始即第i个皇后开始
        for (int k = 0; k < 8; k++) {
            if (chess[i][k] == 0) { // 第i行第k列可以放
                return true;
            }else {
                if (chess[i][j] == 0) {
                    chess[i][j] = 2;
                    makechess(chess, i, j);
                    for (int k = 0; k < 8; k++) { // 第n个皇后
                        if (eightQueens(chess, n, k)) {
                            makechess(chess, n, k);
                            break;
                        }
                    }

                }
            }
        }


    }

    public void makechess(int[][] chess, int i , int j) {
        for (int k = 0; k < 8; k++) {
            chess[i][k] = 1;
            chess[k][i] = 1;
            chess[i + j - k][k] = 1;
            chess[k][i + j - k] = 1;
        }
    }
}