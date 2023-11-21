package homework_;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 20:39
 */
public class Homework04 {
    public static void main(String[] args) {
        String str = "@Date 2023/11/20 20:39";
        countStr(str);
    }

    public static void countStr(String str) {
        if (str == null) {
            System.out.println("输入不能为空");
            return;
        }

        int n = str.length();
        int upperNum = 0;
        int lowerNum = 0;
        int digitNum = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerNum++;
            }else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperNum++;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                digitNum++;
            }
        }
        System.out.printf("upperNum=%d lowerNum=%d digitNum=%d", upperNum, lowerNum, digitNum);
    }
}
