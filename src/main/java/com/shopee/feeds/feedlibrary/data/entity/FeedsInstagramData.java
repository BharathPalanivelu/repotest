package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class FeedsInstagramData implements Serializable {
    private String description;
    private int height;
    private String id;
    private String image;
    private String thumbnail;
    private int type;
    private int width;

    public String getThumbnail() {
        String str = this.thumbnail;
        return str == null ? "" : str;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getImage() {
        String str = this.image;
        return str == null ? "" : str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getDescription() {
        String str = this.description;
        return str == null ? "" : str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getId() {
        String str = this.id;
        return str == null ? "" : str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public boolean isSameImage(FeedsInstagramData feedsInstagramData) {
        try {
            return feedsInstagramData.getImage().equals(this.image);
        } catch (Exception unused) {
            return false;
        }
    }
}
