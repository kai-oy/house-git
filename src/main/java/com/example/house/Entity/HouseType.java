package com.example.house.Entity;

/**
 * 房屋类型实体类
 */
public class HouseType {
    private int id;
    private String name;

    public HouseType() {
    }

    public HouseType(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "HouseType{id=" + id + "name=" + name + "}";
    }
}
