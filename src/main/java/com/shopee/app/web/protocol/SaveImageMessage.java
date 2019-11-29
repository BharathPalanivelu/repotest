package com.shopee.app.web.protocol;

public class SaveImageMessage {
    private String filename;
    private String imageUrl;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setFilename(String str) {
        this.filename = str;
    }
}
