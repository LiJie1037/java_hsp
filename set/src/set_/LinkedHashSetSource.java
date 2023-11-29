package set_;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 14:44
 */
public class LinkedHashSetSource {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘", 1001));
        set.add(123);

        System.out.println("set= " + set);

    }
}

class Customer {
    private String name;
    private int money;

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}