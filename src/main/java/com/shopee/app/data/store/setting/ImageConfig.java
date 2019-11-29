package com.shopee.app.data.store.setting;

public class ImageConfig {
    public static ImageConfig avatarImageConfig = new ImageConfig(640, 640, 80, 200, 200, 80);
    public static ImageConfig chatImageConfig = new ImageConfig(640, 640, 80, 200, 200, 80);
    public static ImageConfig coverImageConfig = new ImageConfig(640, 640, 80, 200, 200, 80);
    public static ImageConfig imageSearchConfig = new ImageConfig(640, 640, 80, 200, 200, 80);
    public static ImageConfig productImageConfig = new ImageConfig(640, 640, 25, 640, 640, 80, 320, 320, 80);
    public static ImageConfig shopBannerImageConfig = new ImageConfig(640, 640, 80, 300, 150, 80);
    private int fullImageHeight;
    private int fullImageQuality;
    private int fullImageWidth;
    public int fullVideoHeight;
    public int fullVideoQuality;
    public int fullVideoWidth;
    private int thumbImageHeight;
    private int thumbImageQuality;
    private int thumbImageWidth;

    public ImageConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.fullVideoWidth = i;
        this.fullVideoHeight = i2;
        this.fullVideoQuality = i3;
        this.fullImageHeight = i5;
        this.fullImageQuality = i6;
        this.fullImageWidth = i4;
        this.thumbImageHeight = i8;
        this.thumbImageQuality = i9;
        this.thumbImageWidth = i7;
    }

    public ImageConfig(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fullVideoWidth = 640;
        this.fullVideoHeight = 640;
        this.fullVideoQuality = 25;
        this.fullImageHeight = i2;
        this.fullImageQuality = i3;
        this.fullImageWidth = i;
        this.thumbImageHeight = i5;
        this.thumbImageQuality = i6;
        this.thumbImageWidth = i4;
    }

    public int getFullImageWidth() {
        return this.fullImageWidth;
    }

    public int getFullImageHeight() {
        return this.fullImageHeight;
    }

    public int getThumbImageHeight() {
        return this.thumbImageHeight;
    }

    public int getThumbImageWidth() {
        return this.thumbImageWidth;
    }

    public int getThumbImageQuality() {
        return this.thumbImageQuality;
    }

    public int getFullImageQuality() {
        return this.fullImageQuality;
    }
}
