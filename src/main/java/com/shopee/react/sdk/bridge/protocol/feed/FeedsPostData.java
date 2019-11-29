package com.shopee.react.sdk.bridge.protocol.feed;

import com.shopee.navigator.b;
import java.util.ArrayList;

public class FeedsPostData extends b {
    private String feedId;
    private ArrayList<String> imageDir;
    private long postEndTime;
    private String postId;
    private long postStartTime;
    private boolean sharing = false;
    private int status;
    private int type;
    private VideoData videoDir;

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public static class VideoData {
        private String cover;
        private String source;

        public void setCover(String str) {
            this.cover = str;
        }

        public String getCover() {
            return this.cover;
        }

        public void setSource(String str) {
            this.source = str;
        }

        public String getSource() {
            return this.source;
        }
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSharing() {
        return this.sharing;
    }

    public void setSharing(boolean z) {
        this.sharing = z;
    }

    public void setImageDir(ArrayList<String> arrayList) {
        this.imageDir = arrayList;
    }

    public ArrayList<String> getImageDir() {
        return this.imageDir;
    }

    public void setVideoDir(VideoData videoData) {
        this.videoDir = videoData;
    }

    public VideoData getVideoDir() {
        return this.videoDir;
    }

    public void setPostStartTime(long j) {
        this.postStartTime = j;
    }

    public long getPostStartTime() {
        return this.postStartTime;
    }

    public long getPostEndTime() {
        return this.postEndTime;
    }

    public void setPostEndTime(long j) {
        this.postEndTime = j;
    }
}
