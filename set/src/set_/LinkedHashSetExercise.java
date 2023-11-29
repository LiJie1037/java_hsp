package set_;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 15:01
 */
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new Car("Audi", 300000));
        set.add(new Car("benz", 700000));
        set.add(new Car("bmw", 600000));
        set.add(new Car("benz", 700000));

        System.out.println("set=" + set);

    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Car car)) return false;
        return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}