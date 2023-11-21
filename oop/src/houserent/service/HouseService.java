package houserent.service;

import houserent.domain.House;

public class HouseService {
    private House[] houseArr;
    int idCounter = 1;
    private int houseNums = 1;  // 记录当前有多少房屋数量

    public HouseService(int size) {
        houseArr = new House[size];
        // 测试
        houseArr[0] = new House(1, "hang", "12345678910", "wuhan", 4000, "已出租");
    }

    public House[] list() {
        return houseArr;
    }

    public boolean add(House house) {
        if (houseNums == houseArr.length) {
            System.out.println("数组已满，不能再添加了。");
            return false;
        }
        houseArr[houseNums++] = house;
        house.setId(++idCounter);
        return true;
    }


}
