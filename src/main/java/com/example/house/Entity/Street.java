package com.example.house.Entity;

/**
 * 街道类实体类
 */
public class Street {
    private int id;
    private String name;
    private int districtId;

    public Street() {
    }

    public Street(int id, String name, int districtId) {
        this.id = id;
        this.name = name;
        this.districtId = districtId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", districtId=" + districtId +
                '}';
    }
}
