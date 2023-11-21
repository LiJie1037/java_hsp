package list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 9:58
 */
public class ListMethod {
    public static void main(String[] args) {
        // 元素顺序，支持索引 可重复
        List list = new ArrayList();
        list.add("0");
        list.add("一");
        list.add("一");
        System.out.println(list);
        System.out.println(list.get(1));

        list.set(2, "二");
        System.out.println(list);

    }
}
