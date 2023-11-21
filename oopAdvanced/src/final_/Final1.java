package final_;

public class Final1 {
    public static void main(String[] args) {
        C c = new C();
        Base base = new Base();
        Base base1 = new Base();
//        c.TAX_RATE = 0.01; 不能被改
    }
}

final class Base {

}

//class Sub extends Base {} 无法继承

class C {
    public final double TAX_RATE = 0.02;
    public final void hi() {
        System.out.println("hi");
    }
}

class D extends C {
/*    @Override
    public void hi() {
        super.hi();
        // 不能重写
    }*/
}