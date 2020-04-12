package com.example.house.Entity;

/**
 * users用户表实体类
 */
public class Users {
    private int id;
    private String name;
    private String password;
    private String telePhone;
    private String userName;
    private String isAdmin;

    public Users() {
    }

    public Users(int id, String name, String password, String telePhone, String userName, String isAdmin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telePhone = telePhone;
        this.userName = userName;
        this.isAdmin = isAdmin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelePhine() {
        return telePhone;
    }

    public void setTelePhine(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telePhine='" + telePhone + '\'' +
                ", userName='" + userName + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                '}';
    }
}
