package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class MediaCompressParam implements Serializable {

    /* renamed from: android  reason: collision with root package name */
    private Platform f27745android;
    private Platform ios;

    public Platform getAndroid() {
        return this.f27745android;
    }

    public void setAndroid(Platform platform) {
        this.f27745android = platform;
    }

    public Platform getIos() {
        return this.ios;
    }

    public void setIos(Platform platform) {
        this.ios = platform;
    }

    public class Platform implements Serializable {
        private int defaultCompressQuality;
        private ArrayList<CompressItem> list;
        private int maxSizeInKB;
        private int maxVideoWidth;
        private int maxWidth;
        private int minCompressQuality;
        private int minWidth;
        private int pictureMaxWidth;
        private int pictureQuality;
        private ArrayList<VideoCompressItem> videoList;

        public Platform() {
        }

        public int getMaxVideoWidth() {
            return this.maxVideoWidth;
        }

        public void setMaxVideoWidth(int i) {
            this.maxVideoWidth = i;
        }

        public ArrayList<VideoCompressItem> getVideoList() {
            ArrayList<VideoCompressItem> arrayList = this.videoList;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setVideoList(ArrayList<VideoCompressItem> arrayList) {
            this.videoList = arrayList;
        }

        public int getMaxWidth() {
            return this.maxWidth;
        }

        public int getPictureQuality() {
            return this.pictureQuality;
        }

        public void setPictureQuality(int i) {
            this.pictureQuality = i;
        }

        public int getPictureMaxWidth() {
            return this.pictureMaxWidth;
        }

        public void setPictureMaxWidth(int i) {
            this.pictureMaxWidth = i;
        }

        public void setMaxWidth(int i) {
            this.maxWidth = i;
        }

        public int getMinWidth() {
            return this.minWidth;
        }

        public void setMinWidth(int i) {
            this.minWidth = i;
        }

        public int getMaxSizeInKB() {
            return this.maxSizeInKB;
        }

        public void setMaxSizeInKB(int i) {
            this.maxSizeInKB = i;
        }

        public int getDefaultCompressQuality() {
            return this.defaultCompressQuality;
        }

        public void setDefaultCompressQuality(int i) {
            this.defaultCompressQuality = i;
        }

        public int getMinCompressQuality() {
            return this.minCompressQuality;
        }

        public void setMinCompressQuality(int i) {
            this.minCompressQuality = i;
        }

        public ArrayList<CompressItem> getList() {
            ArrayList<CompressItem> arrayList = this.list;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public void setList(ArrayList<CompressItem> arrayList) {
            this.list = arrayList;
        }
    }

    public class CompressItem implements Serializable {
        private int compressQuality;
        private int sizeInKB;
        private int width;

        public CompressItem() {
        }

        public int getSizeInKB() {
            return this.sizeInKB;
        }

        public void setSizeInKB(int i) {
            this.sizeInKB = i;
        }

        public int getCompressQuality() {
            return this.compressQuality;
        }

        public void setCompressQuality(int i) {
            this.compressQuality = i;
        }

        public int getWidth() {
            return this.width;
        }

        public void setWidth(int i) {
            this.width = i;
        }
    }

    public class VideoCompressItem implements Serializable {
        private int bitrate;
        private int duration;

        public VideoCompressItem() {
        }

        public int getDuration() {
            return this.duration;
        }

        public void setDuration(int i) {
            this.duration = i;
        }

        public int getBitrate() {
            return this.bitrate;
        }

        public void setBitrate(int i) {
            this.bitrate = i;
        }
    }
}
