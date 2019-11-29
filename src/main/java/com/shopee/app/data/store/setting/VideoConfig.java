package com.shopee.app.data.store.setting;

public class VideoConfig {
    public static VideoConfig videoConfig = new VideoConfig(28, 20, "ultrafast", 640);
    private int crf;
    private int maxSize;
    private String preset;
    private int rate;

    public VideoConfig(int i, int i2, String str, int i3) {
        this.crf = i;
        this.rate = i2;
        this.preset = str;
        this.maxSize = i3;
    }

    public int getCrf() {
        return this.crf;
    }

    public int getRate() {
        return this.rate;
    }

    public String getPreset() {
        return this.preset;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
