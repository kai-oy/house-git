package com.example.house.Entity;

import java.util.Date;

public class HoustTwo {
    private int id;
    private Users user;
    private HouseType type;
    private String title;
    private String description;
    private String price;
    private Date pubDate;
    private int floorage;
    private String contact;
    private Street street;

    public HoustTwo() {
    }

    public HoustTwo(int id, Users user, HouseType type, String title, String description, String price, Date pubDate, int floorage, String contact, Street street) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.title = title;
        this.description = description;
        this.price = price;
        this.pubDate = pubDate;
        this.floorage = floorage;
        this.contact = contact;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public HouseType getType() {
        return type;
    }

    public void setType(HouseType type) {
        this.type = type;
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

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "HoustTwo{" +
                "id=" + id +
                ", user=" + user +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", pubDate=" + pubDate +
                ", floorage=" + floorage +
                ", contact='" + contact + '\'' +
                ", street=" + street +
                '}';
    }
}
