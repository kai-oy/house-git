package com.example.house.Service.ServiceImpl;

import com.example.house.Dao.StreetDao;
import com.example.house.Entity.Street;
import com.example.house.Service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetDao streetDao;

    /**
     * @param dId 返回根据区域id查询street表中的结果集
     * @return
     */
    @Override
    public List<Street> queryStreet(String dId) {
        return streetDao.queryStreet(dId);
    }

    /**
     * @param id 返回根据id查询street表中的结果集
     * @return
     */
    @Override
    public Street queryStreetId(int id) {
        return streetDao.queryStreetId(id);
    }

    /**
     * @param street 添加
     * @return
     */
    @Override
    public int addStreet(Street street) {
        return streetDao.addStreet(street);
    }
}
