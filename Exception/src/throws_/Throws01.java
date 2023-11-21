package throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {
        f2();
    }

    public static void f3() throws FileNotFoundException {
        f1();
    }

    public static void f1() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("./aa.txt");
    }

    public static void f2() {
        int n1 = 10;
        int n2 = 0;
        int res = n1 / n2;
    }

}

