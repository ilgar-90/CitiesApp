package com.azcltd.asndroid.test.mamedov.API.DataClasses;

import java.io.Serializable;

/**
 * Created by ilgar on 9/11/2017.
 */

public class Location implements Serializable {
    private double longitude;

    private double latitude;

    public double getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (double longitude)
    {
        this.longitude = longitude;
    }

    public double getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (double latitude)
    {
        this.latitude = latitude;
    }
}
