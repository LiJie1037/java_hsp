package polymorphic.dynamicBinding;

public class Test {
    public static void main(String[] args) {
        Base base = new Sub();
        System.out.println(base.count);
        Sub sub = new Sub();
        System.out.println(sub.count);

        Base base1 = new Base();

        System.out.println(base1 instanceof Sub);

        double d = 13.4;
        long l = (long)d;
        System.out.println(l);
//        int in = 5;
//        boolean boo = (boolean)in;

        Object obj = "hello";
        String objStr = (String) obj;
        System.out.println(objStr);

//        Object obj2 = new Integer(5);
        Object obj2 = Integer.valueOf(5);
//        String objInt = (String) obj2;
        Integer str3 = (Integer) obj2;
        System.out.println(str3);

        System.out.println("\n------------\n");
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());

    }
}

class Base {
    int count = 20;
}

class Sub extends Base {
    int count = 10;
}


class A {//父类
    public int i = 10;
    //动态绑定机制:

    public int sum() {//父类sum()
        return getI() + 10;//20 + 10
    }

    public int sum1() {//父类sum1()
        return i + 10;//10 + 10
    }

    public int getI() {//父类getI
        return i;
    }
}

class B extends A {//子类
    public int i = 20;

    public int sum() {
        return i + 20;
    }

    public int getI() {//子类getI()
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}
