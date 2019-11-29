package com.shopee.app.data.viewmodel.chat;

public class ChatImageMessage extends ChatMessage {
    private String imageUrl;
    private int thumbHeight;
    private String thumbUrl;
    private int thumbWidth;

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setThumbWidth(int i) {
        this.thumbWidth = i;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public void setThumbHeight(int i) {
        this.thumbHeight = i;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }
}
