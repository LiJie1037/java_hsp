package list_;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 10:38
 */
@SuppressWarnings({"all"})
public class ArrayListSource {
    public static void main(String[] args) {

        //使用无参构造器创建ArrayList对象
//        ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);
        //使用for给list集合添加 1-10数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        //使用for给list集合添加 11-15数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);

    }
}
