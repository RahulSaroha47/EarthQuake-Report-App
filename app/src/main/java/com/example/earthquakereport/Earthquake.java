package com.example.earthquakereport;

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private long mDate;
    private String mURL;

    public Earthquake(double magnitude, String location, long date, String URL)
    {
        mMagnitude=magnitude;
        mLocation=location;
        mDate=date;
        mURL= URL;
    }
    public double getMagnitude()
    {
        return mMagnitude;
    }
    public String getLocation()
    {
        return mLocation;
    }

    public long getDate()
    {
        return mDate;
    }

    public String getURL(){return mURL;}
}
