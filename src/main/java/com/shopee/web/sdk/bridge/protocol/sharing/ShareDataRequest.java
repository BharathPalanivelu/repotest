package com.shopee.web.sdk.bridge.protocol.sharing;

import com.google.a.l;

public class ShareDataRequest {
    private final String sharingAppID;
    private final l sharingData;

    public ShareDataRequest(String str, l lVar) {
        this.sharingAppID = str;
        this.sharingData = lVar;
    }

    public String getSharingAppID() {
        return this.sharingAppID;
    }

    public l getSharingData() {
        return this.sharingData;
    }
}
