package list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 10:02
 */
@SuppressWarnings({"all"})
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList(13);
        for (int i = 0; i < 11; i++) {
            list.add("hello" + i);
        }
        System.out.println(list.size());
        System.out.println(list);
        list.add(1, "hspedu");
        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}
