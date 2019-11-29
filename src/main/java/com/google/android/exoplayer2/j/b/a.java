package com.google.android.exoplayer2.j.b;

import com.google.android.exoplayer2.j.b;
import com.google.android.exoplayer2.n.k;
import java.util.List;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private final b f10479a;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        k kVar = new k(list.get(0));
        this.f10479a = new b(kVar.h(), kVar.h());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public c a(byte[] bArr, int i, boolean z) {
        if (z) {
            this.f10479a.a();
        }
        return new c(this.f10479a.a(bArr, i));
    }
}
