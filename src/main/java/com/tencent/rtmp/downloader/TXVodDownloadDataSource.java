package com.tencent.rtmp.downloader;

import com.tencent.rtmp.TXPlayerAuthBuilder;

public class TXVodDownloadDataSource {
    public static final int QUALITY_2K = 5;
    public static final int QUALITY_4K = 6;
    public static final int QUALITY_FHD = 4;
    public static final int QUALITY_FLU = 1;
    public static final int QUALITY_HD = 3;
    public static final int QUALITY_OD = 0;
    public static final int QUALITY_SD = 2;
    public static final int QUALITY_UNK = 1000;
    protected TXPlayerAuthBuilder authBuilder;
    protected int quality = 1000;
    protected String templateName;
    protected String token;

    protected static String qualityToId(int i) {
        return i == 1 ? "FLU" : i == 2 ? "SD" : i == 3 ? "HD" : i == 4 ? "FHD" : i == 5 ? "2K" : i == 6 ? "4K" : "";
    }

    public TXVodDownloadDataSource(TXPlayerAuthBuilder tXPlayerAuthBuilder, int i) {
        this.authBuilder = tXPlayerAuthBuilder;
        this.quality = i;
    }

    public TXVodDownloadDataSource(TXPlayerAuthBuilder tXPlayerAuthBuilder, String str) {
        this.authBuilder = tXPlayerAuthBuilder;
        this.templateName = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public TXPlayerAuthBuilder getAuthBuilder() {
        return this.authBuilder;
    }

    public int getQuality() {
        return this.quality;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getToken() {
        return this.token;
    }
}
