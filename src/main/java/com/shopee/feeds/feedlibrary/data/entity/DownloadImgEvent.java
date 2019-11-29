package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class DownloadImgEvent implements Serializable {
    public static final int FAILED = 2;
    public static final int SUCCESS = 1;
    private int state;
    private int type;

    public boolean isProduct() {
        return this.type == 19;
    }

    public boolean isIns() {
        return this.type == 20;
    }

    public boolean isLocal() {
        return this.type == 18;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public boolean isSuccess() {
        return this.state == 1;
    }
}
