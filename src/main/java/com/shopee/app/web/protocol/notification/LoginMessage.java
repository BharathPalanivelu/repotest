package com.shopee.app.web.protocol.notification;

public class LoginMessage {
    private String acquisitionSource;
    private int hidePopup;
    private String redirectPath;
    private int redirectTab;

    public boolean isHidingPopup() {
        return this.hidePopup == 1;
    }

    public int getRedirectTab() {
        return this.redirectTab;
    }

    public String getRedirectPath() {
        return this.redirectPath;
    }

    public String getAcquisitionSource() {
        return this.acquisitionSource;
    }
}
