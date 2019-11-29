package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class FollowingPosEntity implements Serializable {
    private String name;
    private int user_id;

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int i) {
        this.user_id = i;
    }
}
