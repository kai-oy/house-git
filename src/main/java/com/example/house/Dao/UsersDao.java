package com.example.house.Dao;

import com.example.house.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**登录
     * @param name 根据账号密码查询数据1
     * @param pwd
     * @return
     */
    public Users queryNameUsers(String name, String pwd) {
        String sql = "select * from users where username = ? and password=?";
        Users users = null;
        try {
            users = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), name, pwd);
        } catch (EmptyResultDataAccessException e) {

        }
        return users;
    }

    /**
     * @param name 按名次查询数据
     * @return
     */
    public Users queryNameUser(String name) {
        String sql = "select * from users where username = ? ";
        Users users = null;
        try {
            users = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), name);
        } catch (EmptyResultDataAccessException e) {

        }
        return users;
    }


    /**
     * @param tel 按电话号码查询数据
     * @return
     */
    public Users queryTelUser(String tel) {
        String sql = "select * from users where telephone = ? ";
        Users users = null;
        try {
            users = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), tel);
        } catch (EmptyResultDataAccessException e) {

        }
        return users;
    }

    /**
     * @return 查询所有用户
     */
    public List<Users> queryUsersAll() {
        String sql = "select * from users";
        List<Users> usersList =null;
        try {
            usersList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class));
        } catch (EmptyResultDataAccessException e){

        }
        return usersList;
    }


    /**
     * @param users 增加用户账号
     * @return
     */
    public int addUsers(Users users) {
        String sql = "insert into users(name,password,telephone,username,isadmin)value(?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, users.getName(), users.getPassword(), users.getTelePhine(), users.getUserName(), users.getIsAdmin());
        return update;
    }
}
