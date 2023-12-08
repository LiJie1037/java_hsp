package jdbc_;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/7 10:32
 */
public class jdbc_ {
    public static void main(String[] args) throws SQLException {
        // 1. 注册驱动
        Driver driver = new Driver();

        // 2.得到链接
        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        Connection connect = driver.connect(url, properties);

        // 3.执行sql
        String sql = "insert into actor values (null, '刘德华', '男', '1970-11-11', '110')";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);// 如果是 dml语句，返回的就是影响行数

        System.out.println(rows > 0 ? "成功" : "失败");

        // 4. 关闭资源
        statement.close();
        connect.close();

    }
}
