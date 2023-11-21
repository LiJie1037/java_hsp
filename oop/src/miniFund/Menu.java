package miniFund;


import java.util.Scanner;

class Menu {
    public void show() {
        System.out.println("------------零钱通菜单------------");
        System.out.println("1 零钱通明细");
        System.out.println("2 收益入账");
        System.out.println("3 消费");
        System.out.println("4 退出");
        System.out.println();
        System.out.println("请选择(1-4):");
    }

    public int choice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}