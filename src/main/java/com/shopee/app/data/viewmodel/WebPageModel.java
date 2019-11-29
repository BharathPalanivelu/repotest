package com.shopee.app.data.viewmodel;

import android.net.Uri;

public class WebPageModel {
    private String lastPageJS;
    private String url;

    public WebPageModel(String str) {
        this.url = str;
    }

    public String getUrl() {
        return isPdfUrl(this.url) ? getPdfUrl(this.url) : this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getLastPageJS() {
        return this.lastPageJS;
    }

    public void setLastPageJS(String str) {
        this.lastPageJS = str;
    }

    public static boolean isPdfUrl(String str) {
        return str.contains(".pdf") && Uri.parse(str).getLastPathSegment().endsWith(".pdf");
    }

    public static String getPdfUrl(String str) {
        return "https://docs.google.com/gview?embedded=true&url=" + str;
    }
}
