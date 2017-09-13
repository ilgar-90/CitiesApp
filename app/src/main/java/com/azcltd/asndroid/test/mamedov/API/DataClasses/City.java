package com.azcltd.asndroid.test.mamedov.API.DataClasses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ilgar on 9/11/2017.
 */

public class City implements Serializable {
    private String id;

    private Location location;

    @SerializedName("image_url")
    private String imageUrl;

    private String description;

    private String name;

    private Country country;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Country getCountry ()
    {
        return country;
    }

    public void setCountry (Country country)
    {
        this.country = country;
    }

}
