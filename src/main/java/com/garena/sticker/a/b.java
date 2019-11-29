package com.garena.sticker.a;

import com.garena.sticker.model.StickerPack;
import f.c.f;
import f.c.s;
import io.b.j;

public interface b {
    @f(a = "packs/{packName}/{packName}.json")
    j<StickerPack> a(@s(a = "packName") String str);
}
