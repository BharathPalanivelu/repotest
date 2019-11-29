package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class CaptionTagEntity implements Serializable {
    private String id;
    private String name;
    private long num;
    private int type;
    private String url;

    public String getUrl() {
        String str = this.url;
        return str == null ? "" : str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public long getNum() {
        return this.num;
    }

    public void setNum(long j) {
        this.num = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getId() {
        String str = this.id;
        return str == null ? "" : str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
