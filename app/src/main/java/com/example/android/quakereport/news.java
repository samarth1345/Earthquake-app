package com.example.android.quakereport;

public class news {
    private String place;
    private String url;
    private double magnitude;
    private long timeinMilliseconds;
    news(String place,double magnitude,long timeinMilliseconds,String url)
    {
        this.timeinMilliseconds=timeinMilliseconds;
        this.magnitude=magnitude;
        this.place=place;
        this.url=url;
    }
    String getPlace()
    {
        return place;
    }
    String getUrl()
    {
        return url;
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
