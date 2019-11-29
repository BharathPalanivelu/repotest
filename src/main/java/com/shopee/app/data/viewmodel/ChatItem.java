package com.shopee.app.data.viewmodel;

public class ChatItem {
    private long chatId;
    private int chatType;
    private int flag;
    private int messageTime;
    private long modelId;

    public long getChatId() {
        return this.chatId;
    }

    public void setChatId(long j) {
        this.chatId = j;
    }

    public int getChatType() {
        return this.chatType;
    }

    public void setChatType(int i) {
        this.chatType = i;
    }

    public int getMessageTime() {
        return this.messageTime;
    }

    public void setMessageTime(int i) {
        this.messageTime = i;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setModelId(long j) {
        this.modelId = j;
    }

    public long getModelId() {
        return this.modelId;
    }
}
