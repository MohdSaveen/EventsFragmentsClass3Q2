package com.example.eventsfragmentsclass3q2;

import java.io.Serializable;

public class Model implements Serializable {

    private String title;
    private String desc;
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;
    private String price;

    public Model(String title, String desc, String startTime, String endTime, String startDate, String endDate, String price) {
        this.title = title;
        this.desc = desc;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPrice() {
        return price;
    }
}
