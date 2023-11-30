package homework;

import java.io.IOException;
import java.net.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 15:40
 */
public class Homework02Receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        String answer = "";
        if ("四大名著是哪些".equals(s)) {
            answer = "红楼梦 三国 水浒 西游记";
        } else {
            answer = "what?";
        }
        System.out.println(answer);

        socket.close();
    }
}
