package qqclient.service;

import java.util.HashMap;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 18:44
 * 该类管理client 连接 server的线程
 */
public class ManageClientConnectServerThread {
    // key 是用户id， value 是线程
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    // 将某个线程加入到集合
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);
    }

    // 将某个线程加入到集合
    public static void removeClientConnectServerThread(String userId) {
        hm.remove(userId);
    }

    // 通过 userId 可以得到对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }
}
