package com.example.home.bngapp.classes;

/**
 * Created by faigy on 6/7/2016.
 */
public class LocationItems {

    int id;
    String title;
    String zip;
    String phone;
    String image;

    public LocationItems() {

    }

    public LocationItems(int id, String title, String zip, String phone) {
        this.id = id;
        this.title = title;
        this.zip = zip;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
