package map_;

import java.util.Hashtable;
import java.util.Properties;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 17:43
 */
public class HashTable01 {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
//        table.put("jack", 100);
//        table.put(null, 1); // 异常

        for (int i = 0; i < 12; i++) {
            table.put("i", i);
        }

        Properties properties = new Properties();
        properties.put("user", "root");
        properties.setProperty("user", "normal");
        properties.setProperty("ip", "192.168.1.1");
        properties.put("date", "2023");
        System.out.println(properties);

    }
}
