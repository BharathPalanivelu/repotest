package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class ImageEntity implements Serializable {
    private String file_id = "";
    private String file_name = "";

    public String getFile_name() {
        String str = this.file_name;
        return str == null ? "" : str;
    }

    public void setFile_name(String str) {
        this.file_name = str;
    }

    public String getFile_id() {
        String str = this.file_id;
        return str == null ? "" : str;
    }

    public void setFile_id(String str) {
        this.file_id = str;
    }
}
