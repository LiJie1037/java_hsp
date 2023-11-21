public class Main {
    public static void main(String[] args) {
        new Main().count01(); // 匿名对象，使用完后会销毁
        Main t1 = new Main();
        t1.count02();
        t1.count02();
        System.out.println("Hello world!");
    }

    int count = 9;
    public void count01() {
        count = 10;
        System.out.println("count01=" + count);
    }

    public void count02() {
        System.out.println("count01=" + count++);
    }
}