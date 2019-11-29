package com.shopee.web.sdk.bridge.protocol.sharing;

import java.util.List;

public class ShowSharingPanelRequest {
    private final boolean autoDismissForUnavailablePlatform;
    private final List<String> sharingAppIDsBottom;
    private final List<String> sharingAppIDsTop;
    private final String subTitle;
    private final String title;

    public ShowSharingPanelRequest(String str, String str2, boolean z, List<String> list, List<String> list2) {
        this.title = str;
        this.subTitle = str2;
        this.autoDismissForUnavailablePlatform = z;
        this.sharingAppIDsTop = list;
        this.sharingAppIDsBottom = list2;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public boolean isAutoDismissForUnavailablePlatform() {
        return this.autoDismissForUnavailablePlatform;
    }

    public List<String> getSharingAppIDsTop() {
        return this.sharingAppIDsTop;
    }

    public List<String> getSharingAppIDsBottom() {
        return this.sharingAppIDsBottom;
    }
}
