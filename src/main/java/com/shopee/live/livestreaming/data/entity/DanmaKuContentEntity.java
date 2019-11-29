package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;

public class DanmaKuContentEntity implements Serializable {
    private String content;
    private int type;

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
