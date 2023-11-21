import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person a = new Person();
        a.age = 20;
        a.name = "Bob";
        Person b;
        b = a;
        a.speak();

        System.out.println(b.name);
        b.age = 200;
        b = null;
        System.out.println(a.age);
        //System.out.println(b.age);

        RowColChar row = new RowColChar();
        row.print(4,4, '*');

        int[] arr = {1, 2, 3};
        System.out.println("修改前：");
        System.out.print(Arrays.toString(arr) + "\n");
        ParaPass para = new ParaPass();
        para.modArr(arr);
        System.out.println("修改后：");
        System.out.print(Arrays.toString(arr) + "\n");

        Person p2 = para.copyPerson(a);
        System.out.println(a == p2);
    }
}



class Person {
    int age;
    String name;

    public void speak() {
        System.out.println("I am a student.");
    }
}

class RowColChar {
    public void print(int row, int col, char c) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

class ParaPass {
    public void modArr(int arr[]) {
        arr[0] = 200;
        System.out.println("modArr内：");
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }

    public Person copyPerson(Person p) {
        Person p2 = new Person();
        p2.name = p.name;
        p2.age = p.age;
        return p2;
    }
}