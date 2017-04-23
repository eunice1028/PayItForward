package com.example.mag.cs321app;

/**
 * Created by PamelaPhan on 4/23/17.
 */

public class Blog {
    private String title, description, time;

    public Blog(){

    }

    public Blog(String title, String description, String time) {
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
