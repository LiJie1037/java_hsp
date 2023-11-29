package homework;

import java.util.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 20:16
 */
public class Homework03 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);

        System.out.println("m=" + m);
        m.put("jack", 2600);
        System.out.println("m=" + m);

        Set keySet = m.keySet();
        for (Object key : keySet) {
            m.put(key, (Integer)m.get(key) + 100);
            System.out.println(m.get(key));
        }


        Set entrySet = m.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}

