package com.example.myost.DTO;

public class tab01detailContent {
    private Integer tab01detailAvatarId;
    private String tab01detailContent;
    private String tab01detailTime;


    public tab01detailContent(Integer tab01detailAvatarId, String tab01detailContent, String tab01detailTime) {
        this.tab01detailAvatarId = tab01detailAvatarId;
        this.tab01detailContent = tab01detailContent;
        this.tab01detailTime = tab01detailTime;

    }

    public tab01detailContent() {

    }

    public Integer gettab01detailAvaterId() {
        return tab01detailAvatarId;
    }

    public void settab01detailAvaterId(Integer tab01AvaterId) {
        this.tab01detailAvatarId = tab01AvaterId;
    }

    public String gettab01detailContent() {
        return tab01detailContent;
    }

    public void settab01detailContent(String tab01Content) {
        this.tab01detailContent = tab01Content;
    }

    public String gettab01detailTime() {
        return tab01detailTime;
    }

    public void settab01detailTime(String tab01Time) {
        this.tab01detailTime = tab01Time;
    }
}