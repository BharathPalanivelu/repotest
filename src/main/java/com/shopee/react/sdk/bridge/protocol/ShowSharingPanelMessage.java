package com.shopee.react.sdk.bridge.protocol;

import java.util.List;

public class ShowSharingPanelMessage {
    private final boolean autoDismissForUnavailablePlatform;
    private final List<String> sharignAppIDsBottom;
    private final List<String> sharingAppIDsTop;
    private final String subTitle;
    private final String title;

    public ShowSharingPanelMessage(String str, String str2, boolean z, List<String> list, List<String> list2) {
        this.title = str;
        this.subTitle = str2;
        this.autoDismissForUnavailablePlatform = z;
        this.sharingAppIDsTop = list;
        this.sharignAppIDsBottom = list2;
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

    public List<String> getSharignAppIDsBottom() {
        return this.sharignAppIDsBottom;
    }
}
