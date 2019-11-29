package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;

public class LiveStreamingParam extends a {
    private final String endPageUrl;
    private final String productSelectUrl;
    private final int sessionId;
    private final String shareUrl;

    public LiveStreamingParam(int i, String str, String str2, String str3) {
        this.sessionId = i;
        this.shareUrl = str;
        this.endPageUrl = str2;
        this.productSelectUrl = str3;
    }

    public int getSessionId() {
        return this.sessionId;
    }

    public String getShareUrl() {
        String str = this.shareUrl;
        return str == null ? "" : str;
    }

    public String getEndPageUrl() {
        String str = this.endPageUrl;
        return str == null ? "" : str;
    }

    public String getProductSelectUrl() {
        String str = this.productSelectUrl;
        return str == null ? "" : str;
    }
}
