package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.i;
import com.google.android.exoplayer2.r.q;
import com.google.android.exoplayer2.r.s;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.b.c;
import com.google.android.exoplayer2.source.b.d;
import com.google.android.exoplayer2.source.b.e;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.b.k;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.b.m;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.manifest.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private final s f11930a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f11931b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.q.f f11932c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11933d;

    /* renamed from: e  reason: collision with root package name */
    private final b[] f11934e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.r.f f11935f;

    /* renamed from: g  reason: collision with root package name */
    private final long f11936g;
    private final int h;
    private com.google.android.exoplayer2.source.dash.manifest.b i;
    private int j;
    private IOException k;
    private boolean l;

    public static final class a implements a.C0193a {

        /* renamed from: a  reason: collision with root package name */
        private final f.a f11937a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11938b;

        public a(f.a aVar) {
            this(aVar, 1);
        }

        public a(f.a aVar, int i) {
            this.f11937a = aVar;
            this.f11938b = i;
        }

        public a a(s sVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.q.f fVar, int i2, long j, boolean z, boolean z2) {
            return new f(sVar, bVar, i, iArr, fVar, i2, this.f11937a.a(), j, this.f11938b, z, z2);
        }
    }

    public f(s sVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i2, int[] iArr, com.google.android.exoplayer2.q.f fVar, int i3, com.google.android.exoplayer2.r.f fVar2, long j2, int i4, boolean z, boolean z2) {
        com.google.android.exoplayer2.q.f fVar3 = fVar;
        this.f11930a = sVar;
        this.i = bVar;
        this.f11931b = iArr;
        this.f11932c = fVar3;
        this.f11933d = i3;
        this.f11935f = fVar2;
        this.j = i2;
        this.f11936g = j2;
        this.h = i4;
        long c2 = bVar.c(i2);
        ArrayList<g> b2 = b();
        this.f11934e = new b[fVar.e()];
        for (int i5 = 0; i5 < this.f11934e.length; i5++) {
            this.f11934e[i5] = new b(c2, b2.get(fVar3.b(i5)), z, z2);
        }
    }

    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i2) {
        try {
            this.i = bVar;
            this.j = i2;
            long c2 = this.i.c(this.j);
            ArrayList<g> b2 = b();
            for (int i3 = 0; i3 < this.f11934e.length; i3++) {
                this.f11934e[i3].a(c2, b2.get(this.f11932c.b(i3)));
            }
        } catch (com.google.android.exoplayer2.source.b e2) {
            this.k = e2;
        }
    }

    public void a() throws IOException {
        IOException iOException = this.k;
        if (iOException == null) {
            this.f11930a.d();
            return;
        }
        throw iOException;
    }

    public final void a(l lVar, long j2, e eVar) {
        int i2;
        int i3;
        l lVar2 = lVar;
        long j3 = j2;
        e eVar2 = eVar;
        if (this.k == null) {
            this.f11932c.a(lVar2 != null ? lVar2.f11549g - j3 : 0);
            b bVar = this.f11934e[this.f11932c.a()];
            if (bVar.f11939a != null) {
                g gVar = bVar.f11940b;
                com.google.android.exoplayer2.source.dash.manifest.f c2 = bVar.f11939a.c() == null ? gVar.c() : null;
                com.google.android.exoplayer2.source.dash.manifest.f d2 = bVar.f11941c == null ? gVar.d() : null;
                if (!(c2 == null && d2 == null)) {
                    eVar2.f11562a = a(bVar, this.f11935f, this.f11932c.f(), this.f11932c.b(), this.f11932c.c(), c2, d2);
                    return;
                }
            }
            long c3 = c();
            int b2 = bVar.b();
            boolean z = false;
            if (b2 == 0) {
                if (!this.i.f12000d || this.j < this.i.a() - 1) {
                    z = true;
                }
                eVar2.f11563b = z;
                return;
            }
            int a2 = bVar.a();
            if (b2 == -1) {
                long j4 = (c3 - (this.i.f11997a * 1000)) - (this.i.a(this.j).f12018b * 1000);
                if (this.i.f12002f != -9223372036854775807L) {
                    a2 = Math.max(a2, bVar.a(j4 - (this.i.f12002f * 1000)));
                }
                i2 = bVar.a(j4) - 1;
            } else {
                i2 = (b2 + a2) - 1;
            }
            if (lVar2 == null) {
                i3 = v.a(bVar.a(j3), a2, i2);
            } else {
                i3 = lVar.f();
                if (i3 < a2) {
                    this.k = new com.google.android.exoplayer2.source.b();
                    return;
                }
            }
            int i4 = i3;
            if (i4 > i2 || (this.l && i4 >= i2)) {
                if (!this.i.f12000d || this.j < this.i.a() - 1) {
                    z = true;
                }
                eVar2.f11563b = z;
                return;
            }
            eVar2.f11562a = a(bVar, this.f11935f, this.f11933d, this.f11932c.f(), this.f11932c.b(), this.f11932c.c(), i4, Math.min(this.h, (i2 - i4) + 1));
        }
    }

    public void a(c cVar) {
        if (cVar instanceof k) {
            b bVar = this.f11934e[this.f11932c.a(((k) cVar).f11545c)];
            if (bVar.f11941c == null) {
                com.google.android.exoplayer2.i.l b2 = bVar.f11939a.b();
                if (b2 != null) {
                    bVar.f11941c = new e((com.google.android.exoplayer2.i.a) b2);
                }
            }
        }
    }

    public boolean a(c cVar, boolean z, Exception exc) {
        if (!z) {
            return false;
        }
        if (!this.i.f12000d && (cVar instanceof l) && (exc instanceof q.e) && ((q.e) exc).responseCode == 404) {
            b bVar = this.f11934e[this.f11932c.a(cVar.f11545c)];
            int b2 = bVar.b();
            if (!(b2 == -1 || b2 == 0 || ((l) cVar).f() <= (bVar.a() + b2) - 1)) {
                this.l = true;
                return true;
            }
        }
        com.google.android.exoplayer2.q.f fVar = this.f11932c;
        return h.a(fVar, fVar.a(cVar.f11545c), exc);
    }

    private ArrayList<g> b() {
        List<com.google.android.exoplayer2.source.dash.manifest.a> list = this.i.a(this.j).f12019c;
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i2 : this.f11931b) {
            arrayList.addAll(list.get(i2).f11994c);
        }
        return arrayList;
    }

    private long c() {
        long currentTimeMillis;
        if (this.f11936g != 0) {
            currentTimeMillis = SystemClock.elapsedRealtime() + this.f11936g;
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        return currentTimeMillis * 1000;
    }

    private static c a(b bVar, com.google.android.exoplayer2.r.f fVar, Format format, int i2, Object obj, com.google.android.exoplayer2.source.dash.manifest.f fVar2, com.google.android.exoplayer2.source.dash.manifest.f fVar3) {
        String str = bVar.f11940b.f12027d;
        if (fVar2 != null) {
            fVar3 = fVar2.a(fVar3, str);
            if (fVar3 == null) {
                fVar3 = fVar2;
            }
        }
        return new k(fVar, new i(fVar3.a(str), fVar3.f12020a, fVar3.f12021b, bVar.f11940b.f()), format, i2, obj, bVar.f11939a);
    }

    private static c a(b bVar, com.google.android.exoplayer2.r.f fVar, int i2, Format format, int i3, Object obj, int i4, int i5) {
        b bVar2 = bVar;
        int i6 = i4;
        g gVar = bVar2.f11940b;
        long a2 = bVar2.a(i6);
        com.google.android.exoplayer2.source.dash.manifest.f c2 = bVar2.c(i6);
        String str = gVar.f12027d;
        if (bVar2.f11939a == null) {
            return new m(fVar, new i(c2.a(str), c2.f12020a, c2.f12021b, gVar.f()), format, i3, obj, a2, bVar2.b(i6), i4, i2, format);
        }
        com.google.android.exoplayer2.source.dash.manifest.f fVar2 = c2;
        int i7 = 1;
        int i8 = 1;
        int i9 = i5;
        while (i7 < i9) {
            com.google.android.exoplayer2.source.dash.manifest.f a3 = fVar2.a(bVar2.c(i6 + i7), str);
            if (a3 == null) {
                break;
            }
            i8++;
            i7++;
            fVar2 = a3;
        }
        long b2 = bVar2.b((i6 + i8) - 1);
        Uri a4 = fVar2.a(str);
        long j2 = fVar2.f12020a;
        return new com.google.android.exoplayer2.source.b.i(fVar, new i(a4, j2, fVar2.f12021b, gVar.f()), format, i3, obj, a2, b2, i4, i8, -gVar.f12028e, bVar2.f11939a);
    }

    protected static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final d f11939a;

        /* renamed from: b  reason: collision with root package name */
        public g f11940b;

        /* renamed from: c  reason: collision with root package name */
        public d f11941c;

        /* renamed from: d  reason: collision with root package name */
        private long f11942d;

        /* renamed from: e  reason: collision with root package name */
        private int f11943e;

        public b(long j, g gVar, boolean z, boolean z2) {
            com.google.android.exoplayer2.i.e eVar;
            this.f11942d = j;
            this.f11940b = gVar;
            String str = gVar.f12026c.f8957e;
            if (b(str)) {
                this.f11939a = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new com.google.android.exoplayer2.i.f.a(gVar.f12026c);
                } else if (a(str)) {
                    eVar = new com.google.android.exoplayer2.i.b.d(1);
                } else {
                    int i = z ? 4 : 0;
                    eVar = new com.google.android.exoplayer2.i.d.e(z2 ? i | 8 : i);
                }
                this.f11939a = new d(eVar, gVar.f12026c);
            }
            this.f11941c = gVar.e();
        }

        public void a(long j, g gVar) throws com.google.android.exoplayer2.source.b {
            d e2 = this.f11940b.e();
            d e3 = gVar.e();
            this.f11942d = j;
            this.f11940b = gVar;
            if (e2 != null) {
                this.f11941c = e3;
                if (e2.b()) {
                    int a2 = e2.a(this.f11942d);
                    if (a2 != 0) {
                        int a3 = (e2.a() + a2) - 1;
                        long a4 = e2.a(a3) + e2.a(a3, this.f11942d);
                        int a5 = e3.a();
                        long a6 = e3.a(a5);
                        if (a4 == a6) {
                            this.f11943e += (a3 + 1) - a5;
                        } else if (a4 >= a6) {
                            this.f11943e += e2.a(a6, this.f11942d) - a5;
                        } else {
                            throw new com.google.android.exoplayer2.source.b();
                        }
                    }
                }
            }
        }

        public int a() {
            return this.f11941c.a() + this.f11943e;
        }

        public int b() {
            return this.f11941c.a(this.f11942d);
        }

        public long a(int i) {
            return this.f11941c.a(i - this.f11943e);
        }

        public long b(int i) {
            return a(i) + this.f11941c.a(i - this.f11943e, this.f11942d);
        }

        public int a(long j) {
            return this.f11941c.a(j, this.f11942d) + this.f11943e;
        }

        public com.google.android.exoplayer2.source.dash.manifest.f c(int i) {
            return this.f11941c.b(i - this.f11943e);
        }

        private static boolean a(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean b(String str) {
            return com.google.android.exoplayer2.s.i.c(str) || "application/ttml+xml".equals(str);
        }
    }
}
