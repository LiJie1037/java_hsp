import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        double total = 0;
//        for (int i = 0; i < 3; i++) {
//            System.out.printf("请输入%d班的同学的成绩：\n", i + 1);
//            double sum = 0;
//            for (int j = 0; j < 5; j++) {
//                System.out.printf("请输入%d班第%d位的同学的成绩：", i+1, j+1);
//                double score = scanner.nextDouble();
//                sum += score;
//            }
//            total += sum;
//            double classAverage = sum / 5;
//            System.out.printf("%d班的平均成绩为%.2f：\n", i+1, classAverage);
//        }
//        double gradeAverage = total / 15;
//        System.out.printf("年级的平均成绩为%.2f：\n", gradeAverage);
//        System.out.println("Hello world!");

        // 9 * 9 multiplication table
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d\t", j, i, i*j);
            }
            System.out.println();
        }
    }
}