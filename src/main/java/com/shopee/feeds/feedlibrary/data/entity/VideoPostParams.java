package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class VideoPostParams implements Serializable {
    private int duration;
    private boolean isVideoSquare;
    private int offsetX;
    private int offsetY;
    private int videoHeight;
    private int videoWidth;

    public boolean isVideoSquare() {
        return this.isVideoSquare;
    }

    public void setVideoSquare(boolean z) {
        this.isVideoSquare = z;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public void setOffsetX(int i) {
        this.offsetX = i;
    }

    public int getOffsetY() {
        return this.offsetY;
    }

    public void setOffsetY(int i) {
        this.offsetY = i;
    }
}
