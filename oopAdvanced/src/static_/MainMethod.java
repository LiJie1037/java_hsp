package static_;

public class MainMethod {
    public static String str = "hello main";

    public static void sayHi() {
        System.out.println(str);
    }

    public void cry() {
        System.out.println("I'm crying.");
    }

    public static void main(String[] args) {
        sayHi();

//        cry();  // 不能直接调用非静态成员
        new MainMethod().cry();
    }
}
