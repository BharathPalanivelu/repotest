package com.shopee.app.data.viewmodel;

public class GalleryItemInfo {
    private long createTime;
    private int height;
    private boolean isVideo;
    private String path;
    private long videoTime;
    private int width;

    public static GalleryItemInfo newGalleryImage(String str, int i, int i2, long j) {
        return new GalleryItemInfo(str, i, i2, j);
    }

    public static GalleryItemInfo newVideo(String str, long j) {
        return new GalleryItemInfo(str, j);
    }

    private GalleryItemInfo(String str, int i, int i2, long j) {
        this.path = str;
        this.isVideo = false;
        this.videoTime = 0;
        this.width = i;
        this.height = i2;
        this.createTime = j;
    }

    private GalleryItemInfo(String str, long j) {
        this.path = str;
        this.isVideo = true;
        this.videoTime = j;
    }

    public String getPath() {
        return this.path;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public long getVideoTime() {
        return this.videoTime;
    }

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

    public long getCreateTime() {
        return this.createTime;
    }
}
