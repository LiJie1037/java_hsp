package set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 11:51
 */
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        hashSet.add(new Employee("hsp", 30));
        hashSet.add(new Employee("tom", 15));
        hashSet.add(new Employee("hsp", 30));

        System.out.println("hashSet=" + hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee employee)) return false;
        return age == employee.age && Objects.equals(name, employee.name);
//        return age == employee.age && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}