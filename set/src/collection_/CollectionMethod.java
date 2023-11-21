package collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 21:22
 */
public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("jack");
        list.add(10);
        list.add(true);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
        list.remove(Integer.valueOf(10));
        System.out.println(list);
        list.add(10);
        System.out.println(list);

        System.out.println(list.contains(10));

        System.out.println(list.get(1));

    }
}
