package com.example.mag.cs321app;

/**
 * Created by PamelaPhan on 4/23/17.
 */

public class Blog {
    private String title;
    private String desc;
    private String time;
    private String image;


    public Blog(){

    }

    public Blog(String title, String desc, String time, String image) {
        this.title = title;
        this.desc = desc;
        this.time = time;
        this.image = image;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}
