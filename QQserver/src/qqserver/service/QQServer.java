package qqserver.service;


import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 19:22
 */
public class QQServer {
    private ServerSocket ss = null;

    // 创建一个集合，存放多个合法用户
    private static HashMap<String, User> validUsers = new HashMap<>();

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("段誉", new User("段誉", "123456"));
        validUsers.put("木婉清", new User("木婉清", "123456"));
        validUsers.put("王语嫣", new User("王语嫣", "123456"));
    }

    // 验证用户是否有效
    private boolean checkUser(String UserId, String passwd) {
        User user = validUsers.get(UserId);
        if (user == null) {// userId没有存在 validUsers 中
            return false;
        }
        // userId存在,但密码不正确
        return user.getPasswd().equals(passwd);
    }

    public QQServer() {
        try {
            System.out.println("服务器在9999端口监听");
            ss = new ServerSocket(9999);
            while (true) {
                Socket socket = ss.accept();

                // 得到 socket 关联的对象啊输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                User u = (User) ois.readObject();
                Message message = new Message();
                // 验证
                if (checkUser(u.getUserId(), u.getPasswd())) {// 登录成功
                    if (ManageClientThread.getClientThread(u.getUserId()) != null) {//用户已经登录
                        System.out.println("用户" + u.getUserId() + "已登录");
                    }else {
                        message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        oos.writeObject(message);
                        // 创建一个线程，和客户端保持通信，持有socket
                        ServerConnectClientThread s2cThread = new ServerConnectClientThread(socket, u.getUserId());
                        // 启动该线程
                        s2cThread.start();
                        ManageClientThread.addClientThread(u.getUserId(), s2cThread);
                        System.out.println("服务器和用户" + u.getUserId() + "保持通信，读取数据");
                    }
                } else {// 登录失败
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    System.out.println("用户 id=" + u.getUserId() + " pwd=" + u.getPasswd() + "验证失败");
                    socket.close();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
