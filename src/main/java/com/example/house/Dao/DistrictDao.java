package com.example.house.Dao;

import com.example.house.Entity.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DistrictDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @return 查询district表中所有数据
     */
    public List<District> queryDistrictAll() {
        String sql = "select * from district";
        List<District> allDistrictList =null;
        try {
            allDistrictList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(District.class));
        }catch (EmptyResultDataAccessException e){

        }
        return allDistrictList;
    }

    /**
     * @param id 根据id查询district表中数据
     * @return
     */
    public District queryDistrictId(int id) {
        String sql = "select * from district where id = ?";
        District district = null;
        try {
            district = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(District.class), id);
        }catch (EmptyResultDataAccessException e){

        }
        return district;
    }

    /**
     * @param district 增加
     * @return
     */
    public int addDistrict(District district) {
        String sql = "insert into district(name ) value (?)";
        int i = jdbcTemplate.update(sql, district.getName());
        return i;
    }
}
