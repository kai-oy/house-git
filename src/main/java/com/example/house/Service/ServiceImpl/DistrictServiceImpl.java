package com.example.house.Service.ServiceImpl;

import com.example.house.Dao.DistrictDao;
import com.example.house.Entity.District;
import com.example.house.Service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictDao districtDao;

    /**
     * @return 返回dissrict表中所有数据
     */
    @Override
    public List<District> queryDistrictAll() {
        return districtDao.queryDistrictAll();
    }

    /**
     * @param id 返回按di查询的dissrict表中数据
     * @return
     */
    @Override
    public District queryDistrictId(int id) {
        return districtDao.queryDistrictId(id);
    }

    /**
     * @param district 返回是否添加成功结果集
     * @return
     */
    @Override
    public int addDistrict(District district) {
        return districtDao.addDistrict(district);
    }
}
