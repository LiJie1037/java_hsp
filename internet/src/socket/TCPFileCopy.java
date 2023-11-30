package socket;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 10:38
 */
public class TCPFileCopy {
    public static void main(String[] args) {
    }
}

class SocketClientCopy {
    @Test
    public static void main(String[] args) throws IOException {
        // 1.连接本机（服务器）8888 端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        // 读取文件
        String filePath = "./src/mg.png";
        File file = new File(filePath);
//        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));


        // 写给服务器
        OutputStream outputStream = socket.getOutputStream();
        byte[] buf = new byte[1024];

        int readLen = 0;
        while ((readLen = bis.read(buf)) != -1) {
            outputStream.write(buf, 0, readLen);
        }

//        while ((readLen = fileInputStream.read(buf)) != -1) {
//            outputStream.write(buf, 0, readLen);
//        }
//        fileInputStream.close();
        bis.close();
        socket.shutdownOutput();



        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}

class SocketServerCopy {
    @Test
    public static void main(String[] args) throws IOException {
        // 1.在本机8888端口监听
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("server is listening 8888, waiting for link");

        // serverSocket可以通过accept返回多个Socket
        Socket socket = serverSocket.accept();

        String destFilePath = "./src/mg1.png";
//        FileOutputStream fileOutputStream = new FileOutputStream(destFilePath);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

        // 2.接收输入
        InputStream inputStream = socket.getInputStream();
        // 字节流
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            bos.write(buf, 0, readLen);
        }
        bos.close();
//        while ((readLen = inputStream.read(buf)) != -1) {
//            fileOutputStream.write(buf, 0, readLen);
//        }
//        fileOutputStream.close();

        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出.....");
    }
}