package exception1;

public class Exception02 {
    public static void main(String[] args) {
        try {
            String str = "aaa";
            int num = Integer.parseInt(str);
            System.out.println(num);
        } catch (NumberFormatException e) {
//            throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
        System.out.println("继续");

    }
}


class AAA {
    int x;

    public static void main(String[] args) {
        int y;
        AAA a = new AAA();
        y = 3 / a.x;
        System.out.println("ends");
    }
}