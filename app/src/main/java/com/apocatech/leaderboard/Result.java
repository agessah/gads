package com.apocatech.leaderboard;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("name")
    private String name;

    @SerializedName("score")
    private String score;

    @SerializedName("hours")
    private String hours;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String badgeUrl;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setScore(String score)
    {
        this.score = score;
    }

    public String getScore()
    {
        return score;
    }

    public void setHours(String hours)
    {
        this.hours = hours;
    }

    public String getHours()
    {
        return hours;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return country;
    }

    public void setBadgeUrl(String badgeUrl)
    {
        this.badgeUrl = badgeUrl;
    }

    public String getBadgeUrl()
    {
        return badgeUrl;
    }

}
