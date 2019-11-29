package com.shopee.feeds.feedlibrary.data.entity;

import android.graphics.Rect;

public class VideoEditEntity extends BaseEditEntity {
    public static final String VIDEO_INFO = "video_info";
    private String coverPath;
    private String coverUploadUrl;
    private int duration;
    public boolean hasVideoClipAndWater = false;
    private boolean hasWaterVideoClip;
    private String imageFeedWaterCachePath;
    private String imageWaterMarkStorePath;
    private String imageWaterMarkUploadUrl;
    private boolean isOriginalVideo = false;
    private String oldCoverPath;
    private String signature;
    private String timelineShowCover;
    private String timelineShowVideo;
    private VideoCompressUploadEntity uploadEntity;
    private Rect videoCacheRect;
    private boolean videoNeedWater = false;
    private VideoPostParams videoPostParams;
    private String videoPreviewPath;
    private int videoScaleHeight;
    private int videoScaleWidth;
    public String videoStorePath;
    private String videoUploadMd5;
    public String videoWaterImgPath;
    private String videoWaterMarkStorePath;
    private String videoWaterMarkUploadUrl;
    private String videoWaterPath;

    public void setImageFeedWaterCachePath(String str) {
        this.imageFeedWaterCachePath = str;
    }

    public String getImageFeedWaterCachePath() {
        return this.imageFeedWaterCachePath;
    }

    public void setImageWaterMarkUploadUrl(String str) {
        this.imageWaterMarkUploadUrl = str;
    }

    public String getImageWaterMarkUploadUrl() {
        return this.imageWaterMarkUploadUrl;
    }

    public void setVideoWaterMarkUploadUrl(String str) {
        this.videoWaterMarkUploadUrl = str;
    }

    public String getVideoWaterMarkUploadUrl() {
        return this.videoWaterMarkUploadUrl;
    }

    public void setImageWaterMarkStorePath(String str) {
        this.imageWaterMarkStorePath = str;
    }

    public String getImageWaterMarkStorePath() {
        return this.imageWaterMarkStorePath;
    }

    public void setVideoWaterMarkStorePath(String str) {
        this.videoWaterMarkStorePath = str;
    }

    public String getVideoWaterMarkStorePath() {
        return this.videoWaterMarkStorePath;
    }

    public void setCoverUploadUrl(String str) {
        this.coverUploadUrl = str;
    }

    public String getCoverUploadUrl() {
        return this.coverUploadUrl;
    }

    public void setVideoScaleWidth(int i) {
        this.videoScaleWidth = i;
    }

    public int getVideoScaleWidth() {
        return this.videoScaleWidth;
    }

    public void setVideoScaleHeight(int i) {
        this.videoScaleHeight = i;
    }

    public int getVideoScaleHeight() {
        return this.videoScaleHeight;
    }

    public void setVideoCacheRect(Rect rect) {
        this.videoCacheRect = rect;
    }

    public Rect getVideoCacheRect() {
        return this.videoCacheRect;
    }

    public VideoPostParams getVideoPostParams() {
        return this.videoPostParams;
    }

    public void setVideoPostParams(VideoPostParams videoPostParams2) {
        this.videoPostParams = videoPostParams2;
    }

    public String getSignature() {
        String str = this.signature;
        return str == null ? "" : str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setOldCoverPath(String str) {
        this.oldCoverPath = str;
    }

    public String getOldCoverPath() {
        return this.oldCoverPath;
    }

    public void setCoverPath(String str) {
        this.coverPath = str;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public void setUploadEntity(VideoCompressUploadEntity videoCompressUploadEntity) {
        this.uploadEntity = videoCompressUploadEntity;
    }

    public VideoCompressUploadEntity getUploadEntity() {
        return this.uploadEntity;
    }

    public void setVideoWaterPath(String str) {
        this.videoWaterPath = str;
    }

    public String getVideoWaterPath() {
        return this.videoWaterPath;
    }

    public String getVideoPreviewPath() {
        String str = this.videoPreviewPath;
        return str == null ? "" : str;
    }

    public void setVideoPreviewPath(String str) {
        this.videoPreviewPath = str;
    }

    public void setOriginalVideo(boolean z) {
        this.isOriginalVideo = z;
    }

    public boolean isOriginalVideo() {
        return this.isOriginalVideo;
    }

    public void setVideoNeedWater(boolean z) {
        this.videoNeedWater = z;
    }

    public boolean isVideoNeedWater() {
        return this.videoNeedWater;
    }

    public void setTimelineShowVideo(String str) {
        this.timelineShowVideo = str;
    }

    public String getTimelineShowVideo() {
        return this.timelineShowVideo;
    }

    public void setTimelineShowCover(String str) {
        this.timelineShowCover = str;
    }

    public String getTimelineShowCover() {
        return this.timelineShowCover;
    }

    public void setVideoUploadMd5(String str) {
        this.videoUploadMd5 = str;
    }

    public String getVideoUploadMd5() {
        return this.videoUploadMd5;
    }

    public void setVideoWaterImgPath(String str) {
        this.videoWaterImgPath = str;
    }

    public String getVideoWaterImgPath() {
        return this.videoWaterImgPath;
    }

    public void setHasWaterVideoClip(boolean z) {
        this.hasWaterVideoClip = z;
    }

    public boolean isHasWaterVideoClip() {
        return this.hasWaterVideoClip;
    }

    public void setHasVideoClipAndWater(boolean z) {
        this.hasVideoClipAndWater = z;
    }

    public boolean isHasVideoClipAndWater() {
        return this.hasVideoClipAndWater;
    }

    public void setVideoStorePath(String str) {
        this.videoStorePath = str;
    }

    public String getVideoStorePath() {
        return this.videoStorePath;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }
}
