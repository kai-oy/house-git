package com.example.house.Dao;

import com.example.house.Entity.District;
import com.example.house.Entity.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StreetDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @param dId 根据区域id查询street表数据
     * @return
     */
    public List<Street> queryStreet(String dId) {
        String sql = "select * from street where district_Id=?";
        List<Street> streetList = null;
        try {
            streetList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Street.class),dId);
        } catch (EmptyResultDataAccessException e) {

        }
        return streetList;
    }

    /**
     * @param id 根据id查询street表数据
     * @return
     */
    public Street queryStreetId(int id) {
        String sql = "select * from Street where id = ?";
        Street street = null;
        try {
            street = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Street.class), id);
        } catch (EmptyResultDataAccessException e) {

        }
        return street;
    }

    /**
     * @param street 添加
     * @return
     */
    public int addStreet(Street street) {
        String sql = "insert into Street(name ) value (?)";
        int i = jdbcTemplate.update(sql, street.getName());
        return i;
    }
}
