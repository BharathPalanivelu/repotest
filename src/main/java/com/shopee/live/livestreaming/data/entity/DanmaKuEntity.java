package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;

public class DanmaKuEntity implements Serializable {
    public static final int MESSAGE_ANCHOR = 101;
    public static final int MESSAGE_AUDIENCE = 100;
    public static final int MESSAGE_PUBLIC = 201;
    public static final int MESSAGE_WELCOME = 200;
    public String avatar;
    public String content;
    public long id;
    private int messageType;
    public String nickname;
    private long uid;

    public long getUid() {
        return this.uid;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getNickname() {
        String str = this.nickname;
        return str == null ? "" : str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getAvatar() {
        String str = this.avatar;
        return str == null ? "" : str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String getContent() {
        String str = this.content;
        return str == null ? "" : str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public boolean isAudienceMessage() {
        return this.messageType == 100;
    }

    public boolean isAuchorMessage() {
        return this.messageType == 101;
    }

    public boolean isPublicMessge() {
        return this.messageType == 201;
    }
}
