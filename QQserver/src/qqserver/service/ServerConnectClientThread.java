package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 18:31
 * 该类表示服务器连接一个客户端的线程
 */
public class ServerConnectClientThread extends Thread {
    // 该线程需要持有socket
    private Socket socket;
    private String userId;// 连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        // Thread 在后台一直需要和客户端通信
        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + " 保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果客户端没有发送 Message 对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();

                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {// 要求返回在线用户列表
                    System.out.println(message.getSender() + " 要在线用户列表");
                    // 得到在线用户列表
                    String onlineUser = ManageClientThread.getOnlineUser();

                    // 构建 Message 对象, 返回给客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());

                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) { // 客户端请求退出
                    System.out.println(message.getSender() + "客户端请求退出,关闭线程");
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);

                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                    // 从集合中移除删除该线程
                    ManageClientThread.removeClientThread(message.getSender());
                    socket.close();
                    break;
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) { // 发送普通消息
                    // 得到接收方的 服务器连接至客户端的线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThread.getClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());

                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_COMM_MES);
                    message2.setSender(message.getSender());
                    message2.setGetter(message.getGetter());
                    message2.setContent(message.getContent());

                    oos.writeObject(message2); // 转发,提示如果客户不在线,可以保存到数据库

                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {// 群发消息
                    // 发送给所有在线用户
                    String[] onlineUsers = ManageClientThread.getOnlineUser().split(" ");
                    for (String onlineUser : onlineUsers) {
                        if (!(onlineUser.equals(message.getSender()))) {
                            ServerConnectClientThread serverConnectClientThread = ManageClientThread.getClientThread(onlineUser);
                            ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                            Message message2 = new Message();
                            message2.setMesType(MessageType.MESSAGE_TO_ALL_MES);
                            message2.setSender(message.getSender());
                            message2.setContent(message.getContent());

                            oos.writeObject(message2); // 转发,提示如果客户不在线,可以保存到数据库
                        }
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) { // 发送文件
                    //根据getter id 获取到对应的线程，将message对象转发
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageClientThread.getClientThread(message.getGetter()).getSocket().getOutputStream());
                    //转发
                    oos.writeObject(message);

                } else {
                    System.out.println("其他类型,暂不处理");
                }

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
