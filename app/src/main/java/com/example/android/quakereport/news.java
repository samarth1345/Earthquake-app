package com.example.android.quakereport;

public class news {
    private String place;
    private double magnitude;
    private long timeinMilliseconds;
    news(String place,double magnitude,long timeinMilliseconds)
    {
        this.timeinMilliseconds=timeinMilliseconds;
        this.magnitude=magnitude;
        this.place=place;
    }
    String getPlace()
    {
        return place;
    }
    long getTime()
    {
        return timeinMilliseconds;
    }
    double getMagnitude()
    {
        return magnitude;
    }
}
