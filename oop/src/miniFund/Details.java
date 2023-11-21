package miniFund;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Details {
    protected String[] detailArray = new String[0];
    protected double balance = 0;
    protected Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");

    public void info() {
        System.out.println("------------零钱通明细------------");
        this.printInfo();
        System.out.println();
    }

    public void printInfo() {
        for (int i = 0; i < detailArray.length; i++) {
            System.out.println(detailArray[i]);
        }
    }

    public void addIncome() {
        String[] newDetailArray = new String[detailArray.length + 1];
        for (int i = 0; i < detailArray.length; i++) {
            newDetailArray[i] = detailArray[i];
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入收入金额：");
        double income = scanner.nextDouble();
//        String str = scanner.next();
        balance += income;
        date = new Date();
        String formattedDate = sdf.format(date);
        newDetailArray[detailArray.length] = "收益入账\t" + "+" + income + "\t" + formattedDate + "\t" + balance;
        detailArray = newDetailArray;
    }

    public void addConsume() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入消费金额：");
        double money = scanner.nextDouble();
        if (balance - money >= 0) {
            balance -= money;
            String[] newDetailArray = new String[detailArray.length + 1];
            for (int i = 0; i < detailArray.length; i++) {
                newDetailArray[i] = detailArray[i];
            }

            date = new Date();
            String formattedDate = sdf.format(date);
            newDetailArray[detailArray.length] = "消费\t\t" + "-" + money + "\t" + formattedDate + "\t" + balance;
            detailArray = newDetailArray;
        } else {
            System.out.printf("钱包余额为%.2f，余额不够！\n", balance);
        }
    }
}
