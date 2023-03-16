package com.qaprosoft.carina.demo.utils.utilsOnliner;

import com.qaprosoft.carina.demo.db.models.onliner.Laptop;

public class LaptopBuilder {

    public static Laptop laptopBuilder() {
        Laptop laptop = new Laptop();
        /*laptop.setNameOfLaptop(R.TESTDATA.get("test_name_of_laptop"));
        laptop.setMemory(R.TESTDATA.get("test_memory"));
        laptop.setPrice(R.TESTDATA.get("test_price"));*/
        laptop.setItemName("Игровой ноутбук Lenovo IdeaPad Gaming 3 15ARH7 82SB00KYTX");
        laptop.setItemPrice("2995,00 р.");
        return laptop;
    }

    public static Laptop createExpectedLaptop() {
        return laptopBuilder();
    }

}
