package jdbc_;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/7 15:10
 */
public class jdbcConnect {

    // 1.连接方式1
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();

        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    // 2.连接方式2,通过反射方式连接
    @Test
    public void connect02() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    // 3.连接方式3,DriverManager
    @Test
    public void connect03() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String password = "123456";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        DriverManager.registerDriver(driver);// com.mysql.jdbc.Driver 的 static code block 可以自动实现本句

        Connection connection = DriverManager.getConnection(url, properties);
//        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    // 4.连接方式4,DriverManager
    @Test
    public void connect04() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String password = "123456";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connection = DriverManager.getConnection(url, properties);
//        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    // 5.连接方式5,DriverManager
    @Test
    public void connect05() throws SQLException, IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./src/mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);
    }
}
