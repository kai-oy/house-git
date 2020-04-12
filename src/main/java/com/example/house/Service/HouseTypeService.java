package com.example.house.Service;

import com.example.house.Entity.HouseType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public interface HouseTypeService {
    public List<HouseType> queryHouseType();

    public HouseType queryHouseTypeId(int id);

    public int addHouseType(HouseType houseType);
}
