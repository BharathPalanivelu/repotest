package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.i;
import com.google.android.exoplayer2.s.s;
import com.google.android.exoplayer2.s.u;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.b.j;
import com.google.android.exoplayer2.source.c.b.a;
import com.google.android.exoplayer2.source.c.b.b;
import com.google.android.exoplayer2.source.c.b.e;
import com.google.android.exoplayer2.source.o;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

class c {

    /* renamed from: a  reason: collision with root package name */
    private final f f11682a;

    /* renamed from: b  reason: collision with root package name */
    private final f f11683b;

    /* renamed from: c  reason: collision with root package name */
    private final k f11684c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0187a[] f11685d;

    /* renamed from: e  reason: collision with root package name */
    private final e f11686e;

    /* renamed from: f  reason: collision with root package name */
    private final o f11687f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Format> f11688g;
    private boolean h;
    private byte[] i;
    private IOException j;
    private a.C0187a k;
    private Uri l;
    private byte[] m;
    private String n;
    private byte[] o;
    private com.google.android.exoplayer2.q.f p;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public com.google.android.exoplayer2.source.b.c f11689a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11690b;

        /* renamed from: c  reason: collision with root package name */
        public a.C0187a f11691c;

        public b() {
            a();
        }

        public void a() {
            this.f11689a = null;
            this.f11690b = false;
            this.f11691c = null;
        }
    }

    public c(e eVar, a.C0187a[] aVarArr, d dVar, k kVar, List<Format> list) {
        this.f11686e = eVar;
        this.f11685d = aVarArr;
        this.f11684c = kVar;
        this.f11688g = list;
        Format[] formatArr = new Format[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            formatArr[i2] = aVarArr[i2].f11643b;
            iArr[i2] = i2;
        }
        this.f11682a = dVar.a(1);
        this.f11683b = dVar.a(3);
        this.f11687f = new o(formatArr);
        this.p = new C0189c(this.f11687f, iArr);
    }

    public void a() throws IOException {
        IOException iOException = this.j;
        if (iOException == null) {
            a.C0187a aVar = this.k;
            if (aVar != null) {
                this.f11686e.c(aVar);
                return;
            }
            return;
        }
        throw iOException;
    }

    public o b() {
        return this.f11687f;
    }

    public void a(com.google.android.exoplayer2.q.f fVar) {
        this.p = fVar;
    }

    public com.google.android.exoplayer2.q.f c() {
        return this.p;
    }

    public void d() {
        this.j = null;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(f fVar, long j2, b bVar) {
        int i2;
        int i3;
        int i4;
        f fVar2 = fVar;
        b bVar2 = bVar;
        if (fVar2 == null) {
            i2 = -1;
        } else {
            i2 = this.f11687f.a(fVar2.f11545c);
        }
        i iVar = null;
        this.k = null;
        long j3 = 0;
        if (fVar2 != null) {
            j3 = Math.max(0, fVar2.f11548f - j2);
        }
        this.p.a(j3);
        int g2 = this.p.g();
        boolean z = false;
        boolean z2 = i2 != g2;
        a.C0187a aVar = this.f11685d[g2];
        if (!this.f11686e.b(aVar)) {
            bVar2.f11691c = aVar;
            this.k = aVar;
            return;
        }
        com.google.android.exoplayer2.source.c.b.b a2 = this.f11686e.a(aVar);
        if (fVar2 == null || z2) {
            long j4 = fVar2 == null ? j2 : a2.i ? fVar2.f11549g : fVar2.f11548f;
            if (a2.j || j4 < a2.a()) {
                List<b.a> list = a2.m;
                Long valueOf = Long.valueOf(j4 - a2.f11646c);
                if (!this.f11686e.e() || fVar2 == null) {
                    z = true;
                }
                i3 = v.a(list, valueOf, true, z) + a2.f11649f;
                if (i3 < a2.f11649f && fVar2 != null) {
                    aVar = this.f11685d[i2];
                    com.google.android.exoplayer2.source.c.b.b a3 = this.f11686e.a(aVar);
                    i3 = fVar.f();
                    a2 = a3;
                    g2 = i2;
                }
            } else {
                i3 = a2.f11649f + a2.m.size();
            }
            i4 = i3;
        } else {
            i4 = fVar.f();
        }
        int i5 = g2;
        a.C0187a aVar2 = aVar;
        if (i4 < a2.f11649f) {
            this.j = new com.google.android.exoplayer2.source.b();
            return;
        }
        int i6 = i4 - a2.f11649f;
        if (i6 < a2.m.size()) {
            b.a aVar3 = a2.m.get(i6);
            if (aVar3.f11655e) {
                Uri a4 = u.a(a2.o, aVar3.f11656f);
                if (!a4.equals(this.l)) {
                    bVar2.f11689a = a(a4, aVar3.f11657g, i5, this.p.b(), this.p.c());
                    return;
                } else if (!v.a((Object) aVar3.f11657g, (Object) this.n)) {
                    a(a4, aVar3.f11657g, this.m);
                }
            } else {
                e();
            }
            b.a aVar4 = a2.l;
            if (aVar4 != null) {
                iVar = new i(u.a(a2.o, aVar4.f11651a), aVar4.h, aVar4.i, (String) null);
            }
            long j5 = a2.f11646c + aVar3.f11654d;
            int i7 = a2.f11648e + aVar3.f11653c;
            s a5 = this.f11684c.a(i7);
            Uri a6 = u.a(a2.o, aVar3.f11651a);
            i iVar2 = r23;
            i iVar3 = new i(a6, aVar3.h, aVar3.i, (String) null);
            bVar2.f11689a = new f(this.f11682a, iVar2, iVar, aVar2, this.f11688g, this.p.b(), this.p.c(), j5, j5 + aVar3.f11652b, i4, i7, this.h, a5, fVar, this.m, this.o);
        } else if (a2.j) {
            bVar2.f11690b = true;
        } else {
            bVar2.f11691c = aVar2;
            this.k = aVar2;
        }
    }

    public void a(com.google.android.exoplayer2.source.b.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.i = aVar.d();
            a(aVar.f11543a.f11313a, aVar.i, aVar.f());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.b.c cVar, boolean z, IOException iOException) {
        if (z) {
            com.google.android.exoplayer2.q.f fVar = this.p;
            if (h.a(fVar, fVar.c(this.f11687f.a(cVar.f11545c)), iOException)) {
                return true;
            }
        }
        return false;
    }

    public void a(a.C0187a aVar, long j2) {
        int a2 = this.f11687f.a(aVar.f11643b);
        if (a2 != -1) {
            int c2 = this.p.c(a2);
            if (c2 != -1) {
                this.p.a(c2, j2);
            }
        }
    }

    private a a(Uri uri, String str, int i2, int i3, Object obj) {
        return new a(this.f11683b, new i(uri, 0, -1, (String) null, 1), this.f11685d[i2].f11643b, i3, obj, this.i, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.d(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.l = uri;
        this.m = bArr;
        this.n = str;
        this.o = bArr2;
    }

    private void e() {
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    /* renamed from: com.google.android.exoplayer2.source.c.c$c  reason: collision with other inner class name */
    private static final class C0189c extends com.google.android.exoplayer2.q.b {

        /* renamed from: d  reason: collision with root package name */
        private int f11692d;

        public int b() {
            return 0;
        }

        public Object c() {
            return null;
        }

        public C0189c(o oVar, int[] iArr) {
            super(oVar, iArr);
            this.f11692d = a(oVar.a(0));
        }

        public void a(long j) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.f11692d, elapsedRealtime)) {
                for (int i = this.f11251b - 1; i >= 0; i--) {
                    if (!b(i, elapsedRealtime)) {
                        this.f11692d = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public int a() {
            return this.f11692d;
        }
    }

    private static final class a extends j {
        public final String i;
        private byte[] j;

        public a(f fVar, i iVar, Format format, int i2, Object obj, byte[] bArr, String str) {
            super(fVar, iVar, 3, format, i2, obj, bArr);
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
