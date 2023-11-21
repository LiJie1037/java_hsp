import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        double[] arr = {1, 4, 50.0, 99.8};
        double[] arr = {};
        A1 a1 = new A1();
        Double res = a1.max(arr);
        if (res != null) {
            System.out.println(res);
        }else {
            System.out.println("arr的输入有误");
        }


        System.out.println("-----------");
        A2 a2 = new A2();
//        String[] strings = new String[]{"aaa", "bbb", "ccc", "d"};
        String[] strings = new String[]{};
        Integer resInt = a2.find(strings, "f");
        if (resInt != null) {
            System.out.println(resInt);
        }else {
            System.out.println("strings的输入有误");
        }

        System.out.println("-----------");
        Book book = new Book("斗破苍穹", 120.0);
        book.info();
        book.updatePrice();
        book.info();

        System.out.println("-----------");
//        int[] arr3 = {1, 2, 3, 4};
//        double[] arr3 = {1, 2, 3, 4.3};
        String[] arr3 = {"aaa", "bbb", "ccc", "e"};
        A3 a3 = new A3();
//        int[] newArr3 = a3.copyArr(arr3);
//        double[] newArr3 = a3.copyArr(arr3);
        String[] newArr3 = a3.copyArr(arr3);
        System.out.println(Arrays.toString(newArr3));

        System.out.println("-----------");
        Circle circle = new Circle(5.0);
        System.out.println(circle.periphery());
        System.out.println(circle.square());

        System.out.println("-----------");
        Cale cale = new Cale(2.0, 0);
        System.out.println(cale.div());

        System.out.println("-----------");
        PassObject passObject = new PassObject();
        passObject.printAreas(circle, 5);

        System.out.println("-----------");
        Tom tom = new Tom();
        tom.fingerPlay();

        
    }
}

class A1 {
/*    public double max(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        return max;
    }*/

    public Double max(double[] arr) {
        if (arr != null && arr.length > 0) {
            double max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                max = arr[i] > max ? arr[i] : max;
            }
            return max;
        }else {
            return null;
        }
    }
}

class A2 {
/*    public int find(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            if (str.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }*/

    public Integer find(String[] arr, String str) {
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (str.equals(arr[i])) {
                    return i;
                }
            }
            return -1;
        }else {
            return null;
        }
    }
}

class Book {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void updatePrice() {
        if (this.price > 150) {
            this.price = 150;
        }else if (this.price > 100) {
            this.price = 100;
        }
    }

    public void info() {
        System.out.println("book name=" + this.name + "book price=" + this.price);
    }
}

class A3 {
    public int[] copyArr(int[] arr) {
        int[] arrNew = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }
        return arrNew;
    }

    public double[] copyArr(double[] arr) {
        double[] arrNew = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }
        return arrNew;
    }

    public String[] copyArr(String[] arr) {
        String[] arrNew = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }
        return arrNew;
    }
}

class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double periphery() {
        return Math.PI * this.radius * 2;
    }

    public double square() {
        return Math.PI * this.radius * this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class Cale {
    double num1;
    double num2;

    public Cale(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add() {
        return this.num1 + this.num2;
    }

    public double sub() {
        return num1 - num2;
    }

    public double mul() {
        return num1 * num2;
    }

    public Double div() {
        if (num2 != 0) {
            return num1 / num2;
        }else {
            System.out.println("除数不能为0");
            return null;
        }
    }
}

class Test {
    int count = 9;
    public void count01() {
        count = 10;
        System.out.println("count01=" + count);
    }

    public void count02() {
        System.out.println("count01=" + count++);
    }
}

class Employee {
    String name;
    char gender;
    int age;
    String job;
    double salary;

    public Employee(String job, double salary) {
        this.job = job;
        this.salary = salary;
    }

    public Employee(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String name, char gender, int age, String job, double salary) {
        this(name, gender, age);
        this.job = job;
        this.salary = salary;
    }

}

class PassObject {
    public void printAreas(Circle c, int times) {
        System.out.println("Radius\t\tArea");
        for (int i = 0; i < times; i++) {
            c.radius = i + 1;
            System.out.println(c.radius + "\t\t\t" + c.square());
        }
    }
}

class Tom {
    int hand;

    public void fingerPlay() {
        boolean continueGame = true;
        while (continueGame) {
            Random random = new Random();
            int computer = random.nextInt(3);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input your guess(0: stone, 1:scissors, 2:cloth): ");
            this.hand = scanner.nextInt();
            int res = hand - computer;

            if (res == 0) {
                System.out.println("Tom平:\t" + hand + "vs" + computer);
            } else if (res == 1 || res == -2) {
                System.out.println("Tom输:\t" + hand + "vs" + computer);
            } else {
                System.out.println("Tom赢:\t" + hand + "vs" + computer);
            }

            System.out.println("是否继续：y/n?");
            char c = scanner.next().charAt(0);
            if (c == 'n') {
                continueGame = false;
            } else if (c == 'y') {
                continueGame = true;
            } else {
                System.out.println("请输入：y/n");
            }
        }
    }
}