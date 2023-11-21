package houserent.view;

import houserent.domain.House;
import houserent.service.HouseService;
import houserent.utils.Utility;

import java.util.Scanner;

public class HouseView {
    private boolean loop = true;
    private char choice;
    private HouseService houseService = new HouseService(2);

    public void mainMenu() {
        while (loop) {
            System.out.println("\n-----------------房屋出租系统菜单-----------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.print("请输入你的选择(1-6): ");

            choice = Utility.readChar();
            switch (choice) {
                case '1':
                    addHouse();
                    break;
                case '2':
//                    findHouse();
                    System.out.println("find");
                    break;
                case '3':
//                    delHouse();
                    System.out.println("delete");
                    break;
                case '4':
//                    updateHouse();
                    System.out.println("update");
                    break;
                case '5':
                    listHouse();
//                    System.out.println("listHouse");
                    break;
                case '6':
//                    exit();
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("输入有误。");
                    break;
            }
        }
    }

    public void addHouse() {
        System.out.println("=============添加房屋============");
        System.out.println("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态: ");
        String state = Utility.readString(3);

        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("-----------------添加房屋成功-----------------");
        } else {
            System.out.println("-----------------添加房屋失败-----------------");
        }
    }

    public void listHouse() {
        System.out.println("-----------------房屋列表-----------------");
        System.out.println("编号\t\t房主\t\t电话\t\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("-----------------房屋列表显示完毕-----------------");
    }
}
