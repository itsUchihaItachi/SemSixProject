package com.example.versionfour.ui.forums;

class PhotographyModel {
    Integer photographyPics;
    String photographyDesc;

    public PhotographyModel(Integer photographyPics,String photographyDesc){
        this.photographyPics = photographyPics;
        this.photographyDesc = photographyDesc;
    }

    //langlogo fun
    public Integer getPhotographyPics(){
        return photographyPics;
    }
    //langName fun
    public String getPhotographyDesc(){
        return photographyDesc;
    }
}
