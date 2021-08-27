package com.example.itvec.ui.notice;

public class noticeData {
    String date, title, key, length, image,time;

    public noticeData(){

    }


    public noticeData(String title, String Image, String date, String length, String Key,String time) {
        this.title = title;
        this.image = Image;
        this.date = date;
        this.key = Key;
        this.length = length;
    }


    public String getDate(){return  date;}
    public String getTitle() {
        return title;
    }
    public String getImage(){ return image;}
    public String getKey(){return key;}
    public String getLength(){return length;}


}
