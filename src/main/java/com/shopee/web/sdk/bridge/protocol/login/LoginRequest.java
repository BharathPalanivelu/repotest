package com.shopee.web.sdk.bridge.protocol.login;

public class LoginRequest {
    private String acquisitionSource;
    private int hidePopup;
    private String redirectPath;
    private int redirectTab;

    public int getHidePopup() {
        return this.hidePopup;
    }

    public void setHidePopup(int i) {
        this.hidePopup = i;
    }

    public int getRedirectTab() {
        return this.redirectTab;
    }

    public void setRedirectTab(int i) {
        this.redirectTab = i;
    }

    public String getRedirectPath() {
        return this.redirectPath;
    }

    public void setRedirectPath(String str) {
        this.redirectPath = str;
    }

    public String getAcquisitionSource() {
        return this.acquisitionSource;
    }

    public void setAcquisitionSource(String str) {
        this.acquisitionSource = str;
    }
}
