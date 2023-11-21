package list_;

import java.util.Vector;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/21 11:00
 */
@SuppressWarnings({"all"})
public class Vector_ {
    public static void main(String[] args) {
        // 默认为10
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        // 双倍扩容
        for (int i = 0; i < 2; i++) {
            vector.add(i);
        }
    }
}
