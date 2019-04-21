package com.example.jiaming.dataretrive;

public class Reponse {
    private int ID;
    private String title;
    private String url;

    Reponse(int ID, String title, String url){
        this.ID = ID;
        this.title = title;
        this.url = url;
    }
    public int getID(){
        return ID;
    }

    public String getTitle(){
        return title;
    }

    public String getUrl(){
        return url;
    }
}
