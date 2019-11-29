package com.google.android.exoplayer2.p.g;

import com.google.android.exoplayer2.p.c;
import com.google.android.exoplayer2.p.g;
import com.google.android.exoplayer2.p.g.e;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f11183a = v.g("payl");

    /* renamed from: b  reason: collision with root package name */
    private static final int f11184b = v.g("sttg");

    /* renamed from: c  reason: collision with root package name */
    private static final int f11185c = v.g("vttc");

    /* renamed from: d  reason: collision with root package name */
    private final l f11186d = new l();

    /* renamed from: e  reason: collision with root package name */
    private final e.a f11187e = new e.a();

    public b() {
        super("Mp4WebvttDecoder");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public c a(byte[] bArr, int i, boolean z) throws g {
        this.f11186d.a(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.f11186d.b() > 0) {
            if (this.f11186d.b() >= 8) {
                int n = this.f11186d.n();
                if (this.f11186d.n() == f11185c) {
                    arrayList.add(a(this.f11186d, this.f11187e, n - 8));
                } else {
                    this.f11186d.d(n - 8);
                }
            } else {
                throw new g("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new c(arrayList);
    }

    private static com.google.android.exoplayer2.p.b a(l lVar, e.a aVar, int i) throws g {
        aVar.a();
        while (i > 0) {
            if (i >= 8) {
                int n = lVar.n();
                int n2 = lVar.n();
                int i2 = n - 8;
                String str = new String(lVar.f11422a, lVar.d(), i2);
                lVar.d(i2);
                i = (i - 8) - i2;
                if (n2 == f11184b) {
                    f.a(str, aVar);
                } else if (n2 == f11183a) {
                    f.a((String) null, str.trim(), aVar, (List<d>) Collections.emptyList());
                }
            } else {
                throw new g("Incomplete vtt cue box header found.");
            }
        }
        return aVar.b();
    }
}
