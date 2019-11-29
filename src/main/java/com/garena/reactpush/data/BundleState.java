package com.garena.reactpush.data;

import java.util.HashMap;
import java.util.Map;

public class BundleState {
    public static final String SYNC_LOCAL_ERROR = "SYNC_LOCAL_ERROR";
    public static final String SYNC_LOCAL_STARTED = "SYNC_LOCAL_STARTED";
    public static final String SYNC_LOCAL_SUCCESS = "SYNC_LOCAL_SUCCESS";
    public static final String SYNC_NONE = "SYNC_NONE";
    private int appVersion;
    private Map<String, Long> bundleModifiedTime = new HashMap();
    private long lastCheckedTime = Long.MIN_VALUE;
    private boolean needImageZipDownload = true;
    private String syncState;

    public int getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(int i) {
        this.appVersion = i;
    }

    public boolean isFreshInstall() {
        return this.appVersion <= 0;
    }

    public boolean isAppUpdate(int i) {
        return this.appVersion < i;
    }

    public void setSyncLocalStarted() {
        this.syncState = SYNC_LOCAL_STARTED;
    }

    public void setSyncLocalError() {
        this.syncState = SYNC_LOCAL_ERROR;
    }

    public void setSyncLocalSuccess() {
        this.syncState = SYNC_LOCAL_SUCCESS;
    }

    public boolean isSyncLocalStarted() {
        return SYNC_LOCAL_STARTED.equals(this.syncState);
    }

    public boolean isSyncLocalSucccess() {
        return SYNC_LOCAL_SUCCESS.equals(this.syncState);
    }

    public boolean isSyncLocalError() {
        return SYNC_LOCAL_ERROR.equals(this.syncState);
    }

    public boolean isNeedImageZipDownload() {
        return this.needImageZipDownload;
    }

    public void setNeedImageZipDownload(boolean z) {
        this.needImageZipDownload = z;
    }

    public long getLastCheckedTime() {
        return this.lastCheckedTime;
    }

    public void setLastCheckedTime(long j) {
        this.lastCheckedTime = j;
    }

    public long getBundleModifiedTime(String str) {
        Long l = this.bundleModifiedTime.get(str);
        if (l == null) {
            return Long.MIN_VALUE;
        }
        return l.longValue();
    }

    public void setBundleModifiedTime(String str, long j) {
        this.bundleModifiedTime.put(str, Long.valueOf(j));
    }

    public void clearTimestamps() {
        this.lastCheckedTime = Long.MIN_VALUE;
        this.bundleModifiedTime.clear();
    }
}
