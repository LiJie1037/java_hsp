package stringBuffer_;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品名称：");
        String name = scanner.next();

        System.out.println("请输入商品价格：");
        String price = scanner.next();
//        String price = "23424123456.78";

//        StringBuffer sb = new StringBuffer();
//        sb.append(price);
        StringBuffer sb = new StringBuffer(price);
        for (int i = sb.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb.insert(i, ",");
        }

        System.out.println("商品名称\t商品价格");
        System.out.printf("%s\t\t%s\n", name, sb);

    }
}
