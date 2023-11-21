package string_;

public class StringPerson {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";
        System.out.println(p1.name == p2.name);

        Person p3 = new Person("hspedu");

        Person p4 = new Person("hspedu");


        System.out.println(p3.name == p4.name);
    }
}

class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}