package com.shopee.react.sdk.bridge.protocol;

import com.google.a.l;

public class SharingDataMessage {
    private final String sharingAppID;
    private final l sharingData;

    public SharingDataMessage(String str, l lVar) {
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
