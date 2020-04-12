package com.example.house.Service.ServiceImpl;

import com.example.house.Dao.HouseTypeDao;
import com.example.house.Entity.HouseType;
import com.example.house.Service.HouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseTypeServiceImpl implements HouseTypeService {

    @Autowired
   private HouseTypeDao houseTypeDao;

    /**
     * @return 返回
     */
    @Override
    public List<HouseType> queryHouseType() {
        return houseTypeDao.queryHouseType();
    }

    /**
     * @param id 返回根据id查询housetype中类型结果集
     * @return
     */
    @Override
    public HouseType queryHouseTypeId(int id) {
        return houseTypeDao.queryHouseTypeId(id);
    }

    /**
     * @param houseType 返回housetype添加数据是否成功结果集
     * @return
     */
    @Override
    public int addHouseType(HouseType houseType) {
        return houseTypeDao.addHouseType(houseType);
    }
}
