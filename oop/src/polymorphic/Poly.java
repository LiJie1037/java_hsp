package polymorphic;

public class Poly {
    public static void main(String[] args) {
        Master abc = new Master("abc");
        Dog dog = new Dog("大黄");
        Bone bone = new Bone("大骨头");
        abc.feed(dog, bone);

        Rice rice = new Rice("米饭");
    }
}
