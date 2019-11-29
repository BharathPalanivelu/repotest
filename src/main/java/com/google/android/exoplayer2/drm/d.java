package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCrypto f9302a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9303b;

    public MediaCrypto a() {
        return this.f9302a;
    }

    public boolean a(String str) {
        return !this.f9303b && this.f9302a.requiresSecureDecoderComponent(str);
    }
}
