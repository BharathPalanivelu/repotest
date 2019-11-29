package com.shopee.livequiz.data.bean;

public class DanmaKuMessage {
    private String content;
    private String imageUrl;
    private String nickName;

    public DanmaKuMessage(String str, String str2, String str3) {
        this.nickName = str;
        this.imageUrl = str2;
        this.content = str3;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
