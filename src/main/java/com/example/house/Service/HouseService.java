package com.example.house.Service;

import com.example.house.Entity.House;
import com.example.house.Entity.HouseVoAllTable;

import java.util.List;

public interface HouseService {
    public List<House> queryHouse();
    public int updateHouse(House house);
    public int daleteHouse(String id);

    public House queryHouseId(int id);

    public int addHouse(House house);

    public List<House> queryHouseByPrice();

    public List<House> queryHouseByFloorage();

    public List<HouseVoAllTable> queryHouseConAllTable(int rownum,int price,int uId, String title, int streetid, int districtId, int houseTypeId, int floorage);

    public int countHouseNumber(int price, int uId, String title, int streetid, int districtId, int houseTypeId, int floorage);
}
