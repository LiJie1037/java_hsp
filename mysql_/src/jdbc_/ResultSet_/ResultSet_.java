package jdbc_.ResultSet_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/7 15:46
 */
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./src/mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, properties);

        Statement statement = connection.createStatement();

//        String sql = "create table news (id int, content text);";
//        String sql = "insert into news values (1, '我是新闻一');";
        String sql = "select id, name, sex, borndate from actor";
//        int rows = statement.executeUpdate(sql);
//        System.out.println(rows > 0 ? "成功" : "失败");

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }

        // 4. 关闭资源
        statement.close();
        connection.close();

    }
}
