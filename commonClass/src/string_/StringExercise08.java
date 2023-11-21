package string_;

public class StringExercise08 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";

        String c = a + b;
        String e = "helloabc";
        System.out.println(c.intern().hashCode());
        System.out.println(e.intern().hashCode());


    }
}
