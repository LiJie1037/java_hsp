package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 9:42
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        // 1.在本机9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("server is listening 9999, waiting for link");

        // serverSocket可以通过accept返回多个Socket
        Socket socket = serverSocket.accept();
        System.out.println("server socket=" + socket.getClass());

        // 2.接收输入
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

        // 3.输出到client
        OutputStream outputStream = socket.getOutputStream();
        // 字节流
//        outputStream.write("hello, client".getBytes());
//        socket.shutdownOutput();
        // 字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("客户端你好, 字符流");
        bw.newLine(); // 表示写入内容结束
        bw.flush(); // 字符流需要手动刷新

//        inputStream.close();
//        outputStream.close();
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出.....");
    }
}