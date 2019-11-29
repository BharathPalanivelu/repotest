package com.shopee.app.web;

@Deprecated
public class OpenICCameraMessage1 {
    private float cropRatio = 1.8f;
    private int preferMinImageSize = 2000000;

    public int getPreferMinImageSize() {
        return this.preferMinImageSize;
    }

    public float getCropRatio() {
        return this.cropRatio;
    }
}
