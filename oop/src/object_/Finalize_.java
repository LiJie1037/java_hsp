package object_;

public class Finalize_ {
    public static void main(String[] args) {
        Car benz = new Car("benz");
        benz = null;
    }
}

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("cleaner car");
//        super.finalize();
    }
}