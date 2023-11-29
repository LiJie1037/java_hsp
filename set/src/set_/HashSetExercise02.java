package set_;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 14:27
 */
public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee2("hsp", 10000, new MyDate(1980, 11, 11)));
        set.add(new Employee2("tom", 20000, new MyDate(2000, 12, 12)));
        set.add(new Employee2("hsp", 10000, new MyDate(1980, 11, 11)));

        System.out.println("set=" + set);

    }
}

class Employee2 {
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee2(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Employee2 employee2)) return false;
        return Objects.equals(name, employee2.name) && Objects.equals(birthday, employee2.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sal, birthday);
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MyDate myDate)) return false;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}