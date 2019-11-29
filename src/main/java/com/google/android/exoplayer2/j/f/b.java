package com.google.android.exoplayer2.j.f;

import com.google.android.exoplayer2.j.a;
import com.google.android.exoplayer2.j.f;
import com.google.android.exoplayer2.j.f.e;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b extends com.google.android.exoplayer2.j.b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10578a = t.g("payl");

    /* renamed from: b  reason: collision with root package name */
    private static final int f10579b = t.g("sttg");

    /* renamed from: c  reason: collision with root package name */
    private static final int f10580c = t.g("vttc");

    /* renamed from: d  reason: collision with root package name */
    private final k f10581d = new k();

    /* renamed from: e  reason: collision with root package name */
    private final e.a f10582e = new e.a();

    public b() {
        super("Mp4WebvttDecoder");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public c a(byte[] bArr, int i, boolean z) throws f {
        this.f10581d.a(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.f10581d.b() > 0) {
            if (this.f10581d.b() >= 8) {
                int n = this.f10581d.n();
                if (this.f10581d.n() == f10580c) {
                    arrayList.add(a(this.f10581d, this.f10582e, n - 8));
                } else {
                    this.f10581d.d(n - 8);
                }
            } else {
                throw new f("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new c(arrayList);
    }

    private static a a(k kVar, e.a aVar, int i) throws f {
        aVar.a();
        while (i > 0) {
            if (i >= 8) {
                int n = kVar.n();
                int n2 = kVar.n();
                int i2 = n - 8;
                String str = new String(kVar.f10948a, kVar.d(), i2);
                kVar.d(i2);
                i = (i - 8) - i2;
                if (n2 == f10579b) {
                    f.a(str, aVar);
                } else if (n2 == f10578a) {
                    f.a((String) null, str.trim(), aVar, (List<d>) Collections.emptyList());
                }
            } else {
                throw new f("Incomplete vtt cue box header found.");
            }
        }
        return aVar.b();
    }
}
