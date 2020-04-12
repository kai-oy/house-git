package com.example.house.Service.ServiceImpl;

import com.example.house.Config.Md5;
import com.example.house.Dao.UsersDao;
import com.example.house.Entity.Users;
import com.example.house.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public Users queryNameUsers(String name, String pwd) {
        pwd = Md5.getMD5(pwd);
        return usersDao.queryNameUsers(name, pwd);
    }

    @Override
    public List<Users> queryUsersAll() {
        return usersDao.queryUsersAll();
    }

    @Override
    public int addUsers(Users users) {
        users.setPassword(Md5.getMD5(users.getPassword()));
        return usersDao.addUsers(users);
    }

    @Override
    public Boolean queryTelUser(String tel) {
        Users users = usersDao.queryTelUser(tel);
        if (users != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean queryNameUser(String name) {
        Users users = usersDao.queryNameUser(name);
        if (users != null) {
            return true;
        } else {
            return false;
        }
    }
}
