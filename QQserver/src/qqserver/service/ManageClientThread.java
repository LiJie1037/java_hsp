package qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 18:44
 * 该类管理client 连接 server的线程
 */
public class ManageClientThread {

    // key 是userId， value 是线程
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    // 将某个线程加入到集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    // 将某个线程从集合移除
    public static void removeClientThread(String userId) {
        hm.remove(userId);
    }

    // 通过 userId 可以得到对应的线程
    public static ServerConnectClientThread getClientThread(String userId) {
        return hm.get(userId);
    }

    // 返回在线用户列表
    public static String getOnlineUser() {
        // 集合遍历
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList +=  iterator.next() + " ";
        }
        return onlineUserList;
    }
}
