package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class ReLoadEntity implements Serializable {
    private String filePath;
    private boolean reload;

    public String getFilePath() {
        String str = this.filePath;
        return str == null ? "" : str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public boolean isReload() {
        return this.reload;
    }

    public void setReload(boolean z) {
        this.reload = z;
    }
}
