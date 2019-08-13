package com.entity;

import java.sql.Date;

public class GoodsInfo {
    private int id;
    private String gname;
    private String picture ;
    private double price;
    private String description;
    private int stock;
    private boolean flag;
    private String created;
    private Date createDate;

    public GoodsInfo() {
    }

    public GoodsInfo(int id, String gname, String picture, double price, String description,
                     int stock, boolean flag, String created, Date createDate) {
        this.id = id;
        this.gname = gname;
        this.picture = picture;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.flag = flag;
        this.created = created;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int  getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "gid=" + id +
                ", gname='" + gname + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock='" + stock + '\'' +
                ", flag=" + flag +
                ", created='" + created + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
