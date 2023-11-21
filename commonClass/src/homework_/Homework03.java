package homework_;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 20:07
 */
public class Homework03 {
    public static void main(String[] args) {
        String str = "Han Shun Ping";
        test(str);
    }

    public static void test(String str) {
        if (str == null) {
            System.out.println("str 不能为空");
            return;
        }

        String[] name =  str.split(" ");
        if (name.length != 3) {
            System.out.println("错误");
            return;
        }
        String format = String.format("%s,%s .%c", name[2], name[0], name[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
