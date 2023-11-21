package exception1;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;

        // ctrl + alt + t
        try {
            int res = num1 / num2;
        } catch (Exception e) {
//            throw new RuntimeException(e);
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("continue");

        Cat cat = new Cat();
        cat = null;
        System.out.println(cat.name);   //NullPointerException

    }
}

class Cat{
    public String name;
}

