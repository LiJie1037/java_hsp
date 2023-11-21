package miniFund.oopVersion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FundAppFunction {
    int choice; // 主菜单选项
    boolean loop = true;    // 主菜单循环
    Scanner scanner = new Scanner(System.in);

    // 明细的相关属性
    protected String[] detailArray = new String[0];
    protected double balance = 0;
    protected double money = 0;
    protected Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");

    public void mainMenu() {
        while (loop) {
            this.showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    this.details();
                    break;
                case 2:
                    this.income();
                    break;
                case 3:
                    this.consume();
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("输入不对！");
                    break;
            }
        }
        System.out.println("已退出MiniFund。");
    }

    public void showMenu() {
        System.out.println("\n------------零钱通菜单------------");
        System.out.println("\t\t\t1 零钱通明细");
        System.out.println("\t\t\t2 收益入账");
        System.out.println("\t\t\t3 消费");
        System.out.println("\t\t\t4 退出");
        System.out.println();
        System.out.println("请选择(1-4):");
    }

    public void details(){
        System.out.println("------------零钱通明细------------");
        for (int i = 0; i < detailArray.length; i++) {
            System.out.println(detailArray[i]);
        }
    }

    public void income(){
        System.out.println("请输入收入金额：");
        money = scanner.nextDouble();
        if (money <= 0) {
            System.out.println("收益入账金额需要大于0");
            return;
        }
        balance += money;
        date = new Date();
        String formattedDate = sdf.format(date);

        String[] newDetailArray = new String[detailArray.length + 1];
        for (int i = 0; i < detailArray.length; i++) {
            newDetailArray[i] = detailArray[i];
        }
        newDetailArray[detailArray.length] = "收益入账\t" + "+" + money + "\t" + formattedDate + "\t" + balance;
        detailArray = newDetailArray;
    }

    public void consume() {
        System.out.println("请输入消费金额：");
        money = scanner.nextDouble();
        if (money <= 0 || money > balance) {
            System.out.println("消费金额应在0-" + balance);
            return;
        }
        balance += money;
        date = new Date();
        String formattedDate = sdf.format(date);

        String[] newDetailArray = new String[detailArray.length + 1];
        for (int i = 0; i < detailArray.length; i++) {
            newDetailArray[i] = detailArray[i];
        }
        newDetailArray[detailArray.length] = "消费\t\t" + "-" + money + "\t" + formattedDate + "\t" + balance;
        detailArray = newDetailArray;
    }

    public void exit() {
        char exitMenu;
        while (true) {
            System.out.println("你确定要退出吗？y/n");
            exitMenu = scanner.next().charAt(0);
            if (exitMenu == 'y' || exitMenu == 'n') {
                break;
            }
        }
        if (exitMenu == 'y') {
            loop = false;
        }
    }
}
