package com.garena.sticker.model;

import java.util.List;

public class StickerManifestPack {
    private String md5;
    private String pid;
    private List<String> reg;

    public StickerManifestPack(String str, String str2, List<String> list) {
        this.pid = str;
        this.md5 = str2;
        this.reg = list;
    }

    public boolean isAvailable(String str) {
        return this.reg.contains(str);
    }

    public String getPid() {
        return this.pid;
    }

    public String getMd5() {
        return this.md5;
    }
}
