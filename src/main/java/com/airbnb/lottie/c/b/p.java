package com.airbnb.lottie.c.b;

import android.graphics.Paint;
import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.f;
import java.util.List;

public class p implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3587a;

    /* renamed from: b  reason: collision with root package name */
    private final com.airbnb.lottie.c.a.b f3588b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.airbnb.lottie.c.a.b> f3589c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.c.a.a f3590d;

    /* renamed from: e  reason: collision with root package name */
    private final d f3591e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.c.a.b f3592f;

    /* renamed from: g  reason: collision with root package name */
    private final a f3593g;
    private final b h;
    private final float i;

    public enum a {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            int i = AnonymousClass1.f3594a[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    /* renamed from: com.airbnb.lottie.c.b.p$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3594a = new int[a.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3595b = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        static {
            /*
                com.airbnb.lottie.c.b.p$b[] r0 = com.airbnb.lottie.c.b.p.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3595b = r0
                r0 = 1
                int[] r1 = f3595b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.p$b r2 = com.airbnb.lottie.c.b.p.b.Bevel     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f3595b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.p$b r3 = com.airbnb.lottie.c.b.p.b.Miter     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f3595b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b.p$b r4 = com.airbnb.lottie.c.b.p.b.Round     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.airbnb.lottie.c.b.p$a[] r3 = com.airbnb.lottie.c.b.p.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3594a = r3
                int[] r3 = f3594a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.airbnb.lottie.c.b.p$a r4 = com.airbnb.lottie.c.b.p.a.Butt     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f3594a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.airbnb.lottie.c.b.p$a r3 = com.airbnb.lottie.c.b.p.a.Round     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f3594a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.airbnb.lottie.c.b.p$a r1 = com.airbnb.lottie.c.b.p.a.Unknown     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.b.p.AnonymousClass1.<clinit>():void");
        }
    }

    public enum b {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i = AnonymousClass1.f3595b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, com.airbnb.lottie.c.a.b bVar, List<com.airbnb.lottie.c.a.b> list, com.airbnb.lottie.c.a.a aVar, d dVar, com.airbnb.lottie.c.a.b bVar2, a aVar2, b bVar3, float f2) {
        this.f3587a = str;
        this.f3588b = bVar;
        this.f3589c = list;
        this.f3590d = aVar;
        this.f3591e = dVar;
        this.f3592f = bVar2;
        this.f3593g = aVar2;
        this.h = bVar3;
        this.i = f2;
    }

    public com.airbnb.lottie.a.a.b a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String a() {
        return this.f3587a;
    }

    public com.airbnb.lottie.c.a.a b() {
        return this.f3590d;
    }

    public d c() {
        return this.f3591e;
    }

    public com.airbnb.lottie.c.a.b d() {
        return this.f3592f;
    }

    public List<com.airbnb.lottie.c.a.b> e() {
        return this.f3589c;
    }

    public com.airbnb.lottie.c.a.b f() {
        return this.f3588b;
    }

    public a g() {
        return this.f3593g;
    }

    public b h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }
}
