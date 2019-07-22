package com.example.manne.json;

import android.app.Activity;
import android.content.Context;

import com.example.manne.json.Models.Preview;
import com.example.manne.json.Models.User;
import com.google.gson.Gson;

public class SharedPreferences {

    private static final String USERID = "USERID";
    private static final String USER = "";

    public static void addUser(User user, Context c) {
        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        getPreferences(c).edit().putString(USER, mapString).apply();
    }

    public static User getUser(Context c) {
        return new Gson().fromJson(getPreferences(c).getString(USER, ""), User.class);
    }

    public static void addPreview(Preview preview,Context c){
        Gson gson = new Gson();
        String mapString = gson.toJson(preview);
        getPreferences(c).edit().putString("PREVIEW", mapString).apply();
    }
    public static Preview getPreview(Context c){
        return new Gson().fromJson(getPreferences(c).getString("PREVIEW", ""), Preview.class);
    }

    public static void setUserID(String username, Context c) {
        getPreferences(c).edit().putString("username", username).apply();
    }

    public static String getUserID(Context c) {
        return getPreferences(c).getString("username", "");
    }

    private  static android.content.SharedPreferences getPreferences(Context c){
        return c.getApplicationContext().getSharedPreferences("MySharedPreferences", Activity.MODE_PRIVATE);
    }

}
