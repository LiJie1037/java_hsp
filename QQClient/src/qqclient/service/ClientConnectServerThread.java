package qqclient.service;

import qqclient.utils.Utility;
import qqcommon.Message;
import qqcommon.MessageType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 18:31
 * 该类表示一个客户端连接服务器的线程
 */
public class ClientConnectServerThread extends Thread{
    // 该线程需要持有socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        // Thread 在后台一直需要和服务器通信
        while (true) {
            try {
                System.out.println("客户端线程，等待读取服务器端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务器没有发送 Message 对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();

                // 判断 Message 类型，然后做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {// 获取在线列表
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n===========当前在线用户列表==========");
                    for (String onlineUser : onlineUsers) {
                        System.out.println("用户=" + onlineUser);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {// 普通聊天
                    System.out.println("\n" + message.getSender() + " 对 " + message.getGetter() + "说 " + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) { // 群发消息
                    System.out.println("\n" + message.getSender() + " 对所有人说 " + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) { // 发送文件
                    // 提示信息
                    System.out.println("\n" + message.getSender() + " 给 " + message.getGetter()
                            + " 发文件: " + message.getSrc() + " 到我的电脑的目录 " + message.getDest());

                    // 选择新地址
                    System.out.println("默认地址为: " + message.getDest() + " 是否选择新地址(y/n)");
                    String key = Utility.readString(10);
                    if (key.equals("y") || key.equals("Y")) {
                        message.setDest(Utility.readString(100));
                    }

                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest(), true);
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n文件传送成功");
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    break;
                } else {
                    System.out.println("其他类型，暂不处理");
                }

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
