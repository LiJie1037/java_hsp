package date_;

import java.util.Calendar;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 17:07
 */
public class Calendar01 {
    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.WEEK_OF_MONTH));
    }
}
