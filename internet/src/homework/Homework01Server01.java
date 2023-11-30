package homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 14:46
 */
public class Homework01Server01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9991);
        Socket socket = serverSocket.accept();

        // 接收 name
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = br.readLine();
        String answer = "";
        if ("name".equals(line)) {
            answer = "我是 nova";
        } else if ("hobby".equals(line)) {
            answer = "编写java程序";
        } else {
            answer = "你说的啥子";
        }

        // 发送 answer
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(answer);
        bw.newLine();
        bw.flush();



        bw.close();
        br.close();
        socket.close();
        System.out.println("server exit");
    }
}




