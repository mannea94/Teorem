package com.example.manne.json.Models;

import java.io.Serializable;

/**
 * Created by manne on 12.7.2019.
 */

public class ShopData implements Serializable {
    public String imgUrl;
    public String name;
    public String time;
    public String imgUrl1;
    public String imgUrl2;
    public String imgUrl3;

    public ShopData(String imgUrl, String name, String time, String imgUrl1, String imgUrl2, String imgUrl3 ){
        this.imgUrl=imgUrl;
        this.name=name;
        this.time=time;
        this.imgUrl1=imgUrl1;
        this.imgUrl2=imgUrl2;
        this.imgUrl3=imgUrl3;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public void setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
    }
}
