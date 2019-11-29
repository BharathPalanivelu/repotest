package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;

public class PlayUrlEntity implements Serializable {
    private String play_url;

    public String getPlay_url() {
        return this.play_url;
    }

    public void setPlay_url(String str) {
        this.play_url = str;
    }
}
