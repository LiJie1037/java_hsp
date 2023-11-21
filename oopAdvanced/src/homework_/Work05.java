package homework_;


public class Work05 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}

class A {
    private String name = "A";

    public void f1() {
        class B {
            private final String NAME = "B";
            public void show() {
                System.out.println("NAME=" + NAME + "\t外部类的name=" + A.this.name) ;
            }
        }

        B b = new B();
        b.show();
    }

}