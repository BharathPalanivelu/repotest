package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;

public class EtoeMessageItem implements Serializable {
    public String content;
    public int type = -1;
    public int user_id;

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int i) {
        this.user_id = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getContent() {
        String str = this.content;
        return str == null ? "" : str;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
