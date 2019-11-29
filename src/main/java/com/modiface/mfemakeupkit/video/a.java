package com.modiface.mfemakeupkit.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.io.IOException;

class a extends c {

    /* renamed from: f  reason: collision with root package name */
    private final l f15411f;

    a(l lVar) {
        this.f15411f = lVar;
    }

    /* access modifiers changed from: package-private */
    public d h() throws IllegalStateException {
        return super.a((long) this.f15411f.A);
    }

    /* access modifiers changed from: package-private */
    public d i() throws IllegalStateException {
        return super.b((long) this.f15411f.z);
    }

    /* access modifiers changed from: package-private */
    public void j() throws IOException {
        super.a(this.f15411f.u);
    }

    /* access modifiers changed from: package-private */
    public void k() throws IllegalStateException, MediaCodec.CryptoException {
        super.a(new MediaFormat[]{this.f15411f.a()}, false);
    }
}
