package com.example.versionfour.ui.forums;

public class CultureModel {
    Integer culturePics;
    String cultureDesc;

    public CultureModel(Integer culturePics,String cultureDesc){
        this.culturePics = culturePics;
        this.cultureDesc = cultureDesc;
    }

    public Integer getCulturePics(){
        return culturePics;
    }
    public String getCultureDesc(){
        return cultureDesc;
    }
}
