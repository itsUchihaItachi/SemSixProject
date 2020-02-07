package com.example.versionfour.ui.news;

public class event {

    private String eventname;
    private String startdate;
    private String starttime;
    private String enddate;
    private String endtime;
    private String eventlink;
    private String cretedby;

    public event(){
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
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

    public String getCretedby() {
        return cretedby;
    }

    public void setCretedby(String cretedby) {
        this.cretedby = cretedby;
    }
}
