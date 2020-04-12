package com.example.house.Service.ServiceImpl;

import com.example.house.Dao.HouseDao;
import com.example.house.Entity.House;
import com.example.house.Entity.HouseVoAllTable;
import com.example.house.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
   private HouseDao houseDao;

    /**
     * @return 返回house表中所有数据
     */
    @Override
    public List<House> queryHouse() {
        return houseDao.queryHouse();
    }

    /**
     * @param id 返回根据id查询到的house表中的数据
     * @return
     */
    @Override
    public House queryHouseId(int id) {
        return houseDao.queryHouseId(id);
    }

    /**
     * @param house 添加house表数据
     * @return
     */
    @Override
    public int addHouse(House house) {
        return houseDao.addHouse(house);
    }

    /**
     * @return 返回 house表中prict结果集
     */
    @Override
    public List<House> queryHouseByPrice() {
        return houseDao.queryHouseByPrice();
    }

    /**
     * @return 返回house表中floorage结果集
     */
    @Override
    public List<House> queryHouseByFloorage() {
        return houseDao.queryHouseByFloorage();
    }

    /**
     * @param rownum 返回根据条件查询到的 house表详细信息结果集
     * @param price
     * @param uId
     * @param title
     * @param streetid
     * @param districtId
     * @param houseTypeId
     * @param floorage
     * @return
     */
    @Override
    public List<HouseVoAllTable> queryHouseConAllTable(int rownum,int price,int uId, String title, int streetid, int districtId, int houseTypeId, int floorage) {
        return houseDao.queryHouseConAllTable(rownum,price,uId,title,streetid,districtId,houseTypeId,floorage);
    }

    /**
     * @param price 根据条件返回house表中所有数据的总数
     * @param uId
     * @param title
     * @param streetid
     * @param districtId
     * @param houseTypeId
     * @param floorage
     * @return
     */
    public int countHouseNumber(int price, int uId, String title, int streetid, int districtId, int houseTypeId, int floorage){
        return houseDao.countHouseNumber(price,uId,title,streetid,districtId,houseTypeId,floorage);
    }
    public int updateHouse(House house){
        return houseDao.updateHouse(house);
    }
    public int daleteHouse(String id){
        return houseDao.daleteHouse(id);
    }
}
