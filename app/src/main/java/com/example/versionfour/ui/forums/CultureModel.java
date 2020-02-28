package com.example.versionfour.ui.forums;

public class CultureModel {
    Integer culturePics;
    String cultureDesc;

    public CultureModel(Integer culturePics,String cultureDesc){
        this.culturePics = culturePics;
        this.cultureDesc = cultureDesc;
    }

    //langlogo fun
    public Integer getCulturePics(){
        return culturePics;
    }
    //langName fun
    public String getCultureDesc(){
        return cultureDesc;
    }
}
