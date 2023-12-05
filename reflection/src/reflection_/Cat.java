package reflection_;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/4 16:07
 */
public class Cat {
    private String name;
    public int age = 10; //public的

    public Cat() {} //无参构造器

    public Cat(String name) {
        this.name = name;
    }

    public void hi() { //常用方法
        //System.out.println("hi " + name);
    }
    public void cry() { //常用方法
        System.out.println(name + " 喵喵叫..");
    }
}
