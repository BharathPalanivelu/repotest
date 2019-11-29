package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.n.q;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.ac;
import com.google.android.exoplayer2.source.c.a.a;
import com.google.android.exoplayer2.source.c.a.b;
import com.google.android.exoplayer2.source.c.a.e;
import com.google.android.exoplayer2.source.s;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class o {

    /* renamed from: a  reason: collision with root package name */
    private final f f11731a;

    /* renamed from: b  reason: collision with root package name */
    private final f f11732b;

    /* renamed from: c  reason: collision with root package name */
    private final w f11733c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0186a[] f11734d;

    /* renamed from: e  reason: collision with root package name */
    private final e f11735e;

    /* renamed from: f  reason: collision with root package name */
    private final ac f11736f;

    /* renamed from: g  reason: collision with root package name */
    private final List<j> f11737g;
    private boolean h;
    private byte[] i;
    private IOException j;
    private a.C0186a k;
    private Uri l;
    private byte[] m;
    private String n;
    private byte[] o;
    private com.google.android.exoplayer2.l.f p;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public com.google.android.exoplayer2.source.a.c f11738a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11739b;

        /* renamed from: c  reason: collision with root package name */
        public a.C0186a f11740c;

        public b() {
            a();
        }

        public void a() {
            this.f11738a = null;
            this.f11739b = false;
            this.f11740c = null;
        }
    }

    public o(e eVar, a.C0186a[] aVarArr, p pVar, w wVar, List<j> list) {
        this.f11735e = eVar;
        this.f11734d = aVarArr;
        this.f11733c = wVar;
        this.f11737g = list;
        j[] jVarArr = new j[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            jVarArr[i2] = aVarArr[i2].f11597b;
            iArr[i2] = i2;
        }
        this.f11731a = pVar.a(1);
        this.f11732b = pVar.a(3);
        this.f11736f = new ac(jVarArr);
        this.p = new c(this.f11736f, iArr);
    }

    public void a() throws IOException {
        IOException iOException = this.j;
        if (iOException == null) {
            a.C0186a aVar = this.k;
            if (aVar != null) {
                this.f11735e.c(aVar);
                return;
            }
            return;
        }
        throw iOException;
    }

    public ac b() {
        return this.f11736f;
    }

    public void a(com.google.android.exoplayer2.l.f fVar) {
        this.p = fVar;
    }

    public void c() {
        this.j = null;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(r rVar, long j2, b bVar) {
        int i2;
        int i3;
        int i4;
        r rVar2 = rVar;
        b bVar2 = bVar;
        if (rVar2 == null) {
            i2 = -1;
        } else {
            i2 = this.f11736f.a(rVar2.f11498c);
        }
        i iVar = null;
        this.k = null;
        long j3 = 0;
        if (rVar2 != null) {
            j3 = Math.max(0, rVar2.f11501f - j2);
        }
        this.p.a(j3);
        int g2 = this.p.g();
        boolean z = false;
        boolean z2 = i2 != g2;
        a.C0186a aVar = this.f11734d[g2];
        if (!this.f11735e.b(aVar)) {
            bVar2.f11740c = aVar;
            this.k = aVar;
            return;
        }
        com.google.android.exoplayer2.source.c.a.b a2 = this.f11735e.a(aVar);
        if (rVar2 == null || z2) {
            long j4 = rVar2 == null ? j2 : rVar2.f11501f;
            if (a2.i || j4 <= a2.a()) {
                List<b.a> list = a2.l;
                Long valueOf = Long.valueOf(j4 - a2.f11600c);
                if (!this.f11735e.e() || rVar2 == null) {
                    z = true;
                }
                i3 = t.a(list, valueOf, true, z) + a2.f11603f;
                if (i3 < a2.f11603f && rVar2 != null) {
                    aVar = this.f11734d[i2];
                    com.google.android.exoplayer2.source.c.a.b a3 = this.f11735e.a(aVar);
                    i3 = rVar.f();
                    a2 = a3;
                    g2 = i2;
                }
            } else {
                i3 = a2.f11603f + a2.l.size();
            }
            i4 = i3;
        } else {
            i4 = rVar.f();
        }
        int i5 = g2;
        a.C0186a aVar2 = aVar;
        if (i4 < a2.f11603f) {
            this.j = new s();
            return;
        }
        int i6 = i4 - a2.f11603f;
        if (i6 < a2.l.size()) {
            b.a aVar3 = a2.l.get(i6);
            if (aVar3.f11609e) {
                Uri a4 = com.google.android.exoplayer2.n.s.a(a2.o, aVar3.f11610f);
                if (!a4.equals(this.l)) {
                    bVar2.f11738a = a(a4, aVar3.f11611g, i5, this.p.b(), this.p.c());
                    return;
                } else if (!t.a((Object) aVar3.f11611g, (Object) this.n)) {
                    a(a4, aVar3.f11611g, this.m);
                }
            } else {
                d();
            }
            b.a aVar4 = a2.k;
            if (aVar4 != null) {
                iVar = new i(com.google.android.exoplayer2.n.s.a(a2.o, aVar4.f11605a), aVar4.h, aVar4.i, (String) null);
            }
            long j5 = a2.f11600c + aVar3.f11608d;
            int i7 = a2.f11602e + aVar3.f11607c;
            q a5 = this.f11733c.a(i7);
            Uri a6 = com.google.android.exoplayer2.n.s.a(a2.o, aVar3.f11605a);
            i iVar2 = r23;
            i iVar3 = new i(a6, aVar3.h, aVar3.i, (String) null);
            bVar2.f11738a = new r(this.f11731a, iVar2, iVar, aVar2, this.f11737g, this.p.b(), this.p.c(), j5, j5 + aVar3.f11606b, i4, i7, this.h, a5, rVar, this.m, this.o);
        } else if (a2.i) {
            bVar2.f11739b = true;
        } else {
            bVar2.f11740c = aVar2;
            this.k = aVar2;
        }
    }

    public void a(com.google.android.exoplayer2.source.a.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.i = aVar.d();
            a(aVar.f11496a.f10764a, aVar.i, aVar.f());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, IOException iOException) {
        if (z) {
            com.google.android.exoplayer2.l.f fVar = this.p;
            if (h.a(fVar, fVar.c(this.f11736f.a(cVar.f11498c)), iOException)) {
                return true;
            }
        }
        return false;
    }

    public void a(a.C0186a aVar, long j2) {
        int a2 = this.f11736f.a(aVar.f11597b);
        if (a2 != -1) {
            int c2 = this.p.c(a2);
            if (c2 != -1) {
                this.p.a(c2, j2);
            }
        }
    }

    private a a(Uri uri, String str, int i2, int i3, Object obj) {
        return new a(this.f11732b, new i(uri, 0, -1, (String) null, 1), this.f11734d[i2].f11597b, i3, obj, this.i, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(str.toLowerCase(Locale.getDefault()).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.l = uri;
        this.m = bArr;
        this.n = str;
        this.o = bArr2;
    }

    private void d() {
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    private static final class c extends com.google.android.exoplayer2.l.b {

        /* renamed from: d  reason: collision with root package name */
        private int f11741d;

        public int b() {
            return 0;
        }

        public Object c() {
            return null;
        }

        public c(ac acVar, int[] iArr) {
            super(acVar, iArr);
            this.f11741d = a(acVar.a(0));
        }

        public void a(long j) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.f11741d, elapsedRealtime)) {
                for (int i = this.f10702b - 1; i >= 0; i--) {
                    if (!b(i, elapsedRealtime)) {
                        this.f11741d = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public int a() {
            return this.f11741d;
        }
    }

    private static final class a extends com.google.android.exoplayer2.source.a.j {
        public final String i;
        private byte[] j;

        public a(f fVar, i iVar, j jVar, int i2, Object obj, byte[] bArr, String str) {
            super(fVar, iVar, 3, jVar, i2, obj, bArr);
            this.i = str;
        }

        /* access modifiers changed from: protected */
        public void a(byte[] bArr, int i2) throws IOException {
            this.j = Arrays.copyOf(bArr, i2);
        }

        public byte[] f() {
            return this.j;
        }
    }
}
