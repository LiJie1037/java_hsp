package object_;

public class Equals {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a.toString());
        System.out.println(a);
        System.out.println(a.getClass().getName() + "@" + Integer.toHexString(a.hashCode()));

        System.out.println(a == c);
        System.out.println(b == c);

        B bobj = a;
        System.out.println(bobj == a);

        System.out.println("------------");

        Person person = new Person("zs", 22, 'm');
        Person person1 = person;
        Person person2 = new Person("zss", 22, 'm');
        String str = "zs";
        System.out.println(person2.equals(person));
        System.out.println(person.equals(str));
        System.out.println(person1.equals(person));

        int numi = 65;
        float numf = 65.0f;
        System.out.println(numi == numf);

        char ch1 = 'A';
        System.out.println(ch1 == numi);

        char ch2 = 12;
        System.out.println(12 == ch2);
//        System.out.println("hello" == new java.sql.Date(123));





    }
}

class B {

}

class A extends B {

}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public boolean equals (Object anObject) {
        if (this == anObject) {
            return true;
        }
        return (anObject instanceof Person aPerson)
                && (this.age == aPerson.age)
                && (this.gender == aPerson.gender)
                && (this.name.equals(aPerson.name));
    }
}