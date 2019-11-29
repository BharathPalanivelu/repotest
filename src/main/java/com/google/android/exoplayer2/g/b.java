package com.google.android.exoplayer2.g;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.s.v;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9864a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f9865b;

    /* renamed from: c  reason: collision with root package name */
    public int f9866c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f9867d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f9868e;

    /* renamed from: f  reason: collision with root package name */
    public int f9869f;

    /* renamed from: g  reason: collision with root package name */
    public int f9870g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final a j;

    public b() {
        this.i = v.f11449a >= 16 ? b() : null;
        this.j = v.f11449a >= 24 ? new a(this.i) : null;
    }

    public void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f9869f = i2;
        this.f9867d = iArr;
        this.f9868e = iArr2;
        this.f9865b = bArr;
        this.f9864a = bArr2;
        this.f9866c = i3;
        this.f9870g = i4;
        this.h = i5;
        if (v.f11449a >= 16) {
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
        cryptoInfo.numSubSamples = this.f9869f;
        cryptoInfo.numBytesOfClearData = this.f9867d;
        cryptoInfo.numBytesOfEncryptedData = this.f9868e;
        cryptoInfo.key = this.f9865b;
        cryptoInfo.iv = this.f9864a;
        cryptoInfo.mode = this.f9866c;
        if (v.f11449a >= 24) {
            this.j.a(this.f9870g, this.h);
        }
    }

    @TargetApi(24)
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f9871a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f9872b;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f9871a = cryptoInfo;
            this.f9872b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* access modifiers changed from: private */
        public void a(int i, int i2) {
            this.f9872b.set(i, i2);
            this.f9871a.setPattern(this.f9872b);
        }
    }
}
