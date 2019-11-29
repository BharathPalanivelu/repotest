package com.tencent.imsdk;

public class TIMVideoElem extends TIMElem {
    private TIMSnapshot snapshot;
    private String snapshotPath = "";
    private long taskId = 0;
    private TIMVideo video;
    private String videoPath = "";

    public TIMVideoElem() {
        this.type = TIMElemType.Video;
    }

    public TIMSnapshot getSnapshotInfo() {
        return this.snapshot;
    }

    public String getSnapshotPath() {
        return this.snapshotPath;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public int getUploadingProgress() {
        if (!IMCoreWrapper.get().isIMCoreUserInited() || this.taskId == 0) {
            return 0;
        }
        return TIMManager.getInstance().getCoreUser().getImageUploadProgrss(this.taskId);
    }

    public TIMVideo getVideoInfo() {
        return this.video;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public void setSnapshot(TIMSnapshot tIMSnapshot) {
        this.snapshot = tIMSnapshot;
    }

    public void setSnapshotPath(String str) {
        this.snapshotPath = str;
    }

    /* access modifiers changed from: package-private */
    public void setTaskId(long j) {
        this.taskId = j;
    }

    public void setVideo(TIMVideo tIMVideo) {
        this.video = tIMVideo;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }
}
