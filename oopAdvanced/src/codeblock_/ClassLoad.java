package codeblock_;

public class ClassLoad {
    public static void main(String[] args) {
        // 类的加载时间
//        Base base = new Base(); // 1.创建对象实例时(new)
//        Base base1 = new Base(); // 创建对象实例时(new)
//        Base base2;
        System.out.println();
        Sub sub = new Sub();    // 2.创建子类对象实例，父类会被加载, base的static 代码块只加载一次
//
//        System.out.println();
//        System.out.println(Sub.n);  // 3.使用类的静态成员时，且使用类的静态成员时，普通代码块不会被执行
    }
}


class Base {
    static {
        System.out.println("Base's static code block.");
    }
    {
        System.out.println("Base's normal code block.");
    }
}

class Sub extends Base {
    public static int n = 90;
    static {
        System.out.println("Sub's static code block.");
    }
    {
        System.out.println("Sub's normal code block.");
    }
}

class Animal {
     static {
         System.out.println("Animal's static code block");
     }
}

class Cat extends Animal {
    public static int n = 90;
    static {
        System.out.println("Cat's static code block");
    }
}