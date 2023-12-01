package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.*;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/1 19:07
 * 该类完成文件传输服务
 */
public class FileClientService {

    /**
     *
     * @param src 源文件
     * @param dest 目标目录
     * @param senderId 发送用户 Id
     * @param getterId 接收用户 Id
     */
    public void sentFileToOne(String src, String dest, String senderId, String getterId) {
        // 读取src文件 --> message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        // 设置文件对象
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int) new File(src).length()];

        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes); // 将src文件读入到程序的字节数组
            message.setFileBytes(fileBytes); // 将文件对应的字节数组设置message
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // 提示消息
        System.out.println("\n" + senderId + " 给 " + getterId + " 发送文件: " + src
                + " 到对方的电脑的目录 " + dest);

        // 发送到服务器
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.
                    getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
