package com.google.android.exoplayer2.j.f;

import android.text.TextUtils;
import com.google.android.exoplayer2.j.b;
import com.google.android.exoplayer2.j.f;
import com.google.android.exoplayer2.j.f.e;
import com.google.android.exoplayer2.n.k;
import java.util.ArrayList;
import java.util.List;

public final class g extends b {

    /* renamed from: a  reason: collision with root package name */
    private final f f10609a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final k f10610b = new k();

    /* renamed from: c  reason: collision with root package name */
    private final e.a f10611c = new e.a();

    /* renamed from: d  reason: collision with root package name */
    private final a f10612d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final List<d> f10613e = new ArrayList();

    public g() {
        super("WebvttDecoder");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public i a(byte[] bArr, int i, boolean z) throws f {
        this.f10610b.a(bArr, i);
        this.f10611c.a();
        this.f10613e.clear();
        h.a(this.f10610b);
        do {
        } while (!TextUtils.isEmpty(this.f10610b.y()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int a2 = a(this.f10610b);
            if (a2 == 0) {
                return new i(arrayList);
            }
            if (a2 == 1) {
                b(this.f10610b);
            } else if (a2 == 2) {
                if (arrayList.isEmpty()) {
                    this.f10610b.y();
                    d a3 = this.f10612d.a(this.f10610b);
                    if (a3 != null) {
                        this.f10613e.add(a3);
                    }
                } else {
                    throw new f("A style block was found after the first cue.");
                }
            } else if (a2 == 3 && this.f10609a.a(this.f10610b, this.f10611c, this.f10613e)) {
                arrayList.add(this.f10611c.b());
                this.f10611c.a();
            }
        }
    }

    private static int a(k kVar) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = kVar.d();
            String y = kVar.y();
            if (y == null) {
                i = 0;
            } else if ("STYLE".equals(y)) {
                i = 2;
            } else {
                i = "NOTE".startsWith(y) ? 1 : 3;
            }
        }
        kVar.c(i2);
        return i;
    }

    private static void b(k kVar) {
        do {
        } while (!TextUtils.isEmpty(kVar.y()));
    }
}
