package com.example.versionfour.ui.news;

public class Post {

    //public String createby;
    public String enddate;
    public String endtime;
    public String eventlink;
    public String eventname;
    public String eventplace;
    public String startdate;
    public String starttime;

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getEventlink() {
        return eventlink;
    }

    public void setEventlink(String eventlink) {
        this.eventlink = eventlink;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventplace() {
        return eventplace;
    }

    public void setEventplace(String eventplace) {
        this.eventplace = eventplace;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "enddate='" + enddate + '\'' +
                ", endtime='" + endtime + '\'' +
                ", eventlink='" + eventlink + '\'' +
                ", eventname='" + eventname + '\'' +
                ", eventplace='" + eventplace + '\'' +
                ", startdate='" + startdate + '\'' +
                ", starttime='" + starttime + '\'' +
                '}';
    }
}
