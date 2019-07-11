package com.example.manne.json.Models;

import java.io.Serializable;

/**
 * Created by manne on 11.7.2019.
 */

public class Subscriber implements Serializable{
    public String name;
    public String imgUrl;

    public  Subscriber(String name, String imgUrl){
        this.name = name;
        this.imgUrl= imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
