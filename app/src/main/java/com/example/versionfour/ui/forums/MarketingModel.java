package com.example.versionfour.ui.forums;

class MarketingModel {
    Integer marketingPics;
    String marketingDesc;

    public MarketingModel(Integer marketingPics,String marketingDesc){
        this.marketingPics = marketingPics;
        this.marketingDesc = marketingDesc;
    }

    //langlogo fun
    public Integer getMarketingPics(){
        return marketingPics;
    }
    //langName fun
    public String getMarketingDesc(){
        return marketingDesc;
    }
}