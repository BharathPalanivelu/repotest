package com.shopee.app.data.viewmodel;

import com.garena.sticker.e.a;

public class StickerPack {
    private boolean isDownloaded;
    private a pack;

    public StickerPack(a aVar, boolean z) {
        this.pack = aVar;
        this.isDownloaded = z;
    }

    public a getPack() {
        return this.pack;
    }

    public boolean isDownloaded() {
        return this.isDownloaded;
    }

    public boolean autoDownload() {
        return this.pack.f();
    }
}
