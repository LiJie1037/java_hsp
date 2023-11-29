package homework;

import java.util.HashSet;
import java.util.Objects;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 21:05
 */
public class Homework05 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);

        p1.setName("CC");
        System.out.println(p1.hashCode());  // 34136
        // set 中存储p1的hashcode=34072，因此并未删除p1
        set.remove(p1);

        System.out.println(set); // 输出两个对象
        set.add(new Person(1001, "CC"));
        System.out.println(set); // 输出3个对象
        set.add(new Person(1001, "AA"));
        System.out.println(set); // 输出4个对象

    }
}

class Person {
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Person person)) return false;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}