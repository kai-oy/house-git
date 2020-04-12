package com.example.house.Entity;

import java.util.Date;

public class HouseVoAllTable {
    private int id;
    private String contact;
    private String username;
    private String title;
    private String description;
    private double price;
    private Date pubdate;
    private String typeName;
    private String streetName;
    private String distriName;
    private int floorage;
    private int distriId;
    private int userId;

    public HouseVoAllTable() {
    }

    public HouseVoAllTable(int userId, int distriId, int id, String contact, String username, String title, String description, double price, Date pubdate, String typeName, String streetName, String distriName, int floorage) {
        this.id = id;
        this.contact = contact;
        this.username = username;
        this.title = title;
        this.description = description;
        this.price = price;
        this.pubdate = pubdate;
        this.typeName = typeName;
        this.streetName = streetName;
        this.distriName = distriName;
        this.floorage = floorage;
        this.distriId = distriId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDistriName() {
        return distriName;
    }

    public void setDistriName(String distriName) {
        this.distriName = distriName;
    }

    public int getFloorage() {
        return floorage;
    }

    public void setFloorage(int floorage) {
        this.floorage = floorage;
    }

    public int getDistriId() {
        return distriId;
    }

    public void setDistriId(int distriId) {
        this.distriId = distriId;
    }

    @Override
    public String toString() {
        return "HouseVoAllTable{" +
                "contact='" + contact + '\'' +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", pubdate=" + pubdate +
                ", typeName='" + typeName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", distriName='" + distriName + '\'' +
                ", floorage=" + floorage +
                ", distriId=" + distriId +
                '}';
    }
}
