package wrapper;

public class Integer1 {
    public static void main(String[] args) {
        int n1 = 5;
//        Integer integer = new Integer(n1);
        // 手动装箱
        Integer integer1 = Integer.valueOf(n1);
        int n2 = integer1.intValue();
        System.out.println(n2);

        // 自动装箱 拆箱
        Integer integer = n1;
        int n3 = integer;
        System.out.println(n3);

        Double d = 100d;
        System.out.println(d);

        Float f = 1.5f;

        // 三元运算符是一个整体，因此输出最大的类型double
        Object obj = true ? Integer.valueOf(1) : Double.valueOf(2.0);
        System.out.println(obj);

        Object obj2;
        if (true) {
            obj2 = Integer.valueOf(1);
        } else {
            obj2 = Double.valueOf(2.0);
        }
        System.out.println(obj2);

        Integer i = Integer.valueOf(1);
        Integer j = Integer.valueOf(1);
        System.out.println(i == j);

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);

    }
}

