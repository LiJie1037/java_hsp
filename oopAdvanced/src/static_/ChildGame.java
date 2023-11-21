package static_;

public class ChildGame {
    public static void main(String[] args) {
        Child child1 = new Child("白骨精");
        child1.join();
        //count++;
        child1.count++;
        Child child2 = new Child("狐狸精");
        child2.join();
        //count++;
        child2.count++;
        Child child3 = new Child("老鼠精");
        child3.join();
        //count++;
        child3.count++;

        //===========
        //类变量，可以通过类名来访问
        System.out.println("共有" + Child.count + " 小孩加入了游戏...");
    }
}

class Child {
    private String name;
    public static int count;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + "加入了游戏。");
    }
}