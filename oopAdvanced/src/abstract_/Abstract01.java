package abstract_;

public class Abstract01 {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

//    public void eat() {
//        System.out.println("this is a animal.eat nothing.");
//    }

    public abstract void eat();
}
