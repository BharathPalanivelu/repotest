package com.shopee.app.upload.data;

public class UploadVideo {
    public static final int STATUS_COMPLETE = 3;
    public static final int STATUS_NEW = 0;
    public static final int STATUS_PARTIAL_UPLOAD = 2;
    public static final int STATUS_TRIMMED = 1;
    private int duration;
    private long itemId;
    private String key;
    private String outPath;
    private String path;
    private long startTime;
    private int status;
    private String thumb;
    private String uploadId;
    private String videoId;

    private UploadVideo(Builder builder) {
        this.path = "";
        this.thumb = "";
        this.duration = 0;
        this.uploadId = "";
        this.videoId = "";
        this.path = builder.path;
        setThumb(builder.thumb);
        this.duration = builder.duration;
        setUploadId(builder.uploadId);
        setVideoId(builder.videoId);
        setItemId(builder.itemId);
        this.startTime = builder.startTime;
        setOutPath(builder.outPath);
        setStatus(builder.status);
        setKey(builder.key);
    }

    public String getPath() {
        return this.path;
    }

    public String getThumb() {
        return this.thumb;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public long getItemId() {
        return this.itemId;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getOutPath() {
        return this.outPath;
    }

    public int getStatus() {
        return this.status;
    }

    public void setOutPath(String str) {
        this.outPath = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int duration;
        /* access modifiers changed from: private */
        public long itemId;
        /* access modifiers changed from: private */
        public String key;
        /* access modifiers changed from: private */
        public String outPath;
        /* access modifiers changed from: private */
        public String path;
        /* access modifiers changed from: private */
        public long startTime;
        /* access modifiers changed from: private */
        public int status;
        /* access modifiers changed from: private */
        public String thumb;
        /* access modifiers changed from: private */
        public String uploadId;
        /* access modifiers changed from: private */
        public String videoId;

        public Builder path(String str) {
            this.path = str;
            return this;
        }

        public Builder thumb(String str) {
            this.thumb = str;
            return this;
        }

        public Builder duration(int i) {
            this.duration = i;
            return this;
        }

        public Builder uploadId(String str) {
            this.uploadId = str;
            return this;
        }

        public Builder videoId(String str) {
            this.videoId = str;
            return this;
        }

        public Builder itemId(long j) {
            this.itemId = j;
            return this;
        }

        public Builder startTime(long j) {
            this.startTime = j;
            return this;
        }

        public Builder outPath(String str) {
            this.outPath = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder status(int i) {
            this.status = i;
            return this;
        }

        public UploadVideo build() {
            return new UploadVideo(this);
        }
    }
}
