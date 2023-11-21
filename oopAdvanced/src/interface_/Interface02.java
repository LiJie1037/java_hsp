package interface_;


import static interface_.AA.a;

public class Interface02 {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(a);
        System.out.println(a);
        System.out.println(a);

        System.out.println();
        Monkey monkey = new Monkey();
        monkey.eat();
        monkey.sleep();

        new CCC().pa();
    }
}
interface AA {
    int a = 23;
}

class BB implements AA {

}

class Animal {
    public void eat() {
        System.out.println("eating");
    }
}

class Monkey extends Animal {
    public void sleep() {
        System.out.println("sleeping");
    }
}

class BBB {
    int a = 20;
}

class CCC extends BBB implements AA {
    public void pa() {
        System.out.println(AA.a + " " + super.a);
    }

}