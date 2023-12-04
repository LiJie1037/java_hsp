package qqclient.view;

import qqclient.service.FileClientService;
import qqclient.service.MessageClientService;
import qqclient.service.UserClientService;
import qqclient.utils.Utility;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 17:03
 */
public class QQView {
    private boolean loop = true; // 控制是否显示菜单
    private String key = "";    // 接收用户键盘输入
    private UserClientService userClientService = new UserClientService();  // 该对象用于用户登录
    private MessageClientService messageClientService = new MessageClientService(); // 该对象用于发送消息
    private FileClientService fileClientService = new FileClientService();  // 该对象用于发送文件


    public static void main(String[] args) {
        QQView qqView = new QQView();
        qqView.mainMenu();
        System.out.println("===========客户端退出网络通信系统==========");

    }

    private void mainMenu() {

        while (loop) {
            System.out.println("===========欢迎登录网络通信系统==========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");

            System.out.println("请输入你的选择：");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    System.out.println("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.println("请输入密  码：");
                    String pwd = Utility.readString(50);

                    if (userClientService.checkUser(userId, pwd)) {
                        System.out.println("===========欢迎" + userId +"用户==========");
                        //
                        while (loop) {
                            System.out.println("\n===========网络通信系统二级菜单（用户" + userId +"）==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");

                            key = Utility.readString(1);
                            String content = "";
                            String getterId = "";
                            switch (key) {
                                case "1":
//                                    System.out.println("显示在线用户列表");
                                    userClientService.onlineClientFriendList();
                                    break;
                                case "2":
//                                    System.out.println("群发消息");
                                    System.out.println("请输入想说的话: ");
                                    content = Utility.readString(100);
                                    messageClientService.sendMessageToAll(content, userId);
                                    break;
                                case "3":
                                    // 选择一个人私聊
                                    System.out.println("请输入想聊天的用户号(在线)");
                                    getterId = Utility.readString(50);
                                    System.out.println("请输入想说的话: ");
                                    content = Utility.readString(100);
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    break;
                                case "4":
//                                    System.out.println("发送文件");
                                    System.out.println("请输入你想发文件的用户:");
                                    getterId = Utility.readString(50);
                                    System.out.println("请输入你想发送的文件(形式:d:\\xx.jpg)");
                                    String src = Utility.readString(100);
                                    System.out.println("请输入接收这保存的路径(形式:d:\\xx.jpg)");
                                    String dest = Utility.readString(100);
                                    fileClientService.sentFileToOne(src, dest, userId, getterId);
                                    break;
                                case "9":
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("===========登录失败==========");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }

        }
    }
}
