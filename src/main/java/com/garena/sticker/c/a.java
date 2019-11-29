package com.garena.sticker.c;

import android.content.SharedPreferences;
import com.garena.sticker.model.StickerManifest;
import com.garena.sticker.model.StickerPack;
import com.google.a.f;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f8678a;

    /* renamed from: b  reason: collision with root package name */
    private f f8679b;

    public a(SharedPreferences sharedPreferences, f fVar) {
        this.f8678a = sharedPreferences;
        this.f8679b = fVar;
    }

    public void a(StickerManifest stickerManifest) {
        this.f8678a.edit().putString("sticker_manifest", this.f8679b.b((Object) stickerManifest)).apply();
    }

    public StickerManifest a() {
        return (StickerManifest) this.f8679b.a(this.f8678a.getString("sticker_manifest", ServiceLogger.PLACEHOLDER), StickerManifest.class);
    }

    public void a(String str, StickerPack stickerPack) {
        this.f8678a.edit().putString(str, this.f8679b.b((Object) stickerPack)).apply();
    }

    public StickerPack a(String str) {
        return (StickerPack) this.f8679b.a(this.f8678a.getString(str, ServiceLogger.PLACEHOLDER), StickerPack.class);
    }
}
