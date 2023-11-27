package homework;

import java.io.*;
import java.util.Properties;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 16:55
 */
public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");

        properties.store(new FileWriter("./dog.properties"), null);

        Dog dog = new Dog(properties.getProperty("name"),
                Integer.parseInt(properties.getProperty("age")),
                properties.getProperty("color"));

        System.out.println(dog);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./dog.dat"));
        oos.writeObject(dog);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./dog.dat"));
//        ois.readObject();
        System.out.println(ois.readObject());
        ois.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

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
                '}';
    }
}