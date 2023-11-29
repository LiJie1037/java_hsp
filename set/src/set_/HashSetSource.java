package set_;

import java.util.HashSet;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 10:55
 */
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set=" + hashSet);

        HashSet hs = new HashSet();
        for (int i = 0; i < 12; i++) {
            hs.add(new A(i));
        }
    }
}


class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}