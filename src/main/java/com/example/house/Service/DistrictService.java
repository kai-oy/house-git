package com.example.house.Service;

import com.example.house.Entity.District;

import java.util.List;

public interface DistrictService {
    public  abstract List<District> queryDistrictAll();

    public  District queryDistrictId(int id);

    public int addDistrict(District district);
}
