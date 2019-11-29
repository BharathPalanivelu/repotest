package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class OriginImageInfo implements Serializable {
    private int original_file_size;
    private String original_resolution;

    public String getOriginal_resolution() {
        String str = this.original_resolution;
        return str == null ? "" : str;
    }

    public void setOriginal_resolution(String str) {
        this.original_resolution = str;
    }

    public int getOriginal_file_size() {
        return this.original_file_size;
    }

    public void setOriginal_file_size(int i) {
        this.original_file_size = i;
    }
}
