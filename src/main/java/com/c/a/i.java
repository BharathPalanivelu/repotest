package com.c.a;

import android.content.Context;
import android.widget.ImageView;
import com.c.a.c.b.h;
import com.c.a.g.a;
import com.c.a.g.a.e;
import com.c.a.g.b;
import com.c.a.g.c;
import com.c.a.g.d;
import com.c.a.g.f;
import com.c.a.g.g;
import com.c.a.g.j;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class i<TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected static final g f6221a = new g().b(h.f5809c).a(g.LOW).b(true);

    /* renamed from: b  reason: collision with root package name */
    protected g f6222b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f6223c;

    /* renamed from: d  reason: collision with root package name */
    private final j f6224d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<TranscodeType> f6225e;

    /* renamed from: f  reason: collision with root package name */
    private final g f6226f;

    /* renamed from: g  reason: collision with root package name */
    private final c f6227g;
    private final e h;
    private k<?, ? super TranscodeType> i;
    private Object j;
    private f<TranscodeType> k;
    private i<TranscodeType> l;
    private i<TranscodeType> m;
    private Float n;
    private boolean o = true;
    private boolean p;
    private boolean q;

    protected i(c cVar, j jVar, Class<TranscodeType> cls, Context context) {
        this.f6227g = cVar;
        this.f6224d = jVar;
        this.f6225e = cls;
        this.f6226f = jVar.g();
        this.f6223c = context;
        this.i = jVar.b(cls);
        this.f6222b = this.f6226f;
        this.h = cVar.e();
    }

    public i<TranscodeType> a(g gVar) {
        com.c.a.i.h.a(gVar);
        this.f6222b = a().a(gVar);
        return this;
    }

    /* access modifiers changed from: protected */
    public g a() {
        g gVar = this.f6226f;
        g gVar2 = this.f6222b;
        return gVar == gVar2 ? gVar2.clone() : gVar2;
    }

    public i<TranscodeType> a(f<TranscodeType> fVar) {
        this.k = fVar;
        return this;
    }

    public i<TranscodeType> a(Object obj) {
        return b(obj);
    }

    private i<TranscodeType> b(Object obj) {
        this.j = obj;
        this.p = true;
        return this;
    }

    /* renamed from: b */
    public i<TranscodeType> clone() {
        try {
            i<TranscodeType> iVar = (i) super.clone();
            iVar.f6222b = iVar.f6222b.clone();
            iVar.i = iVar.i.clone();
            return iVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public <Y extends e<TranscodeType>> Y a(Y y) {
        return a(y, (f) null);
    }

    /* access modifiers changed from: private */
    public <Y extends e<TranscodeType>> Y a(Y y, f<TranscodeType> fVar) {
        return a(y, fVar, a());
    }

    private <Y extends e<TranscodeType>> Y a(Y y, f<TranscodeType> fVar, g gVar) {
        com.c.a.i.i.a();
        com.c.a.i.h.a(y);
        if (this.p) {
            c b2 = b(y, fVar, gVar.c());
            c a2 = y.a();
            if (b2.a(a2)) {
                b2.i();
                if (!((c) com.c.a.i.h.a(a2)).d()) {
                    a2.a();
                }
                return y;
            }
            this.f6224d.a((e<?>) y);
            y.a(b2);
            this.f6224d.a(y, b2);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public b<TranscodeType> c() {
        return a((int) RNCartPanelDataEntity.NULL_VALUE, (int) RNCartPanelDataEntity.NULL_VALUE);
    }

    public b<TranscodeType> a(int i2, int i3) {
        final com.c.a.g.e eVar = new com.c.a.g.e(this.h.b(), i2, i3);
        if (com.c.a.i.i.d()) {
            this.h.b().post(new Runnable() {
                public void run() {
                    if (!eVar.isCancelled()) {
                        i iVar = i.this;
                        com.c.a.g.e eVar = eVar;
                        e unused = iVar.a(eVar, eVar);
                    }
                }
            });
        } else {
            a(eVar, eVar);
        }
        return eVar;
    }

    /* renamed from: com.c.a.i$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6230a = new int[ImageView.ScaleType.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f6231b = new int[g.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        static {
            /*
                com.c.a.g[] r0 = com.c.a.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6231b = r0
                r0 = 1
                int[] r1 = f6231b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.c.a.g r2 = com.c.a.g.LOW     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f6231b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.c.a.g r3 = com.c.a.g.NORMAL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f6231b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.c.a.g r4 = com.c.a.g.HIGH     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f6231b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.c.a.g r5 = com.c.a.g.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f6230a = r4
                int[] r4 = f6230a     // Catch:{ NoSuchFieldError -> 0x0048 }
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f6230a     // Catch:{ NoSuchFieldError -> 0x0052 }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f6230a     // Catch:{ NoSuchFieldError -> 0x005c }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f6230a     // Catch:{ NoSuchFieldError -> 0x0066 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f6230a     // Catch:{ NoSuchFieldError -> 0x0071 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f6230a     // Catch:{ NoSuchFieldError -> 0x007c }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f6230a     // Catch:{ NoSuchFieldError -> 0x0087 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f6230a     // Catch:{ NoSuchFieldError -> 0x0093 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.c.a.i.AnonymousClass2.<clinit>():void");
        }
    }

    private g a(g gVar) {
        int i2 = AnonymousClass2.f6231b[gVar.ordinal()];
        if (i2 == 1) {
            return g.NORMAL;
        }
        if (i2 == 2) {
            return g.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return g.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + this.f6222b.s());
    }

    private c b(e<TranscodeType> eVar, f<TranscodeType> fVar, g gVar) {
        return a(eVar, fVar, (d) null, this.i, gVar.s(), gVar.t(), gVar.v(), gVar);
    }

    private c a(e<TranscodeType> eVar, f<TranscodeType> fVar, d dVar, k<?, ? super TranscodeType> kVar, g gVar, int i2, int i3, g gVar2) {
        a aVar;
        a aVar2;
        if (this.m != null) {
            aVar2 = new a(dVar);
            aVar = aVar2;
        } else {
            aVar = null;
            aVar2 = dVar;
        }
        c b2 = b(eVar, fVar, aVar2, kVar, gVar, i2, i3, gVar2);
        if (aVar == null) {
            return b2;
        }
        int t = this.m.f6222b.t();
        int v = this.m.f6222b.v();
        if (com.c.a.i.i.a(i2, i3) && !this.m.f6222b.u()) {
            t = gVar2.t();
            v = gVar2.v();
        }
        i<TranscodeType> iVar = this.m;
        a aVar3 = aVar;
        aVar3.a(b2, iVar.a(eVar, fVar, (d) aVar, iVar.i, iVar.f6222b.s(), t, v, this.m.f6222b));
        return aVar3;
    }

    private c b(e<TranscodeType> eVar, f<TranscodeType> fVar, d dVar, k<?, ? super TranscodeType> kVar, g gVar, int i2, int i3, g gVar2) {
        d dVar2 = dVar;
        g gVar3 = gVar;
        i<TranscodeType> iVar = this.l;
        if (iVar != null) {
            if (!this.q) {
                k<?, ? super TranscodeType> kVar2 = iVar.o ? kVar : iVar.i;
                g s = this.l.f6222b.r() ? this.l.f6222b.s() : a(gVar3);
                int t = this.l.f6222b.t();
                int v = this.l.f6222b.v();
                if (com.c.a.i.i.a(i2, i3) && !this.l.f6222b.u()) {
                    t = gVar2.t();
                    v = gVar2.v();
                }
                j jVar = new j(dVar2);
                c a2 = a(eVar, fVar, gVar2, (d) jVar, kVar, gVar, i2, i3);
                this.q = true;
                i<TranscodeType> iVar2 = this.l;
                j jVar2 = jVar;
                c a3 = iVar2.a(eVar, fVar, (d) jVar, kVar2, s, t, v, iVar2.f6222b);
                this.q = false;
                jVar2.a(a2, a3);
                return jVar2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.n == null) {
            return a(eVar, fVar, gVar2, dVar, kVar, gVar, i2, i3);
        } else {
            j jVar3 = new j(dVar2);
            f<TranscodeType> fVar2 = fVar;
            j jVar4 = jVar3;
            k<?, ? super TranscodeType> kVar3 = kVar;
            int i4 = i2;
            int i5 = i3;
            jVar3.a(a(eVar, fVar2, gVar2, (d) jVar4, kVar3, gVar, i4, i5), a(eVar, fVar2, gVar2.clone().a(this.n.floatValue()), (d) jVar4, kVar3, a(gVar3), i4, i5));
            return jVar3;
        }
    }

    private c a(e<TranscodeType> eVar, f<TranscodeType> fVar, g gVar, d dVar, k<?, ? super TranscodeType> kVar, g gVar2, int i2, int i3) {
        Context context = this.f6223c;
        e eVar2 = this.h;
        return com.c.a.g.i.a(context, eVar2, this.j, this.f6225e, gVar, i2, i3, gVar2, eVar, fVar, this.k, dVar, eVar2.c(), kVar.b());
    }
}
