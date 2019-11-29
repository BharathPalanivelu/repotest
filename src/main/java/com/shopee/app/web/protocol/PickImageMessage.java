package com.shopee.app.web.protocol;

public class PickImageMessage {
    private double cropRatio;
    private int height;
    private int maxCount;
    private boolean needCrop;
    private int quality;
    private int tnHeight;
    private int tnQuality;
    private int tnWidth;
    private int type = 0;
    private int width;

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

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int i) {
        this.quality = i;
    }

    public int getTnWidth() {
        return this.tnWidth;
    }

    public void setTnWidth(int i) {
        this.tnWidth = i;
    }

    public int getTnHeight() {
        return this.tnHeight;
    }

    public int getMaxCount() {
        int i = this.maxCount;
        if (i <= 1) {
            return 1;
        }
        return i;
    }

    public void setTnHeight(int i) {
        this.tnHeight = i;
    }

    public int getTnQuality() {
        return this.tnQuality;
    }

    public void setTnQuality(int i) {
        this.tnQuality = i;
    }

    public int getType() {
        return this.type;
    }

    public boolean needCrop() {
        return this.needCrop;
    }

    public double getCropRatio() {
        return this.cropRatio;
    }
}
