package string_;

public class String01 {
    public static void main(String[] args) {
        String a = "haha";
        String b = new String("haha");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}

