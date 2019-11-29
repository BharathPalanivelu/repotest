package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class ImageStickerItemEntity implements Serializable {
    public static final String TYPE_COMMENT = "3";
    public static final String TYPE_IMAGE = "4";
    public static final String TYPE_MENTION = "1";
    public static final String TYPE_VOUCHER = "2";
    private String id;
    private String type;
    private String url;

    public String getId() {
        String str = this.id;
        return str == null ? "" : str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getUrl() {
        String str = this.url;
        return str == null ? "" : str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
