package com.example.versionfour.ui.links;

public class LinksViewModel {
    public String nameOfLink;
    public String url;

    public LinksViewModel(String nameOfLink, String url){
        this.url= url;
        this.nameOfLink= nameOfLink;
    }

    public String getNameOfLink(){
        return nameOfLink;
    }

    public String getUrl(){
        return url;
    }
}
