package com.shopee.app.data.viewmodel;

import android.text.TextUtils;
import com.garena.android.appkit.tools.a.a;
import com.google.a.a.c;
import com.google.a.l;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavbarMessage;

public class BannerData {
    @c(a = "banner_image")
    private String bannerImage = "http://file.beeshopmobile.com:8081/file/2200e907aba1d123401d0dff6b0ed044";
    @c(a = "end")
    private String endTime;
    @c(a = "navigate_params")
    private NavigateParams navigateParams;
    @c(a = "page_title")
    private String pageTitle;
    @c(a = "page_url")
    private String pageUrl;
    @c(a = "start")
    private String startTime;

    public String getBannerImage() {
        return this.bannerImage;
    }

    public boolean isInGoodTime() {
        int a2 = a.a();
        if (!TextUtils.isEmpty(this.startTime)) {
            try {
                if (a2 < Integer.parseInt(this.startTime)) {
                    return false;
                }
            } catch (NumberFormatException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
        if (TextUtils.isEmpty(this.endTime)) {
            return true;
        }
        try {
            if (a2 > Integer.parseInt(this.endTime)) {
                return false;
            }
            return true;
        } catch (NumberFormatException e3) {
            com.garena.android.appkit.d.a.a(e3);
            return true;
        }
    }

    public void setBannerImage(String str) {
        this.bannerImage = str;
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

    public void setPageTitle(String str) {
        this.pageTitle = str;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }

    public void setPageUrl(String str) {
        this.pageUrl = str;
    }

    public String getPageUrlNav() {
        NavigateParams navigateParams2 = this.navigateParams;
        if (navigateParams2 == null) {
            return null;
        }
        return navigateParams2.pageUrl;
    }

    public String getPageConfig() {
        NavigateParams navigateParams2 = this.navigateParams;
        if (navigateParams2 == null) {
            return null;
        }
        return navigateParams2.pageConfig.toString();
    }

    public String getNavbarMsg() {
        if (this.navigateParams == null) {
            return null;
        }
        return WebRegister.GSON.b(this.navigateParams.navbar, NavbarMessage.class);
    }

    private static class NavigateParams {
        /* access modifiers changed from: private */
        @c(a = "navbar")
        public NavbarMessage navbar;
        /* access modifiers changed from: private */
        @c(a = "config")
        public l pageConfig;
        /* access modifiers changed from: private */
        @c(a = "url")
        public String pageUrl;

        private NavigateParams() {
        }
    }
}
