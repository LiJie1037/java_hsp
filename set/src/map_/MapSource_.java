package map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 15:35
 */
public class MapSource_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "韩顺平");//k-v
        map.put("no2", "张无忌");//k-v
        map.put(new Car(), new Person());//k-v

        //1. k-v 最后是 HashMap$Node node = newNode(hash, key, value, null)
        //2. k-v 为了方便程序员的遍历，还会 创建 EntrySet 集合 ，该集合存放的元素的类型 Entry,
        //      EntrySet<Entry<K,V>> 即： transient Set<Map.Entry<K,V>> entrySet;
        //3. entrySet 中， 定义的类型是 Map.Entry ，但是实际上存放的还是 HashMap$Node 向上转型
        //   这时因为 static class Node<K,V> implements Map.Entry<K,V>
        //4. 当把 HashMap$Node 对象 存放到 entrySet 就方便我们的遍历, 因为 Map.Entry 提供了重要方法
        //   K getKey(); V getValue();

        Set set = map.entrySet();
        System.out.println(set.getClass());// HashMap$EntrySet
        for (Object obj : set) {

            // System.out.println(obj.getClass()); //HashMap$Node
            //为了从 HashMap$Node 取出k-v
            //1. 先做一个向下转型
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "=" + entry.getValue() );
        }

        System.out.println("============");
        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        System.out.println(set1);

        Collection values = map.values();
        System.out.println(values.getClass());
        System.out.println(values);


//        map.remove("no2");
//        System.out.println(map.remove("no2", "张无忌"));


    }
}

class Car {

}

class Person{

}
