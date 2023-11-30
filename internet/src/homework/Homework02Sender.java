package homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 15:42
 */
public class Homework02Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9993);

        byte[] data = "四大名著是哪些".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8888);
        socket.send(packet);

        socket.close();

    }
}
