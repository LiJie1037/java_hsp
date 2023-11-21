public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog(5, "大壮");
        dog1.info();
        System.out.println("dog1的hashcode=" + dog1.hashCode());

        System.out.println("======================");
        Dog dog2 = new Dog(6, "大二");
        dog2.info();
        System.out.println("dog2的hashcode=" + dog2.hashCode());

        System.out.println("======================");
        dog1.f2();

        System.out.println("======================");
        Person p1 = new Person("bob", 20);
        Person p2 = new Person("dick", 21);
        System.out.println(p1.compareTo(p2));


    }
}


class Dog {
    int age;
    String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("this的hashcode=" + this.hashCode());
    }

    public void info() {
        System.out.println("this.hashcode=" + this.hashCode());
        System.out.println(name + "\t" + age);
    }

    public void f1() {
        System.out.println("f1 call" + this.hashCode());
    }

    public void f2() {
        System.out.println("f2 call" + this.hashCode());
        f1();
        this.f1();
    }
}

class Person {
    int age;
    String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(Person p) {
        return this.age == p.age && this.name.equals(p.name);
    }
}

class TestPerson {
    String name;
    int age;

}