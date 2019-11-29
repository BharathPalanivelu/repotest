package com.shopee.app.web.protocol;

public class OpenICCameraMessage {
    private int frameHorizontalMargin = 30;
    private float frameRatio = 0.6f;
    private boolean hasFrame = false;
    private int preferMinImageSize = 2000000;

    public float getFrameRatio() {
        return this.frameRatio;
    }

    public void setFrameRatio(float f2) {
        this.frameRatio = f2;
    }

    public int getPreferMinImageSize() {
        return this.preferMinImageSize;
    }

    public boolean hasFrame() {
        return this.hasFrame;
    }

    public int getFrameHorizontalMargin() {
        return this.frameHorizontalMargin;
    }
}
