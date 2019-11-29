package com.shopee.web.sdk.bridge.protocol.sharing;

public class ShowSharingPanelResponse {
    private final boolean isAppAvailable;
    private final String sharingAppID;
    private final int status;

    public ShowSharingPanelResponse(int i, String str, boolean z) {
        this.status = i;
        this.sharingAppID = str;
        this.isAppAvailable = z;
    }

    public ShowSharingPanelResponse(int i) {
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
