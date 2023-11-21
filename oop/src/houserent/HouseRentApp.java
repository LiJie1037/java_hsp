package houserent;


import houserent.domain.House;
import houserent.service.HouseService;
import houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
//        new HouseService(1);
//        House house = new House(1, "hang", "12345678910", "wuhan", 4000, "已出租");
//        System.out.println(house);
        HouseView houseView = new HouseView();
        houseView.mainMenu();
        System.out.println("已退出系统。");
    }
}
