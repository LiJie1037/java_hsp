package homework;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 20:03
 */
public class Homework02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Car car = new Car("宝马", 400000);
        Car car1 = new Car("奔驰", 600000);
        Car car2 = new Car("宾利", 5000000);

        arrayList.add(car);
        arrayList.add(car2);
        System.out.println("add后" + arrayList);


        if (!arrayList.remove(car)) {
            System.out.println("element doesn't exist.");
        }
        System.out.println("remove后" + arrayList);

        if (arrayList.contains(car2)) {
            System.out.println("element exists.");
        }

        System.out.println("size=" + arrayList.size());
        System.out.println("isEmpty=" + arrayList.isEmpty());

        arrayList.addAll(arrayList);
        System.out.println("addAll=" + arrayList);

        arrayList.removeAll(arrayList);
        System.out.println("removeAll=" + arrayList);

    }
}

class Car {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}