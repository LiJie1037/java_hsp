package homework_;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 19:37
 */
public class Homework02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String name = scanner.next();
        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new RuntimeException("输入长度不是2、3、4");
        }

        System.out.println("请输入密码：");
        String pwd = scanner.next();
        if (pwd.length() != 6) {
            throw new RuntimeException("密码长度不为6");
        }
        char[] chars = pwd.toCharArray();
        for (char ch: chars) {
            if(!(Character.isDigit(ch))) {
                throw new RuntimeException("请输入数字");
            }
        }


        System.out.println("请输入邮箱：");
        String mail = scanner.next();
        if (!(mail.indexOf("@") > 0 && mail.indexOf(".") > 0 && mail.indexOf("@") < mail.indexOf("."))) {
            throw new RuntimeException("输入错误");
        }
    }
}
