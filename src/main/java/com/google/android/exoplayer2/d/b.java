package com.google.android.exoplayer2.d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.n.t;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9263a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f9264b;

    /* renamed from: c  reason: collision with root package name */
    public int f9265c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f9266d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f9267e;

    /* renamed from: f  reason: collision with root package name */
    public int f9268f;

    /* renamed from: g  reason: collision with root package name */
    public int f9269g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final a j;

    public b() {
        this.i = t.f10975a >= 16 ? b() : null;
        this.j = t.f10975a >= 24 ? new a(this.i) : null;
    }

    public void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3) {
        this.f9268f = i2;
        this.f9266d = iArr;
        this.f9267e = iArr2;
        this.f9264b = bArr;
        this.f9263a = bArr2;
        this.f9265c = i3;
        this.f9269g = 0;
        this.h = 0;
        if (t.f10975a >= 16) {
            c();
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        return this.i;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void c() {
        MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = this.f9268f;
        cryptoInfo.numBytesOfClearData = this.f9266d;
        cryptoInfo.numBytesOfEncryptedData = this.f9267e;
        cryptoInfo.key = this.f9264b;
        cryptoInfo.iv = this.f9263a;
        cryptoInfo.mode = this.f9265c;
        if (t.f10975a >= 24) {
            this.j.a(this.f9269g, this.h);
        }
    }

    @TargetApi(24)
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f9270a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f9271b;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f9270a = cryptoInfo;
            this.f9271b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* access modifiers changed from: private */
        public void a(int i, int i2) {
            this.f9271b.set(i, i2);
            this.f9270a.setPattern(this.f9271b);
        }
    }
}
