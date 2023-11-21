package exception1;

import java.util.Scanner;

public class InputNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        String inputStr = "";
        while (true) {
            System.out.println("请输入一个整数：");
            inputStr = scanner.next();
            try {
                n = Integer.parseInt(inputStr);
                break;
            } catch (Exception e) {
//            throw new RuntimeException(e);
                System.out.println("输入不对");
            }
        }
    }
}

