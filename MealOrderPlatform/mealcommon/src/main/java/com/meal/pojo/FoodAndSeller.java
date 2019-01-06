package com.meal.pojo;

import java.util.Date;

public class FoodAndSeller {
    private String id;

    private String foodname;

    private String description;

    private Float originPrice;

    private Classify tag;

    private Float price;

    private Seller seller;

    private Float score;

    private Integer status;

    private Date applicationtime;

    private Date thoughtime;

    private Date undercarriagetime;

    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Float getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Float originPrice) {
        this.originPrice = originPrice;
    }

    public Classify getTag() {
        return tag;
    }

    public void setTag(Classify tag) {
        this.tag = tag;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(Date applicationtime) {
        this.applicationtime = applicationtime;
    }

    public Date getThoughtime() {
        return thoughtime;
    }

    public void setThoughtime(Date thoughtime) {
        this.thoughtime = thoughtime;
    }

    public Date getUndercarriagetime() {
        return undercarriagetime;
    }

    public void setUndercarriagetime(Date undercarriagetime) {
        this.undercarriagetime = undercarriagetime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}