package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.i;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.j;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

public class m implements j, l, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f3425a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f3426b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3427c;

    /* renamed from: d  reason: collision with root package name */
    private final i.a f3428d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, Float> f3429e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, PointF> f3430f;

    /* renamed from: g  reason: collision with root package name */
    private final a<?, Float> f3431g;
    private final a<?, Float> h;
    private final a<?, Float> i;
    private final a<?, Float> j;
    private final a<?, Float> k;
    private r l;
    private boolean m;

    public m(f fVar, com.airbnb.lottie.c.c.a aVar, i iVar) {
        this.f3427c = fVar;
        this.f3426b = iVar.a();
        this.f3428d = iVar.b();
        this.f3429e = iVar.c().a();
        this.f3430f = iVar.d().a();
        this.f3431g = iVar.e().a();
        this.i = iVar.g().a();
        this.k = iVar.i().a();
        if (this.f3428d == i.a.Star) {
            this.h = iVar.f().a();
            this.j = iVar.h().a();
        } else {
            this.h = null;
            this.j = null;
        }
        aVar.a((a<?, ?>) this.f3429e);
        aVar.a((a<?, ?>) this.f3430f);
        aVar.a((a<?, ?>) this.f3431g);
        aVar.a((a<?, ?>) this.i);
        aVar.a((a<?, ?>) this.k);
        if (this.f3428d == i.a.Star) {
            aVar.a((a<?, ?>) this.h);
            aVar.a((a<?, ?>) this.j);
        }
        this.f3429e.a((a.C0069a) this);
        this.f3430f.a((a.C0069a) this);
        this.f3431g.a((a.C0069a) this);
        this.i.a((a.C0069a) this);
        this.k.a((a.C0069a) this);
        if (this.f3428d == i.a.Star) {
            this.h.a((a.C0069a) this);
            this.j.a((a.C0069a) this);
        }
    }

    public void a() {
        c();
    }

    private void c() {
        this.m = false;
        this.f3427c.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.c() == q.a.Simultaneously) {
                    this.l = rVar;
                    this.l.a(this);
                }
            }
        }
    }

    public Path e() {
        if (this.m) {
            return this.f3425a;
        }
        this.f3425a.reset();
        int i2 = AnonymousClass1.f3432a[this.f3428d.ordinal()];
        if (i2 == 1) {
            d();
        } else if (i2 == 2) {
            f();
        }
        this.f3425a.close();
        com.airbnb.lottie.f.f.a(this.f3425a, this.l);
        this.m = true;
        return this.f3425a;
    }

    /* renamed from: com.airbnb.lottie.a.a.m$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3432a = new int[i.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.airbnb.lottie.c.b.i$a[] r0 = com.airbnb.lottie.c.b.i.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3432a = r0
                int[] r0 = f3432a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.i$a r1 = com.airbnb.lottie.c.b.i.a.Star     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3432a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.i$a r1 = com.airbnb.lottie.c.b.i.a.Polygon     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.m.AnonymousClass1.<clinit>():void");
        }
    }

    public String b() {
        return this.f3426b;
    }

    private void d() {
        double d2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        double d3;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float floatValue = this.f3429e.e().floatValue();
        a<?, Float> aVar = this.f3431g;
        double radians = Math.toRadians((aVar == null ? 0.0d : (double) aVar.e().floatValue()) - 90.0d);
        double d4 = (double) floatValue;
        Double.isNaN(d4);
        float f18 = (float) (6.283185307179586d / d4);
        float f19 = f18 / 2.0f;
        float f20 = floatValue - ((float) ((int) floatValue));
        if (f20 != BitmapDescriptorFactory.HUE_RED) {
            double d5 = (double) ((1.0f - f20) * f19);
            Double.isNaN(d5);
            radians += d5;
        }
        float floatValue2 = this.i.e().floatValue();
        float floatValue3 = this.h.e().floatValue();
        a<?, Float> aVar2 = this.j;
        float floatValue4 = aVar2 != null ? aVar2.e().floatValue() / 100.0f : BitmapDescriptorFactory.HUE_RED;
        a<?, Float> aVar3 = this.k;
        float floatValue5 = aVar3 != null ? aVar3.e().floatValue() / 100.0f : BitmapDescriptorFactory.HUE_RED;
        if (f20 != BitmapDescriptorFactory.HUE_RED) {
            float f21 = ((floatValue2 - floatValue3) * f20) + floatValue3;
            double d6 = (double) f21;
            double cos = Math.cos(radians);
            Double.isNaN(d6);
            d2 = d4;
            float f22 = (float) (d6 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d6);
            float f23 = (float) (d6 * sin);
            this.f3425a.moveTo(f22, f23);
            double d7 = (double) ((f18 * f20) / 2.0f);
            Double.isNaN(d7);
            d3 = radians + d7;
            f2 = f23;
            f5 = f19;
            f4 = f21;
            f3 = f22;
            f6 = floatValue2;
        } else {
            d2 = d4;
            f6 = floatValue2;
            double d8 = (double) f6;
            double cos2 = Math.cos(radians);
            Double.isNaN(d8);
            f5 = f19;
            float f24 = (float) (d8 * cos2);
            double sin2 = Math.sin(radians);
            Double.isNaN(d8);
            float f25 = (float) (d8 * sin2);
            this.f3425a.moveTo(f24, f25);
            double d9 = (double) f5;
            Double.isNaN(d9);
            d3 = radians + d9;
            f2 = f25;
            f3 = f24;
            f4 = BitmapDescriptorFactory.HUE_RED;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i2 = 0;
        double d10 = d3;
        boolean z = false;
        while (true) {
            double d11 = (double) i2;
            if (d11 < ceil) {
                float f26 = z ? f6 : floatValue3;
                if (f4 == BitmapDescriptorFactory.HUE_RED || d11 != ceil - 2.0d) {
                    f7 = f26;
                    f8 = f5;
                } else {
                    f7 = f26;
                    f8 = (f18 * f20) / 2.0f;
                }
                if (f4 == BitmapDescriptorFactory.HUE_RED || d11 != ceil - 1.0d) {
                    f9 = f18;
                    f11 = f7;
                    f10 = f6;
                } else {
                    f9 = f18;
                    f10 = f6;
                    f11 = f4;
                }
                double d12 = (double) f11;
                double cos3 = Math.cos(d10);
                Double.isNaN(d12);
                float f27 = f5;
                float f28 = f4;
                float f29 = (float) (d12 * cos3);
                double sin3 = Math.sin(d10);
                Double.isNaN(d12);
                float f30 = (float) (d12 * sin3);
                if (floatValue4 == BitmapDescriptorFactory.HUE_RED && floatValue5 == BitmapDescriptorFactory.HUE_RED) {
                    this.f3425a.lineTo(f29, f30);
                    f12 = f30;
                    f15 = f29;
                    f14 = floatValue3;
                    f13 = floatValue4;
                    f16 = floatValue5;
                    f17 = f8;
                } else {
                    f15 = f29;
                    f14 = floatValue3;
                    f13 = floatValue4;
                    double atan2 = (double) ((float) (Math.atan2((double) f2, (double) f3) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    f16 = floatValue5;
                    float f31 = f8;
                    f12 = f30;
                    double atan22 = (double) ((float) (Math.atan2((double) f30, (double) f15) - 1.5707963267948966d));
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f32 = z ? f13 : f16;
                    float f33 = z ? f16 : f13;
                    float f34 = (z ? f14 : f10) * f32 * 0.47829f;
                    float f35 = cos4 * f34;
                    float f36 = f34 * sin4;
                    float f37 = (z ? f10 : f14) * f33 * 0.47829f;
                    float f38 = cos5 * f37;
                    float f39 = f37 * sin5;
                    if (f20 != BitmapDescriptorFactory.HUE_RED) {
                        if (i2 == 0) {
                            f35 *= f20;
                            f36 *= f20;
                        } else if (d11 == ceil - 1.0d) {
                            f38 *= f20;
                            f39 *= f20;
                        }
                    }
                    this.f3425a.cubicTo(f3 - f35, f2 - f36, f15 + f38, f12 + f39, f15, f12);
                    f17 = f31;
                }
                double d13 = (double) f17;
                Double.isNaN(d13);
                d10 += d13;
                z = !z;
                i2++;
                floatValue5 = f16;
                f3 = f15;
                f6 = f10;
                f18 = f9;
                floatValue3 = f14;
                floatValue4 = f13;
                f5 = f27;
                f4 = f28;
                f2 = f12;
            } else {
                PointF e2 = this.f3430f.e();
                this.f3425a.offset(e2.x, e2.y);
                this.f3425a.close();
                return;
            }
        }
    }

    private void f() {
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor((double) this.f3429e.e().floatValue());
        a<?, Float> aVar = this.f3431g;
        double radians = Math.toRadians((aVar == null ? 0.0d : (double) aVar.e().floatValue()) - 90.0d);
        double d5 = (double) floor;
        Double.isNaN(d5);
        float floatValue = this.k.e().floatValue() / 100.0f;
        float floatValue2 = this.i.e().floatValue();
        double d6 = (double) floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d6);
        float f2 = (float) (cos * d6);
        double sin = Math.sin(radians);
        Double.isNaN(d6);
        float f3 = (float) (sin * d6);
        this.f3425a.moveTo(f2, f3);
        double d7 = (double) ((float) (6.283185307179586d / d5));
        Double.isNaN(d7);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (((double) i3) < ceil) {
            double cos2 = Math.cos(d8);
            Double.isNaN(d6);
            float f4 = (float) (cos2 * d6);
            double sin2 = Math.sin(d8);
            Double.isNaN(d6);
            double d9 = ceil;
            float f5 = (float) (d6 * sin2);
            if (floatValue != BitmapDescriptorFactory.HUE_RED) {
                d4 = d6;
                i2 = i3;
                d3 = d8;
                double atan2 = (double) ((float) (Math.atan2((double) f3, (double) f2) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d2 = d7;
                double atan22 = (double) ((float) (Math.atan2((double) f5, (double) f4) - 1.5707963267948966d));
                float f6 = floatValue2 * floatValue * 0.25f;
                this.f3425a.cubicTo(f2 - (cos3 * f6), f3 - (((float) Math.sin(atan2)) * f6), f4 + (((float) Math.cos(atan22)) * f6), f5 + (f6 * ((float) Math.sin(atan22))), f4, f5);
            } else {
                d3 = d8;
                d4 = d6;
                d2 = d7;
                i2 = i3;
                this.f3425a.lineTo(f4, f5);
            }
            Double.isNaN(d2);
            d8 = d3 + d2;
            i3 = i2 + 1;
            f3 = f5;
            f2 = f4;
            ceil = d9;
            d6 = d4;
            d7 = d2;
        }
        PointF e2 = this.f3430f.e();
        this.f3425a.offset(e2.x, e2.y);
        this.f3425a.close();
    }

    public void a(e eVar, int i2, List<e> list, e eVar2) {
        com.airbnb.lottie.f.e.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, c<T> cVar) {
        if (t == j.o) {
            this.f3429e.a(cVar);
        } else if (t == j.p) {
            this.f3431g.a(cVar);
        } else if (t == j.h) {
            this.f3430f.a(cVar);
        } else {
            if (t == j.q) {
                a<?, Float> aVar = this.h;
                if (aVar != null) {
                    aVar.a((c<Float>) cVar);
                    return;
                }
            }
            if (t == j.r) {
                this.i.a(cVar);
                return;
            }
            if (t == j.s) {
                a<?, Float> aVar2 = this.j;
                if (aVar2 != null) {
                    aVar2.a((c<Float>) cVar);
                    return;
                }
            }
            if (t == j.t) {
                this.k.a(cVar);
            }
        }
    }
}
