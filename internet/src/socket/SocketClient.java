package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 9:32
 */

public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 1.连接本机（服务器）9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("client socket=" + socket.getClass());

        // 2.输出给server
        OutputStream outputStream = socket.getOutputStream();
        // 字节流
//        outputStream.write("hello, server".getBytes());
        // 使用字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("服务器你好, 字符流");
        bw.newLine(); // 表示写入内容结束
        bw.flush(); // 字符流需要手动刷新
//
//        socket.shutdownOutput();

        // 3.从server接收
        InputStream inputStream = socket.getInputStream();
        // 字节流
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf)) != -1) {
//            System.out.println(new String(buf, 0, readLen));
//        }
        // 字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = br.readLine();
        System.out.println(line);
//        while((line = br.readLine()) != null) {
//            System.out.println(line);
//        }

//        inputStream.close();
//        outputStream.close();
        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}

