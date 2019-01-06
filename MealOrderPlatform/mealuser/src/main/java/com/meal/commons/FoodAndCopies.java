package com.meal.commons;

import java.util.Date;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/31 19:46
 * @Author: QiXiao
 * @Description:
 */
public class FoodAndCopies {
    private int amount;
    private String id;

    private String foodname;

    private String description;

    private Float originPrice;

    private String tagid;

    private Float price;

    private String sellerid;

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
        this.id = id == null ? null : id.trim();
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

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid == null ? null : tagid.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid == null ? null : sellerid.trim();
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
