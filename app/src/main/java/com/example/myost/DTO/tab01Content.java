package com.example.myost.DTO;

public class tab01Content {
    private Integer tab01AvatarId;
    private String tab01Name;
    private String tab01Content;
    private String tab01Time;



    public tab01Content(Integer tab01AvaterId, String tab01Name, String tab01Content, String tab01Time) {
        this.tab01AvatarId = tab01AvaterId;
        this.tab01Name = tab01Name;
        this.tab01Content = tab01Content;
        this.tab01Time = tab01Time;

    }

    public tab01Content() {

    }

    public Integer gettab01AvaterId() {
        return tab01AvatarId;
    }

    public void settab01AvaterId(Integer tab01AvaterId) {
        this.tab01AvatarId = tab01AvaterId;
    }

    public String gettab01Name() {
        return tab01Name;
    }

    public void settab01Name(String tab01Name) {
        this.tab01Name = tab01Name;
    }

    public String gettab01Content() {
        return tab01Content;
    }

    public void settab01Content(String tab01Content) {
        this.tab01Content = tab01Content;
    }

    public String gettab01Time() {
        return tab01Time;
    }

    public void settab01Time(String tab01Time) {
        this.tab01Time = tab01Time;
    }

}