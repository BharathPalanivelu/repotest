package com.shopee.live.livestreaming.data.entity.param;

import com.shopee.sdk.b.a;

public class AudienceReplayPageParams extends a {
    private final String endPageUrl;
    private final int recordId;
    private final int sessionId;
    private final String shareUrl;
    private final String source;

    public AudienceReplayPageParams(int i, String str, int i2, String str2, String str3) {
        this.sessionId = i;
        this.shareUrl = str;
        this.recordId = i2;
        this.endPageUrl = str2;
        this.source = str3;
    }

    public int getSessionId() {
        return this.sessionId;
    }

    public String getShareUrl() {
        String str = this.shareUrl;
        return str == null ? "" : str;
    }

    public int getRecordId() {
        return this.recordId;
    }

    public String getEndPageUrl() {
        String str = this.endPageUrl;
        return str == null ? "" : str;
    }

    public String getSource() {
        String str = this.source;
        return str == null ? "" : str;
    }
}
