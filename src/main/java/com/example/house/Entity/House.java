package com.example.house.Entity;

import java.util.Date;

/**
 * 房屋信息实体类
 */
public class House {
    private int id;
    private int userId;
    private int typeId;
    private String title;
    private String description;
    private String price;
    private Date pubDate;
    private int floorage;
    private String contact;
    private int streetId;
    private  int districtId;

    public House() {
    }

    public House(int id, int userId, int typeId, String title, String description, String price, Date pubDate, int floorage, String contact, int streetId,int districtId) {
        this.id = id;
        this.userId = userId;
        this.typeId = typeId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.pubDate = pubDate;
        this.floorage = floorage;
        this.contact = contact;
        this.streetId = streetId;
        this.districtId = districtId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public int getFloorage() {
        return floorage;
    }

    public void setFloorage(int floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }


    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", title='" + title +
                ", description='" + description +
                ", price='" + price +
                ", pubDate=" + pubDate +
                ", floorage=" + floorage +
                ", contact='" + contact +
                ", streetID=" + streetId +
                ", districtId=" + districtId +
                '}';
    }
}
