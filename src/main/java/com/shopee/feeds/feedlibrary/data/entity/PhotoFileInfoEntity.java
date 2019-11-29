package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class PhotoFileInfoEntity implements Serializable {
    private String filePath;
    private int heightPixels;
    private int widthPixels;

    public PhotoFileInfoEntity(String str, int i, int i2) {
        this.filePath = str;
        this.widthPixels = i;
        this.heightPixels = i2;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public int getWidthPixels() {
        return this.widthPixels;
    }

    public void setWidthPixels(int i) {
        this.widthPixels = i;
    }

    public int getHeightPixels() {
        return this.heightPixels;
    }

    public void setHeightPixels(int i) {
        this.heightPixels = i;
    }
}
