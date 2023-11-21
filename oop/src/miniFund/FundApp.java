package miniFund;

import java.util.Scanner;

public class FundApp {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Details details = new Details();
        boolean loop = true;
        while (loop) {
            menu.show();
            int choice = menu.choice();
            switch (choice) {
                case 1:
                    details.info();
                    break;
                case 2:
                    System.out.println("------------收益入账------------");
                    details.addIncome();
                    details.info();
                    System.out.println("--------------------------------");
                    break;
                case 3:
                    System.out.println("------------消费------------");
                    details.addConsume();
                    details.info();
                    System.out.println("--------------------------------");
                    break;
                case 4:
                    /*while (true) {
                        System.out.println("你确定要退出吗？y/n");
                        Scanner scanner = new Scanner(System.in);
                        char exitMenu = scanner.next().charAt(0);
                        if (exitMenu == 'y') {
                            System.out.println("退出");
                            loop = false;
                            break;
                        } else if (exitMenu == 'n') {
                            System.out.println("不退出");
                            break;
                        }
                    }*/
                    char exitMenu;
                    while (true) {
                        System.out.println("你确定要退出吗？y/n");
                        Scanner scanner = new Scanner(System.in);
                        exitMenu = scanner.next().charAt(0);
                        if (exitMenu == 'y' || exitMenu == 'n') {
                            break;
                        }
                    }

                    if (exitMenu == 'y') {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("输入不对！");
            }
        }

        System.out.println("------------已退出miniFund------------");
    }

}

