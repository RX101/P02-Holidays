package com.example.a15041867.p02_holidays;

/**
 * Created by 15041867 on 27/4/2017.
 */

public class holidays {
    private String name;
    private String date;
    private String desc;

    public holidays(String name, String date, String desc) {
        this.name = name;
        this.date = date;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
