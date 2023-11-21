package collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 9:48
 */
@SuppressWarnings({"all"})
public class CollectionExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
//        Dog dog1 = new Dog("小黑", 2);
//        Dog dog2 = new Dog("小黄", 3);
//        Dog dog3 = new Dog("小白", 4);

        list.add(new Dog("小黑", 2));
        list.add(new Dog("小黄", 3));
        list.add(new Dog("小白", 4));

        // 迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        System.out.println("----------");
        // for
        for (Object o : list) {
            System.out.println(o);
        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}