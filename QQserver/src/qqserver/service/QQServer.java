package qqserver.service;


import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 19:22
 */
public class QQServer {
    private ServerSocket ss = null;

    // 创建一个集合，存放多个合法用户
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();

    // key: getterId, value: message 存放离线消息
    private static ConcurrentHashMap<String, ArrayList<Message>> offlineMes = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, ArrayList<Message>> getOfflineMes() {
        return offlineMes;
    }

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

    private void outputOffLineMes(String getterId) {
        if (offlineMes.get(getterId) != null) {
            ArrayList<Message> messages = offlineMes.get(getterId);
            for (Message offMessage : messages) {

            }

        }
    }

    public QQServer() {
        try {
            System.out.println("服务器在9999端口监听");
            // 启动服务器新闻通知线程
            new Thread(new SendNewsToAllService()).start();
            ss = new ServerSocket(9999);
            while (true) {
                // 监听连接
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
                    }else {// 登录成功
                        message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        oos.writeObject(message);

                        // 创建一个线程，和客户端保持通信，持有socket
                        ServerConnectClientThread s2cThread = new ServerConnectClientThread(socket, u.getUserId());
                        // 启动该线程
                        s2cThread.start();
                        ManageClientThread.addClientThread(u.getUserId(), s2cThread);

                        // 该用户 offlineMes 有留言
                        if (offlineMes.containsKey(u.getUserId())) {
                            // 输出 ArrayList 中的内容
                            ObjectOutputStream oos2 = new ObjectOutputStream(s2cThread.getSocket().getOutputStream());

                            ArrayList<Message> messages = offlineMes.get(u.getUserId());
                            for (Message offMessage : messages) {
                                System.out.println("这是" + offMessage.getSender() + "给" + u.getUserId() + "的留言,时间是" + offMessage.getSendTime());
                                oos2.writeObject(offMessage);
                            }

                            // 移除留言
                            offlineMes.remove(u.getUserId());
                        }
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
