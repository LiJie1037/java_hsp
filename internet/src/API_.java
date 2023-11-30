import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/29 21:38
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        // 获取本机 InetAddress 对象
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);

        InetAddress host1 = InetAddress.getByName("lijie1037");
        System.out.println("host1=" + host1);

        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2=" + host2);
    }
}
