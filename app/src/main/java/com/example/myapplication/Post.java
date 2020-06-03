package com.example.myapplication;

public class Post {

    public String firstStartTime;
    public String firstEndTime;
    public String temperature;
    public String secondStartTime;
    public String secondEndTime;
    public String temperature2;
    public String thirdStartTime;
    public String thirdEndTime;
    public String temperature3;

    public Post(String firstStartTime,
                String firstEndTime, String temperature, String secondStartTime, String secondEndTime, String temperature2, String thirdStartTime,
                String thirdEndTime, String temperature3) {
        this.firstStartTime = firstStartTime;
        this.firstEndTime = firstEndTime;
        this.temperature = temperature;
        this.secondStartTime = secondStartTime;
        this.secondEndTime = secondEndTime;
        this.temperature2 = temperature2;
        this.thirdStartTime = thirdStartTime;
        this.thirdEndTime = thirdEndTime;
        this.temperature3 = temperature3;
    }

}