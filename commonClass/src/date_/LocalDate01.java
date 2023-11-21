package date_;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/20 17:21
 */
public class LocalDate01 {
    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println("year"+ ldt.getYear());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E");
        System.out.println(dtf.format(ldt));

        LocalDateTime localDateTime = ldt.plusDays(365);
        System.out.println("366 " + dtf.format(localDateTime));

        // 时间戳
        System.out.println();
        Instant now = Instant.now();
        System.out.println(now);
//        Instant -> Date, Date -> Instant
        Date date = Date.from(now);
        System.out.println(date);
        now = date.toInstant();

    }
}
