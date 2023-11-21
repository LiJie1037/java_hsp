package single_;

// 饿汉单例式
public class Boy {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance1 = GirlFriend.getInstance();
        System.out.println(instance1);

        System.out.println(instance == instance1);


    }
}


class GirlFriend {
    private String name;

    /*
     1.私有化构造器
     2.类中私有化一个静态实例(在类加载时就生成)
     3.类中构建一个public的getInstance方法,返回2中实例
    */

    private static GirlFriend gf = new GirlFriend("小红");

    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}