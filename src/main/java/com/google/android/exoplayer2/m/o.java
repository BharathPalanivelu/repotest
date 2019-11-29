package com.google.android.exoplayer2.m;

import com.google.android.exoplayer2.m.q;
import com.google.android.exoplayer2.n.m;
import com.tencent.ugc.TXRecordCommon;

public final class o extends q.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f10803a;

    /* renamed from: b  reason: collision with root package name */
    private final u<? super f> f10804b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10805c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10806d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10807e;

    public o(String str, u<? super f> uVar) {
        this(str, uVar, TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_8000, false);
    }

    public o(String str, u<? super f> uVar, int i, int i2, boolean z) {
        this.f10803a = str;
        this.f10804b = uVar;
        this.f10805c = i;
        this.f10806d = i2;
        this.f10807e = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public n b(q.f fVar) {
        return new n(this.f10803a, (m<String>) null, this.f10804b, this.f10805c, this.f10806d, this.f10807e, fVar);
    }
}
