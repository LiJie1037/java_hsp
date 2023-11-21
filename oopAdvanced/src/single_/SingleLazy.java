package single_;

/***
 * 演示懒汉式单例模式
 * 不会先创建实例
 */

public class SingleLazy {
    public static void main(String[] args) {
        System.out.println(Cat.n1);
        Cat instance = Cat.getInstance();
        Cat instance1 = Cat.getInstance();
        System.out.println(instance);
    }
}

class Cat {
    private String name;
    public static int n1 = 99;
    private static Cat cat;

    private Cat(String name) {
        System.out.println("Constructor is called.");
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("小猫");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}