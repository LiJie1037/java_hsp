package jdbc_.datasource;

import jdbc_.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/7 20:32
 */
public class ConQuestion {
    // 演示连接5000次

    @Test
    public void testCon() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils.getConnection();

            JDBCUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间" + (end - start));
    }
}
