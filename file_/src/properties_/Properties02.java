package properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.SimpleFormatter;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 16:02
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        String src = "./src/mysql.properties";
        Properties properties = new Properties();
        // 加载
        properties.load(new FileReader(src));

        // 显示
        properties.list(System.out);

        String user = properties.getProperty("user");
//        System.out.println("user=" + user);


        // 创建配置文件
        properties.setProperty("charset", "unicode");
        properties.setProperty("date", "2023");
        properties.setProperty("name", "中文");

        properties.store(new FileWriter(src), null);

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss E");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
    }
}
