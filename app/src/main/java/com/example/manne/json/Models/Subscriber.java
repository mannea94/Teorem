package com.example.manne.json.Models;

import android.widget.Button;

import java.io.Serializable;

/**
 * Created by manne on 11.7.2019.
 */

public class Subscriber implements Serializable{
    public String name;
    public String imgUrl;
    public String time;
    public String message;


    public Subscriber(String imgUrl){
        this.imgUrl=imgUrl;
    }

    public  Subscriber(String name, String imgUrl){
        this.name = name;
        this.imgUrl= imgUrl;
    }

    public Subscriber(String name, String time, String message){
        this.name = name;
        this.time=time;
        this.message=message;

    }

    public  Subscriber(String name, String time, String message, String imgUrl){
        this.name = name;
        this.imgUrl= imgUrl;
        this.time=time;
        this.message=message;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
