package com.example.manne.json.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Preview implements Serializable {
    public String imgPath;
    public String vegan;
    public String name;
    public String description;
    public String price;
    public String currency;
    public String size;
    public ArrayList<String> imgPaths = new ArrayList<>();
    public ArrayList<ImagePath> imagesPath = new ArrayList<>();

    public Preview(){

    }

    public Preview(ArrayList<String> imagePaths, String name, String price, String currency, String description){
        this.imgPaths=imagePaths;
        this.name=name;
        this.price=price;
        this.currency=currency;
        this.description=description;

    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ArrayList<String> getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(ArrayList<String> imgPaths) {
        this.imgPaths = imgPaths;
    }

    public ArrayList<ImagePath> getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(ArrayList<ImagePath> imagesPath) {
        this.imagesPath = imagesPath;
    }
}
