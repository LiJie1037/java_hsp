package map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 15:08
 */
public class Map_ {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("001", "hsp");
        map.put("002", "zwj");
        map.put("111", "tom");
        map.put("001", "hhh");  // 替换hsp
        System.out.println("map= " + map);
    }
}
