package com.google.android.exoplayer2.p.b;

import com.google.android.exoplayer2.p.c;
import com.google.android.exoplayer2.s.l;
import java.util.List;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final b f11075a;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        l lVar = new l(list.get(0));
        this.f11075a = new b(lVar.h(), lVar.h());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public c a(byte[] bArr, int i, boolean z) {
        if (z) {
            this.f11075a.a();
        }
        return new c(this.f11075a.a(bArr, i));
    }
}
