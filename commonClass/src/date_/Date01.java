package date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 16:52
 */
public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        System.out.println(d1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
        String format = sdf.format(d1);
        System.out.println(format);

        Date d2 = new Date(393993939339l);
        System.out.println(sdf.format(d2));

        String s = "1996-01-01 10:20:30 星期一";
        Date parse = sdf.parse(s);
        System.out.println("parse=" + sdf.format(parse));
        System.out.println("parse=" + parse);

    }
}
