package com.example.versionfour.ui.forums;

class EntrepreneurModel {
    Integer entrepreneurPics;
    String entrepreneurDesc;

    public EntrepreneurModel(Integer entrepreneurPics,String entrepreneurDesc){
        this.entrepreneurPics = entrepreneurPics;
        this.entrepreneurDesc = entrepreneurDesc;
    }

    //langlogo fun
    public Integer getEntrepreneurPics(){
        return entrepreneurPics;
    }
    //langName fun
    public String getEntrepreneurDesc(){
        return entrepreneurDesc;
    }
}
