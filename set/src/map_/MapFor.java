package map_;

import java.util.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 16:06
 */
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        Set keySet = map.keySet();
        // 1.迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            System.out.println(name);
        }

        System.out.println();
        // 2.增强for
        for (Object key : keySet) {
            System.out.println(key + "=" + map.get(key));
        }

        // Collection 三种方式
        Collection values = map.values();

        System.out.println("=====EntrySet<Entry<K, V>>:=============");
        // EntrySet<Entry<K, V>>
        Set entrySet = map.entrySet();

        for (Object entry : entrySet) {
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "=" + m.getValue());
        }

        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object node = iterator1.next();
//            System.out.println(node.getClass());
            Map.Entry m = (Map.Entry) node;
            System.out.println(m.getKey() + " " + m.getValue());

        }


    }
}
