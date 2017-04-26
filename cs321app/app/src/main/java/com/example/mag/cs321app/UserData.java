package com.example.mag.cs321app;

/**
 * Created by smashking on 4/25/17.
 */

public class UserData {
    private String firstName;
    private String lastName;
    private String gender;
    private int points;

    public UserData(String firstName, String lastName, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.points = 10;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getGender(){
        return gender;
    }

    public int getPoints(){
        return points;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public void setGender(String gen){
        this.gender = gen;
    }

    public void addPoints(int toAdd){
        this.points += toAdd;
    }
}
