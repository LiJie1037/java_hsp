package homework_;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 18:56
 */
public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(str);
        try {
            str = reverse(str, 1 , str.length() + 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {

        if (!(str != null && start >= 0 && start < end && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char tmp = ' ';
        for (int i = start, j = end; i <= j; i++, j--) {
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
