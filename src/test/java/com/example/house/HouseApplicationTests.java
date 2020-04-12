package com.example.house;

import com.example.house.Config.Md5;
import com.example.house.Dao.DistrictDao;
import com.example.house.Dao.HouseDao;
import com.example.house.Dao.UsersDao;
import com.example.house.Entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HouseApplicationTests {

    @Autowired
    HouseDao districtDao;

    @Test
    void contextLoads() {
        System.out.println(Md5.getMD5("123456"));
    }
}
