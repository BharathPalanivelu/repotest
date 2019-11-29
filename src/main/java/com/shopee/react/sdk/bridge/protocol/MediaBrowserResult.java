package com.shopee.react.sdk.bridge.protocol;

public class MediaBrowserResult {
    private int curTime;
    private int index;
    private boolean isMuted;
    private boolean isPlaying;
    private int status;

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getCurTime() {
        return this.curTime;
    }

    public void setCurTime(int i) {
        this.curTime = i;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public static MediaBrowserResult newResult(int i, boolean z, int i2, boolean z2) {
        MediaBrowserResult mediaBrowserResult = new MediaBrowserResult();
        mediaBrowserResult.index = i;
        mediaBrowserResult.isPlaying = z;
        mediaBrowserResult.curTime = i2;
        mediaBrowserResult.status = 1;
        mediaBrowserResult.isMuted = z2;
        return mediaBrowserResult;
    }

    public static MediaBrowserResult newError() {
        MediaBrowserResult mediaBrowserResult = new MediaBrowserResult();
        mediaBrowserResult.status = 0;
        return mediaBrowserResult;
    }

    public boolean isMuted() {
        return this.isMuted;
    }

    public void setMuted(boolean z) {
        this.isMuted = z;
    }
}
