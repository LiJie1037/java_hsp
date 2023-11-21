package interface_;

public interface UsbInterface {
    // 抽象方法，可以省略abstract
    public void start();

    public void end();

    // 可以有默认实现方法，需要添加default
    default public void hi() {
        System.out.println("hi");
    }

    public static void cry() {
        System.out.println("static method");
    }
}

class A implements UsbInterface {

    @Override
    public void start() {

    }

    @Override
    public void end() {

    }
}

// 抽象类实现接口时，可以不实现接口的方法
abstract class B implements UsbInterface {

}