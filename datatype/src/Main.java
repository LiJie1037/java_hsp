import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(10.0 / 4);
        double d = 10 / 4;
        System.out.println(d);
        System.out.println(10 % -3); // 1

        int i = 1;
        i = i++;
        System.out.printf("i = %d\th\nh%n", i);

        int j = 1;
        j = ++j;
        System.out.printf("j = %d%n", j);

        String[] names = {"ABC", "XYZ", "Bob"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s);

        System.out.print("A,");
        System.out.print("B,");
        System.out.print("C.");
        System.out.println();
        System.out.println("END");

        double d3 = 12900000;
        System.out.println(d3); // 1.29E7

        double d4 = 3.1415926;
        System.out.printf("%.2f\n", d4);
        System.out.printf("%.4f\n", d4);

        int n = 12345000;
        System.out.printf("n=%d, hex=%08x, 16=%x\n", n, n, n); // 注意，两个%占位符必须传入两个数

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input your name: ");
//        String name = scanner.nextLine();
//        System.out.println("Input your age: ");
//        int age = scanner.nextInt();
//        System.out.printf("name: %s, age=%d\n", name, age);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your last score: ");
        int lastScore = scanner.nextInt();
        System.out.println("Input your current score: ");
        int currentScore = scanner.nextInt();
        double improvement = (double)(currentScore - lastScore) / lastScore * 100;
        System.out.printf("improvement percentage=%.2f%%\n", improvement);
    }
}