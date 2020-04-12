package com.example.house.Service;

import com.example.house.Entity.Users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public interface UsersService {
    public Users queryNameUsers(String name,String pwd);

    public List<Users> queryUsersAll();

    public int addUsers(Users users);

    public Boolean queryNameUser(String name);

    public Boolean queryTelUser(String tel);
}

