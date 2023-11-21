package final_;

public class FinalExercise1 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.area());
    }
}

class Circle {
//    public final double PI = 3.14;
    public final double PI;
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
//        PI = 3.14;
    }
    {
        PI = 3.14;
    }

    public double area() {
        return PI * radius * radius;
    }
}