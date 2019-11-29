package com.shopee.app.data.viewmodel.chat2;

import java.util.List;

public class StickerPack {
    private String mGroupImageUrl;
    private List<Sticker> mStickers;

    public StickerPack(String str, List<Sticker> list) {
        this.mGroupImageUrl = str;
        this.mStickers = list;
    }

    public String getGroupImageUrl() {
        return this.mGroupImageUrl;
    }

    public List<Sticker> getStickers() {
        return this.mStickers;
    }
}
