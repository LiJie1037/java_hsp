package innnerClass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer4 outer4 = new Outer4();
        outer4.method();
        // tiger 匿名类
        // 编译类型
        // 运行类型
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("tiger is crying");
            }
        };
        System.out.println("tiger的运行类型=" + tiger.getClass());
        tiger.cry();
    }
}

class Outer4 {
    private int n1 = 10;
    public void method() {
//        IA tiger = new Tiger();
//        tiger.cry();
    }
}

interface IA {
    public void cry();
}

//class Tiger implements  IA {
//
//    @Override
//    public void cry() {
//        System.out.println("crying");
//    }
//}

class Father {
    public Father(String name) {
    }

    public void test() {

    }
}