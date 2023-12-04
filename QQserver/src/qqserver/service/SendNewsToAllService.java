package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqserver.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/12/4 11:02
 */
public class SendNewsToAllService implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("请输入服务器要推送的新闻/消息[输入exit表示退出推送服务线程]");
            String news = Utility.readString(100);
            if ("exit".equals(news)) {
                System.out.println("退出推送线程");
                break;
            }

            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人 说: " + news);

            HashMap<String, ServerConnectClientThread> hm = ManageClientThread.getHm();
            for (String onLineUserId : hm.keySet()) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
