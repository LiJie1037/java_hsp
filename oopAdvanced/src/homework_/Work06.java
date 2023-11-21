package homework_;

/*
1.有一个交通工具接口类Vehicles，有work接口
2.有Horse类和Boat类分别实现Vehicles
3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5.实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
6.增加一个情况，如果唐僧过火焰山, 使用 飞机 ==> 程序扩展性, 我们前面的程序结构就非常好扩展 10min
使用代码实现上面的要求
编程 需求---->理解---->代码-->优化
 */

public class Work06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse());
        person.common();
        person.passRiver();
        person.common();
        person.common();
        person.mountain();

    }


}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般情况下，骑马");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("遇到大河时用船");
    }
}

class Plane implements Vehicles {
    @Override
    public void work() {
        System.out.println("火焰山坐飞机");
    }
}

class Person {
    private final String name;
    private Vehicles vel;

    public Person(String name, Vehicles vel) {
        this.name = name;
        this.vel = vel;
    }

    public void passRiver() {
        if (!(vel instanceof Boat)) {
            vel = VehiclesFactory.getBoat();
        }
        vel.work();
    }

    public void common() {
        if (vel == null) {
            vel = VehiclesFactory.getHorse();
        }
        vel.work();
    }

    public void mountain() {
        if (!(vel instanceof Plane)) {
            vel = VehiclesFactory.getPlane();
        }
        vel.work();
    }
}

class VehiclesFactory {

    private static final Horse horse = new Horse();    // 饿汉式

    private VehiclesFactory() {}

    public static Horse getHorse() {
//        return new Horse();
        return horse;
    }


    public static Boat getBoat() {
        return new Boat();
    }

    public static Plane getPlane() {
        return new Plane();
    }
}