package com.shopee.app.data.viewmodel.chat;

public class ChatStickerMessage extends ChatMessage {
    private String format;
    private String packId;
    private String stickerId;

    public void setPackId(String str) {
        this.packId = str;
    }

    public void setStickerId(String str) {
        this.stickerId = str;
    }

    public String getPackId() {
        return this.packId;
    }

    public String getStickerId() {
        return this.stickerId;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public String getFormat() {
        return this.format;
    }
}
