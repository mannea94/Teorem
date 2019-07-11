package com.example.manne.json.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by manne on 04.7.2019.
 */

public class DataResponse {
    /* @SerializedName("message")
     String message;*/
    @SerializedName("data")
    UserInfo info;
    @SerializedName("status")
    String status;


    /*public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }*/

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public String getStatus() {
        return status;
    }
}
