package com.appsflyer.cache;

import java.util.Scanner;

public class RequestCacheData {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f112;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f113;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f114;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f115;

    public RequestCacheData(String str, String str2, String str3) {
        this.f113 = str;
        this.f115 = str2;
        this.f114 = str3;
    }

    public RequestCacheData(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.f113 = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.f114 = nextLine.substring(8).trim();
            } else if (nextLine.startsWith("data=")) {
                this.f115 = nextLine.substring(5).trim();
            }
        }
        scanner.close();
    }

    public String getVersion() {
        return this.f114;
    }

    public void setVersion(String str) {
        this.f114 = str;
    }

    public String getPostData() {
        return this.f115;
    }

    public void setPostData(String str) {
        this.f115 = str;
    }

    public String getRequestURL() {
        return this.f113;
    }

    public void setRequestURL(String str) {
        this.f113 = str;
    }

    public String getCacheKey() {
        return this.f112;
    }

    public void setCacheKey(String str) {
        this.f112 = str;
    }
}
