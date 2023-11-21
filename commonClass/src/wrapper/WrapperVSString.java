package wrapper;

public class WrapperVSString {
    public static void main(String[] args) {
        // Integer -> String
        Integer i = 100;
        // 方式一
        String str = i + "";
        System.out.println(str);

        // 方式二
        String str2 = i.toString();
        // 方式三
        String str3 = String.valueOf(i);

        // String -> Integer
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4);

    }
}
