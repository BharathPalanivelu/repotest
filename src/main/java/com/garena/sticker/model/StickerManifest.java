package com.garena.sticker.model;

import java.util.ArrayList;
import java.util.List;

public class StickerManifest {
    private List<StickerManifestPack> packs;

    public List<StickerManifestPack> getPacks() {
        List<StickerManifestPack> list = this.packs;
        return list == null ? new ArrayList() : list;
    }
}
