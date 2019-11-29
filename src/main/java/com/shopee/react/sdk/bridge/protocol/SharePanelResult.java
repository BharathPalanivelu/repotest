package com.shopee.react.sdk.bridge.protocol;

public class SharePanelResult {
    private final boolean isAppAvailable;
    private final String sharingAppID;
    private final int status;

    public SharePanelResult(int i, String str, boolean z) {
        this.status = i;
        this.sharingAppID = str;
        this.isAppAvailable = z;
    }

    public SharePanelResult(int i) {
        this.status = i;
        this.sharingAppID = null;
        this.isAppAvailable = false;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSharingAppID() {
        return this.sharingAppID;
    }

    public boolean isAppAvailable() {
        return this.isAppAvailable;
    }
}
