package com.example.house.Dao;

import com.example.house.Entity.HouseType;
import com.example.house.Entity.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseTypeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @return 查询housetype中所有类型
     */
    public List<HouseType> queryHouseType() {
        String sql = "select * from HouseType";
        List<HouseType> streetList = null;
        try {
            streetList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HouseType.class));
        } catch (EmptyResultDataAccessException e) {

        }
        return streetList;
    }

    /**
     * @param id 根据id查询housetype中类型
     * @return
     */
    public HouseType queryHouseTypeId(int id) {
        String sql = "select * from HouseType where id = ?";
        HouseType houseType = null;
        try {
            houseType = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(HouseType.class), id);
        } catch (EmptyResultDataAccessException e) {

        }
        return houseType;
    }

    /**
     * @param houseType 添加
     * @return
     */
    public int addHouseType(HouseType houseType) {
        String sql = "insert into houseType(name ) value (?)";
        int i = jdbcTemplate.update(sql, houseType.getName());
        return i;
    }
}
