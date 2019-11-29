package com.google.android.exoplayer2.p.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.p.c;
import com.google.android.exoplayer2.p.g.e;
import com.google.android.exoplayer2.s.l;
import java.util.ArrayList;
import java.util.List;

public final class g extends c {

    /* renamed from: a  reason: collision with root package name */
    private final f f11214a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final l f11215b = new l();

    /* renamed from: c  reason: collision with root package name */
    private final e.a f11216c = new e.a();

    /* renamed from: d  reason: collision with root package name */
    private final a f11217d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final List<d> f11218e = new ArrayList();

    public g() {
        super("WebvttDecoder");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public i a(byte[] bArr, int i, boolean z) throws com.google.android.exoplayer2.p.g {
        this.f11215b.a(bArr, i);
        this.f11216c.a();
        this.f11218e.clear();
        h.a(this.f11215b);
        do {
        } while (!TextUtils.isEmpty(this.f11215b.y()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int a2 = a(this.f11215b);
            if (a2 == 0) {
                return new i(arrayList);
            }
            if (a2 == 1) {
                b(this.f11215b);
            } else if (a2 == 2) {
                if (arrayList.isEmpty()) {
                    this.f11215b.y();
                    d a3 = this.f11217d.a(this.f11215b);
                    if (a3 != null) {
                        this.f11218e.add(a3);
                    }
                } else {
                    throw new com.google.android.exoplayer2.p.g("A style block was found after the first cue.");
                }
            } else if (a2 == 3 && this.f11214a.a(this.f11215b, this.f11216c, this.f11218e)) {
                arrayList.add(this.f11216c.b());
                this.f11216c.a();
            }
        }
    }

    private static int a(l lVar) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = lVar.d();
            String y = lVar.y();
            if (y == null) {
                i = 0;
            } else if ("STYLE".equals(y)) {
                i = 2;
            } else {
                i = "NOTE".startsWith(y) ? 1 : 3;
            }
        }
        lVar.c(i2);
        return i;
    }

    private static void b(l lVar) {
        do {
        } while (!TextUtils.isEmpty(lVar.y()));
    }
}
