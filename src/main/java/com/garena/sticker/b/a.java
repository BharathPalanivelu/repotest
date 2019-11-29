package com.garena.sticker.b;

import com.garena.sticker.e.b;
import com.garena.sticker.model.Sticker;
import com.garena.sticker.model.StickerPack;
import java.util.ArrayList;

public class a {
    public com.garena.sticker.e.a a(String str, StickerPack stickerPack, String str2, String str3) {
        int indexOf = stickerPack.getLocales().indexOf(str2);
        if (indexOf < 0) {
            indexOf = 0;
        }
        long j = 0;
        if (stickerPack.getSize() != null && stickerPack.getSize().size() >= 1) {
            j = stickerPack.getSize().get(0).longValue();
        }
        long j2 = j;
        ArrayList arrayList = new ArrayList();
        for (Sticker next : stickerPack.getStickers()) {
            arrayList.add(new b(next.getSid(), str, next.getFormat(), next.getName().get(indexOf), str3));
        }
        return new com.garena.sticker.e.a(str, arrayList, j2, stickerPack.isAutoDownload(), str3);
    }
}
