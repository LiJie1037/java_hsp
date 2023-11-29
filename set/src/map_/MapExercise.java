package map_;

import java.util.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 16:25
 */
public class MapExercise {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, new Employee("hsp", 10000, 1));
        map.put(2, new Employee("tom", 20000, 2));
        map.put(3, new Employee("jack", 30000, 3));

        Collection c =  map.values();
        for (Object o : c) {
            Employee em = (Employee) o;
            if (em.getSal() > 18000) {
                System.out.println(em);
            }
        }

        System.out.println("==========");
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Employee em = (Employee) map.get(key);
            if (em.getSal() > 18000) {
                System.out.println(em);
            }
        }

        System.out.println("==========");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator.next();
            Employee em = (Employee) entry.getValue();
            if (em.getSal() > 18000) {
                System.out.println(em);
            }

        }
    }
}

class Employee {
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public double getSal() {
        return sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}