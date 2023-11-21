package final_;

public class Final2 {
    public static void main(String[] args) {
        System.out.println(A.num);
        System.out.println(B.num);
    }
}

class A {
    public static int num = 10;
    static {
        System.out.println("A static code block is called.");
    }
}

class B {
    public final static int num = 10;
    static {
        System.out.println("B static code block is called.");
    }
}