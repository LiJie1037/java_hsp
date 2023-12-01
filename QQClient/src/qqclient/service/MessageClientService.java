package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/1 11:43
 * 该类实现发送消息
 */
public class MessageClientService {
    // 私聊 Message
    public void sendMessageToOne(String content, String senderId, String getterId) {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString());//发送时间设置到message对象
        System.out.println(senderId + " 对 " + getterId + " 说 " + content);

        // 得到当前线程的 socket 对应的 ObjectOutputStream
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(senderId)
                            .getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageToAll(String content, String senderId) {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString());//发送时间设置到message对象
        System.out.println(senderId + " 对所有人 " + " 说 " + content);

        // 得到当前线程的 socket 对应的 ObjectOutputStream
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(senderId)
                            .getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}