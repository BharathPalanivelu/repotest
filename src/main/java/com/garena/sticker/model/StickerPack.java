package com.garena.sticker.model;

import java.util.List;

public class StickerPack {
    private boolean auto_download;
    private List<String> locales;
    private List<Long> size;
    private List<Sticker> stickers;

    public List<String> getLocales() {
        return this.locales;
    }

    public List<Sticker> getStickers() {
        return this.stickers;
    }

    public List<Long> getSize() {
        return this.size;
    }

    public boolean isAutoDownload() {
        return this.auto_download;
    }
}
