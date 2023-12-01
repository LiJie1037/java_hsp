package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 18:08
 * 该类完成用户登录验证 用户注册 请求在线用户列表 退出系统等功能
 */
public class UserClientService {

    private User u = new User();
    private Socket socket;


    // 根据 userId 和 pwd 到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;
        // 创建 user 对象
        u.setUserId(userId);
        u.setPasswd(pwd);

        // 连接服务器，发送 user 对象
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            // 发送 user 对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            // 读取 Message 对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                // 成功则创建一个线程管理此socket
                ClientConnectServerThread ccsThread = new ClientConnectServerThread(socket);
                ccsThread.start();

                // 将该线程放到一个集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, ccsThread);
                b = true;

            } else {
                // 登录失败，不启动通信线程，关闭socket
                socket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return b;
    }

    // 向服务端请求在线用户列表
    public void onlineClientFriendList() {

        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        // 得到当前线程的 socket 对应的 ObjectOutputStream
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId())
                            .getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 向服务端发出退出系统 Message
    public void logout() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());

        // 得到当前线程的 socket 对应的 ObjectOutputStream
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId())
                            .getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出系统");
            ManageClientConnectServerThread.removeClientConnectServerThread(u.getUserId());
            System.exit(0);

        } catch (IOException e) {
            System.out.println("userClientService 异常");
            throw new RuntimeException(e);
        }
    }

}
