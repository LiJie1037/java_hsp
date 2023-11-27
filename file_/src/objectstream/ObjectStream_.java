package objectstream;

import java.io.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 12:26
 */
public class ObjectStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog dog = new Dog("daHuang", 10, "White");
        String filePath = "./data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(100);
        oos.writeObject(dog);

        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        System.out.println(ois.readInt());
        System.out.println(ois.readObject());

    }
}


class Dog implements Serializable {
    private String name;
    private int age;
    private static String nation = "Japan";
    private transient String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}' + nation;
    }
}