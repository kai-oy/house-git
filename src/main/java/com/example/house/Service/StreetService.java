package com.example.house.Service;

import com.example.house.Entity.Street;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public interface StreetService {
    public List<Street> queryStreet(String dId);

    public Street queryStreetId(int id);

    public int addStreet(Street street);
}
