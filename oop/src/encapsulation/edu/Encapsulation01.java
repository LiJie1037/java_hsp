package encapsulation.edu;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("jack is a bitch");
        person.setAge(300);
        person.setSalary(30000);
        person.info();

        System.out.println("---------------------");
        Person jaklove = new Person("jaklove", 220, 30000);
        jaklove.info();
    }

}


class Person {
    public String name;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("name长度在2-6之间");
            this.name = "hello";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // 判断
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("年龄需要设置在1-120之间");
            this.age = 18;  // 设置默认年龄
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void info() {
        System.out.printf("name=%s age=%d salary=%.2f\n", name, age, salary);
    }
}