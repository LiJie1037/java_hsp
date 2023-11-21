package innnerClass;

public class LocalInnerClass {
}

class Outer1 {
    private int n = 1;

    private void fun1() {};

    public void fun2() {
        // 局部内部类，方法内
        // 可以访问外部类的所有成员
        // 不能添加访问修饰符，可以使用final
        class Inner1 {
            public void fun3() {
                System.out.println(n);
                fun2();
            }
        }

        // Inner1添加final后就不能继承了
        class Inner2 extends Inner1{}
    }
}