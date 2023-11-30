package udp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 11:51
 */
public class UDPReceiver {
    @Test
    public static void main(String[] args) throws IOException {
        // 1. 创建 DatagramSocket 对象，在端口 9999 接收数据
        DatagramSocket socket = new DatagramSocket(9999);

        // 2.创建 DatagramPacket 对象， 准备接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // 3.调用接收方法，接收数据
        // 没有数据就阻塞
        socket.receive(packet);

        // 4. 把 packet 进行拆包，取出数据
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        // 5. 关闭资源
        socket.close();
        System.out.println("UDPReceiver exit");
    }
}

class UDPSender {
    @Test
    public static void main(String[] args) throws IOException {
        // 1. 创建 DatagramSocket 对象，在端口 9998 接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        // 2.创建 DatagramPacket 对象， 封装发送数据
        byte[] data = "hello 发送数据咯".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);

        // 3.调用 send 方法，send数据
        socket.send(packet);

        // 4. 关闭资源
        socket.close();
        System.out.println("UDPSender exit");
    }
}