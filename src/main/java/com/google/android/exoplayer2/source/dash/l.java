package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.m.q;
import com.google.android.exoplayer2.m.s;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.a.c;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.a.e;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.a.k;
import com.google.android.exoplayer2.source.dash.g;
import java.io.IOException;
import java.util.List;

public class l implements g {

    /* renamed from: a  reason: collision with root package name */
    private final s f11974a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11975b;

    /* renamed from: c  reason: collision with root package name */
    private final f f11976c;

    /* renamed from: d  reason: collision with root package name */
    private final b[] f11977d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.m.f f11978e;

    /* renamed from: f  reason: collision with root package name */
    private final long f11979f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11980g;
    private com.google.android.exoplayer2.source.dash.a.b h;
    private int i;
    private IOException j;
    private boolean k;

    public static final class a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        private final f.a f11981a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11982b;

        public a(f.a aVar) {
            this(aVar, 1);
        }

        public a(f.a aVar, int i) {
            this.f11981a = aVar;
            this.f11982b = i;
        }

        public g a(s sVar, com.google.android.exoplayer2.source.dash.a.b bVar, int i, int i2, com.google.android.exoplayer2.l.f fVar, long j, boolean z, boolean z2) {
            return new l(sVar, bVar, i, i2, fVar, this.f11981a.a(), j, this.f11982b, z, z2);
        }
    }

    public l(s sVar, com.google.android.exoplayer2.source.dash.a.b bVar, int i2, int i3, com.google.android.exoplayer2.l.f fVar, com.google.android.exoplayer2.m.f fVar2, long j2, int i4, boolean z, boolean z2) {
        com.google.android.exoplayer2.l.f fVar3 = fVar;
        this.f11974a = sVar;
        this.h = bVar;
        this.f11975b = i3;
        this.f11976c = fVar3;
        this.f11978e = fVar2;
        this.i = i2;
        this.f11979f = j2;
        this.f11980g = i4;
        long c2 = bVar.c(i2);
        com.google.android.exoplayer2.source.dash.a.a b2 = b();
        List<com.google.android.exoplayer2.source.dash.a.f> list = b2.f11840c;
        this.f11977d = new b[fVar.e()];
        for (int i5 = 0; i5 < this.f11977d.length; i5++) {
            this.f11977d[i5] = new b(c2, list.get(fVar3.b(i5)), z, z2, b2.f11839b);
        }
    }

    public void a(com.google.android.exoplayer2.source.dash.a.b bVar, int i2) {
        try {
            this.h = bVar;
            this.i = i2;
            long c2 = this.h.c(this.i);
            List<com.google.android.exoplayer2.source.dash.a.f> list = b().f11840c;
            for (int i3 = 0; i3 < this.f11977d.length; i3++) {
                this.f11977d[i3].a(c2, list.get(this.f11976c.b(i3)));
            }
        } catch (com.google.android.exoplayer2.source.s e2) {
            this.j = e2;
        }
    }

    public void a() throws IOException {
        IOException iOException = this.j;
        if (iOException == null) {
            this.f11974a.d();
            return;
        }
        throw iOException;
    }

    public final void a(com.google.android.exoplayer2.source.a.l lVar, long j2, e eVar) {
        int i2;
        int i3;
        com.google.android.exoplayer2.source.a.l lVar2 = lVar;
        long j3 = j2;
        e eVar2 = eVar;
        if (this.j == null) {
            this.f11976c.a(lVar2 != null ? lVar2.f11502g - j3 : 0);
            b bVar = this.f11977d[this.f11976c.a()];
            if (bVar.f11984b != null) {
                com.google.android.exoplayer2.source.dash.a.f fVar = bVar.f11985c;
                com.google.android.exoplayer2.source.dash.a.e a2 = bVar.f11984b.c() == null ? fVar.a() : null;
                com.google.android.exoplayer2.source.dash.a.e b2 = bVar.f11986d == null ? fVar.b() : null;
                if (!(a2 == null && b2 == null)) {
                    eVar2.f11515a = a(bVar, this.f11978e, this.f11976c.f(), this.f11976c.b(), this.f11976c.c(), a2, b2);
                    return;
                }
            }
            long c2 = c();
            int b3 = bVar.b();
            boolean z = false;
            if (b3 == 0) {
                if (!this.h.f11845d || this.i < this.h.a() - 1) {
                    z = true;
                }
                eVar2.f11516b = z;
                return;
            }
            int a3 = bVar.a();
            if (b3 == -1) {
                long j4 = (c2 - (this.h.f11842a * 1000)) - (this.h.a(this.i).f11860b * 1000);
                if (this.h.f11847f != -9223372036854775807L) {
                    a3 = Math.max(a3, bVar.a(j4 - (this.h.f11847f * 1000)));
                }
                i2 = bVar.a(j4) - 1;
            } else {
                i2 = (b3 + a3) - 1;
            }
            if (lVar2 == null) {
                i3 = t.a(bVar.a(j3), a3, i2);
            } else {
                i3 = lVar.f();
                if (i3 < a3) {
                    this.j = new com.google.android.exoplayer2.source.s();
                    return;
                }
            }
            int i4 = i3;
            if (i4 > i2 || (this.k && i4 >= i2)) {
                if (!this.h.f11845d || this.i < this.h.a() - 1) {
                    z = true;
                }
                eVar2.f11516b = z;
                return;
            }
            eVar2.f11515a = a(bVar, this.f11978e, this.f11976c.f(), this.f11976c.b(), this.f11976c.c(), i4, Math.min(this.f11980g, (i2 - i4) + 1));
        }
    }

    public void a(c cVar) {
        if (cVar instanceof k) {
            b bVar = this.f11977d[this.f11976c.a(((k) cVar).f11498c)];
            if (bVar.f11986d == null) {
                m b2 = bVar.f11984b.b();
                if (b2 != null) {
                    bVar.f11986d = new k((com.google.android.exoplayer2.e.a) b2);
                }
            }
        }
    }

    public boolean a(c cVar, boolean z, Exception exc) {
        if (!z) {
            return false;
        }
        if (!this.h.f11845d && (cVar instanceof com.google.android.exoplayer2.source.a.l) && (exc instanceof q.e) && ((q.e) exc).responseCode == 404) {
            b bVar = this.f11977d[this.f11976c.a(cVar.f11498c)];
            int b2 = bVar.b();
            if (!(b2 == -1 || b2 == 0 || ((com.google.android.exoplayer2.source.a.l) cVar).f() <= (bVar.a() + b2) - 1)) {
                this.k = true;
                return true;
            }
        }
        com.google.android.exoplayer2.l.f fVar = this.f11976c;
        return h.a(fVar, fVar.a(cVar.f11498c), exc);
    }

    private com.google.android.exoplayer2.source.dash.a.a b() {
        return this.h.a(this.i).f11861c.get(this.f11975b);
    }

    private long c() {
        long currentTimeMillis;
        if (this.f11979f != 0) {
            currentTimeMillis = SystemClock.elapsedRealtime() + this.f11979f;
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        return currentTimeMillis * 1000;
    }

    private static c a(b bVar, com.google.android.exoplayer2.m.f fVar, j jVar, int i2, Object obj, com.google.android.exoplayer2.source.dash.a.e eVar, com.google.android.exoplayer2.source.dash.a.e eVar2) {
        String str = bVar.f11985c.f11869d;
        if (eVar != null) {
            eVar2 = eVar.a(eVar2, str);
            if (eVar2 == null) {
                eVar2 = eVar;
            }
        }
        return new k(fVar, new i(eVar2.a(str), eVar2.f11862a, eVar2.f11863b, bVar.f11985c.d()), jVar, i2, obj, bVar.f11984b);
    }

    private static c a(b bVar, com.google.android.exoplayer2.m.f fVar, j jVar, int i2, Object obj, int i3, int i4) {
        b bVar2 = bVar;
        int i5 = i3;
        com.google.android.exoplayer2.source.dash.a.f fVar2 = bVar2.f11985c;
        long a2 = bVar2.a(i5);
        com.google.android.exoplayer2.source.dash.a.e c2 = bVar2.c(i5);
        String str = fVar2.f11869d;
        if (bVar2.f11984b == null) {
            long b2 = bVar2.b(i5);
            i iVar = new i(c2.a(str), c2.f11862a, c2.f11863b, fVar2.d());
            return new com.google.android.exoplayer2.source.a.m(fVar, iVar, jVar, i2, obj, a2, b2, i3, bVar2.f11983a, jVar);
        }
        com.google.android.exoplayer2.source.dash.a.e eVar = c2;
        int i6 = 1;
        int i7 = 1;
        int i8 = i4;
        while (i6 < i8) {
            com.google.android.exoplayer2.source.dash.a.e a3 = eVar.a(bVar2.c(i5 + i6), str);
            if (a3 == null) {
                break;
            }
            i7++;
            i6++;
            eVar = a3;
        }
        long b3 = bVar2.b((i5 + i7) - 1);
        Uri a4 = eVar.a(str);
        long j2 = eVar.f11862a;
        return new com.google.android.exoplayer2.source.a.i(fVar, new i(a4, j2, eVar.f11863b, fVar2.d()), jVar, i2, obj, a2, b3, i3, i7, -fVar2.f11870e, bVar2.f11984b);
    }

    protected static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11983a;

        /* renamed from: b  reason: collision with root package name */
        public final d f11984b;

        /* renamed from: c  reason: collision with root package name */
        public com.google.android.exoplayer2.source.dash.a.f f11985c;

        /* renamed from: d  reason: collision with root package name */
        public j f11986d;

        /* renamed from: e  reason: collision with root package name */
        private long f11987e;

        /* renamed from: f  reason: collision with root package name */
        private int f11988f;

        public b(long j, com.google.android.exoplayer2.source.dash.a.f fVar, boolean z, boolean z2, int i) {
            com.google.android.exoplayer2.e.f fVar2;
            this.f11987e = j;
            this.f11985c = fVar;
            this.f11983a = i;
            String str = fVar.f11868c.f10426e;
            if (b(str)) {
                this.f11984b = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    fVar2 = new com.google.android.exoplayer2.e.f.a(fVar.f11868c);
                } else if (a(str)) {
                    fVar2 = new com.google.android.exoplayer2.e.b.d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    fVar2 = new com.google.android.exoplayer2.e.d.e(z2 ? i2 | 8 : i2);
                }
                this.f11984b = new d(fVar2, fVar.f11868c);
            }
            this.f11986d = fVar.c();
        }

        public void a(long j, com.google.android.exoplayer2.source.dash.a.f fVar) throws com.google.android.exoplayer2.source.s {
            j c2 = this.f11985c.c();
            j c3 = fVar.c();
            this.f11987e = j;
            this.f11985c = fVar;
            if (c2 != null) {
                this.f11986d = c3;
                if (c2.f()) {
                    int a2 = c2.a(this.f11987e);
                    if (a2 != 0) {
                        int e2 = (c2.e() + a2) - 1;
                        long b2 = c2.b(e2) + c2.a(e2, this.f11987e);
                        int e3 = c3.e();
                        long b3 = c3.b(e3);
                        if (b2 == b3) {
                            this.f11988f += (e2 + 1) - e3;
                        } else if (b2 >= b3) {
                            this.f11988f += c2.a(b3, this.f11987e) - e3;
                        } else {
                            throw new com.google.android.exoplayer2.source.s();
                        }
                    }
                }
            }
        }

        public int a() {
            return this.f11986d.e() + this.f11988f;
        }

        public int b() {
            return this.f11986d.a(this.f11987e);
        }

        public long a(int i) {
            return this.f11986d.b(i - this.f11988f);
        }

        public long b(int i) {
            return a(i) + this.f11986d.a(i - this.f11988f, this.f11987e);
        }

        public int a(long j) {
            return this.f11986d.a(j, this.f11987e) + this.f11988f;
        }

        public com.google.android.exoplayer2.source.dash.a.e c(int i) {
            return this.f11986d.a(i - this.f11988f);
        }

        private static boolean a(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean b(String str) {
            return com.google.android.exoplayer2.n.h.c(str) || "application/ttml+xml".equals(str);
        }
    }
}
