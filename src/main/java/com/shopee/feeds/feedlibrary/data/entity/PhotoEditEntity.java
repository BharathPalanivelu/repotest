package com.shopee.feeds.feedlibrary.data.entity;

import java.util.ArrayList;

public class PhotoEditEntity extends BaseEditEntity {
    public static final String PHOTO_INFO = "photo_info";
    private String firstSaveImg;
    private ArrayList<ImageEntity> imageList;
    private boolean isFromBuyerReview = false;
    private ArrayList<ImageCompressUploadParams> mUploadImageCompressParams;
    private String shareInsImg;
    private ArrayList<String> timelineImgList;

    public void setFirstSaveImg(String str) {
        this.firstSaveImg = str;
    }

    public String getFirstSaveImg() {
        return this.firstSaveImg;
    }

    public void setShareInsImg(String str) {
        this.shareInsImg = str;
    }

    public void setFromBuyerReview(boolean z) {
        this.isFromBuyerReview = z;
    }

    public boolean isFromBuyerReview() {
        return this.isFromBuyerReview;
    }

    public String getShareInsImg() {
        return this.shareInsImg;
    }

    public ArrayList<ImageCompressUploadParams> getmUploadImageCompressParams() {
        ArrayList<ImageCompressUploadParams> arrayList = this.mUploadImageCompressParams;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setmUploadImageCompressParams(ArrayList<ImageCompressUploadParams> arrayList) {
        this.mUploadImageCompressParams = arrayList;
    }

    public void setTimelineImgList(ArrayList<String> arrayList) {
        this.timelineImgList = arrayList;
    }

    public ArrayList<String> getTimelineImgList() {
        return this.timelineImgList;
    }

    public void setImageList(ArrayList<ImageEntity> arrayList) {
        this.imageList = arrayList;
    }

    public ArrayList<ImageEntity> getImageList() {
        return this.imageList;
    }
}
