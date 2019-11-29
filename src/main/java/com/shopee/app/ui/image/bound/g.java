package com.shopee.app.ui.image.bound;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.shopee.app.ui.image.bound.a;
import com.shopee.app.ui.image.bound.b;
import d.d.b.j;

public class g implements b {

    /* renamed from: b  reason: collision with root package name */
    private int f22782b;

    /* renamed from: c  reason: collision with root package name */
    private int f22783c;

    /* renamed from: d  reason: collision with root package name */
    private Double f22784d;

    /* renamed from: e  reason: collision with root package name */
    private Double f22785e;

    /* renamed from: f  reason: collision with root package name */
    private Double f22786f;

    /* renamed from: g  reason: collision with root package name */
    private Double f22787g;
    private f h;
    private Resources i;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g(android.content.Context r19, com.shopee.app.ui.image.bound.f r20) {
        /*
            r18 = this;
            r11 = r18
            r0 = r20
            java.lang.String r1 = "context"
            r2 = r19
            d.d.b.j.b(r2, r1)
            r18.<init>()
            android.content.res.Resources r1 = r19.getResources()
            r11.i = r1
            r11.h = r0
            r1 = 0
            if (r0 == 0) goto L_0x0028
            android.graphics.drawable.Drawable r2 = r20.b()
            if (r2 == 0) goto L_0x0028
            int r2 = r2.getIntrinsicWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0029
        L_0x0028:
            r2 = r1
        L_0x0029:
            if (r2 != 0) goto L_0x002e
            d.d.b.j.a()
        L_0x002e:
            int r2 = r2.intValue()
            r11.f22782b = r2
            if (r0 == 0) goto L_0x0045
            android.graphics.drawable.Drawable r2 = r20.b()
            if (r2 == 0) goto L_0x0045
            int r2 = r2.getIntrinsicHeight()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0046
        L_0x0045:
            r2 = r1
        L_0x0046:
            if (r2 != 0) goto L_0x004b
            d.d.b.j.a()
        L_0x004b:
            int r2 = r2.intValue()
            r11.f22783c = r2
            if (r0 == 0) goto L_0x0060
            com.shopee.app.ui.image.bound.b$a r2 = r20.a()
            if (r2 == 0) goto L_0x0060
            double r2 = r2.f22766a
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            goto L_0x0061
        L_0x0060:
            r2 = r1
        L_0x0061:
            if (r0 == 0) goto L_0x0070
            com.shopee.app.ui.image.bound.b$a r3 = r20.a()
            if (r3 == 0) goto L_0x0070
            double r3 = r3.f22767b
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            goto L_0x0071
        L_0x0070:
            r3 = r1
        L_0x0071:
            if (r0 == 0) goto L_0x0080
            com.shopee.app.ui.image.bound.b$a r4 = r20.a()
            if (r4 == 0) goto L_0x0080
            double r4 = r4.f22768c
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            goto L_0x0081
        L_0x0080:
            r4 = r1
        L_0x0081:
            if (r0 == 0) goto L_0x0090
            com.shopee.app.ui.image.bound.b$a r5 = r20.a()
            if (r5 == 0) goto L_0x0090
            double r5 = r5.f22769d
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            goto L_0x0091
        L_0x0090:
            r5 = r1
        L_0x0091:
            if (r0 == 0) goto L_0x009f
            com.shopee.app.ui.image.bound.b$a r0 = r20.a()
            if (r0 == 0) goto L_0x009f
            double r0 = r0.f22770e
            java.lang.Double r1 = java.lang.Double.valueOf(r0)
        L_0x009f:
            if (r2 != 0) goto L_0x00a4
            d.d.b.j.a()
        L_0x00a4:
            double r6 = r2.doubleValue()
            if (r3 != 0) goto L_0x00ad
            d.d.b.j.a()
        L_0x00ad:
            double r8 = r3.doubleValue()
            if (r4 != 0) goto L_0x00b6
            d.d.b.j.a()
        L_0x00b6:
            double r12 = r4.doubleValue()
            if (r5 != 0) goto L_0x00bf
            d.d.b.j.a()
        L_0x00bf:
            double r14 = r5.doubleValue()
            if (r1 != 0) goto L_0x00c8
            d.d.b.j.a()
        L_0x00c8:
            double r16 = r1.doubleValue()
            r0 = r18
            r1 = r6
            r3 = r8
            r5 = r12
            r7 = r14
            r9 = r16
            r0.a((double) r1, (double) r3, (double) r5, (double) r7, (double) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.g.<init>(android.content.Context, com.shopee.app.ui.image.bound.f):void");
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        this.f22782b = i2;
    }

    /* access modifiers changed from: protected */
    public final int g() {
        return this.f22782b;
    }

    /* access modifiers changed from: protected */
    public final void b(int i2) {
        this.f22783c = i2;
    }

    /* access modifiers changed from: protected */
    public final int h() {
        return this.f22783c;
    }

    public final f i() {
        return this.h;
    }

    public static /* synthetic */ void a(g gVar, Canvas canvas, Rect rect, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                rect = null;
            }
            gVar.a(canvas, rect);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Canvas r4, android.graphics.Rect r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0005
            r4.save()
        L_0x0005:
            com.shopee.app.ui.image.bound.f r0 = r3.h
            if (r0 == 0) goto L_0x0019
            android.graphics.drawable.Drawable r0 = r0.b()
            if (r0 == 0) goto L_0x0019
            if (r5 == 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            android.graphics.Rect r5 = r3.j()
        L_0x0016:
            r0.setBounds(r5)
        L_0x0019:
            r5 = 0
            if (r4 == 0) goto L_0x0057
            com.shopee.app.ui.image.bound.f r0 = r3.h
            if (r0 == 0) goto L_0x002d
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x002d
            double r0 = r0.f22766a
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x002e
        L_0x002d:
            r0 = r5
        L_0x002e:
            if (r0 != 0) goto L_0x0033
            d.d.b.j.a()
        L_0x0033:
            double r0 = r0.doubleValue()
            float r0 = (float) r0
            com.shopee.app.ui.image.bound.f r1 = r3.h
            if (r1 == 0) goto L_0x0049
            com.shopee.app.ui.image.bound.b$a r1 = r1.a()
            if (r1 == 0) goto L_0x0049
            double r1 = r1.f22767b
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            goto L_0x004a
        L_0x0049:
            r1 = r5
        L_0x004a:
            if (r1 != 0) goto L_0x004f
            d.d.b.j.a()
        L_0x004f:
            double r1 = r1.doubleValue()
            float r1 = (float) r1
            r4.translate(r0, r1)
        L_0x0057:
            if (r4 == 0) goto L_0x0094
            com.shopee.app.ui.image.bound.f r0 = r3.h
            if (r0 == 0) goto L_0x006a
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x006a
            double r0 = r0.f22766a
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x006b
        L_0x006a:
            r0 = r5
        L_0x006b:
            if (r0 != 0) goto L_0x0070
            d.d.b.j.a()
        L_0x0070:
            double r0 = r0.doubleValue()
            float r0 = (float) r0
            float r0 = -r0
            com.shopee.app.ui.image.bound.f r1 = r3.h
            if (r1 == 0) goto L_0x0086
            com.shopee.app.ui.image.bound.b$a r1 = r1.a()
            if (r1 == 0) goto L_0x0086
            double r1 = r1.f22767b
            java.lang.Double r5 = java.lang.Double.valueOf(r1)
        L_0x0086:
            if (r5 != 0) goto L_0x008b
            d.d.b.j.a()
        L_0x008b:
            double r1 = r5.doubleValue()
            float r5 = (float) r1
            float r5 = -r5
            r4.translate(r0, r5)
        L_0x0094:
            com.shopee.app.ui.image.bound.f r5 = r3.h
            if (r5 == 0) goto L_0x00a1
            android.graphics.drawable.Drawable r5 = r5.b()
            if (r5 == 0) goto L_0x00a1
            r5.draw(r4)
        L_0x00a1:
            if (r4 == 0) goto L_0x00a6
            r4.restore()
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.g.a(android.graphics.Canvas, android.graphics.Rect):void");
    }

    public final Rect j() {
        Double d2 = this.f22784d;
        if (d2 == null) {
            j.a();
        }
        int doubleValue = (int) d2.doubleValue();
        Double d3 = this.f22786f;
        if (d3 == null) {
            j.a();
        }
        int doubleValue2 = (int) d3.doubleValue();
        Double d4 = this.f22785e;
        if (d4 == null) {
            j.a();
        }
        int doubleValue3 = (int) d4.doubleValue();
        Double d5 = this.f22787g;
        if (d5 == null) {
            j.a();
        }
        return new Rect(doubleValue, doubleValue2, doubleValue3, (int) d5.doubleValue());
    }

    public boolean a(double d2, double d3) {
        Double d4 = this.f22784d;
        if (d4 == null) {
            j.a();
        }
        double doubleValue = d4.doubleValue();
        Double d5 = this.f22785e;
        if (d5 == null) {
            j.a();
        }
        double doubleValue2 = d5.doubleValue();
        if (d2 >= doubleValue && d2 <= doubleValue2) {
            Double d6 = this.f22786f;
            if (d6 == null) {
                j.a();
            }
            double doubleValue3 = d6.doubleValue();
            Double d7 = this.f22787g;
            if (d7 == null) {
                j.a();
            }
            return d3 >= doubleValue3 && d3 <= d7.doubleValue();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double a() {
        /*
            r2 = this;
            com.shopee.app.ui.image.bound.f r0 = r2.h
            if (r0 == 0) goto L_0x0011
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x0011
            double r0 = r0.f22766a
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0017
            d.d.b.j.a()
        L_0x0017:
            double r0 = r0.doubleValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.g.a():double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double b() {
        /*
            r2 = this;
            com.shopee.app.ui.image.bound.f r0 = r2.h
            if (r0 == 0) goto L_0x0011
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x0011
            double r0 = r0.f22767b
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0017
            d.d.b.j.a()
        L_0x0017:
            double r0 = r0.doubleValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.g.b():double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double c() {
        /*
            r2 = this;
            com.shopee.app.ui.image.bound.f r0 = r2.h
            if (r0 == 0) goto L_0x0011
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x0011
            double r0 = r0.f22768c
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0017
            d.d.b.j.a()
        L_0x0017:
            double r0 = r0.doubleValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.g.c():double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double d() {
        /*
            r2 = this;
            com.shopee.app.ui.image.bound.f r0 = r2.h
            if (r0 == 0) goto L_0x0011
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x0011
            double r0 = r0.f22769d
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0017
            d.d.b.j.a()
        L_0x0017:
            double r0 = r0.doubleValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.g.d():double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double e() {
        /*
            r2 = this;
            com.shopee.app.ui.image.bound.f r0 = r2.h
            if (r0 == 0) goto L_0x0011
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x0011
            double r0 = r0.f22770e
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0017
            d.d.b.j.a()
        L_0x0017:
            double r0 = r0.doubleValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.g.e():double");
    }

    public boolean a(a.c cVar, int i2) {
        double d2;
        double d3;
        Double d4 = null;
        Double valueOf = cVar != null ? Double.valueOf(cVar.a()) : null;
        if (valueOf == null) {
            j.a();
        }
        double doubleValue = valueOf.doubleValue();
        if (cVar != null) {
            d4 = Double.valueOf(cVar.b());
        }
        double doubleValue2 = d4.doubleValue();
        if ((e.b() & i2) != 0) {
            d2 = cVar.d();
        } else {
            d2 = cVar.c();
        }
        double d5 = d2;
        if ((i2 & e.b()) != 0) {
            d3 = cVar.e();
        } else {
            d3 = cVar.c();
        }
        return a(doubleValue, doubleValue2, d5, d3, cVar.f());
    }

    /* access modifiers changed from: protected */
    public boolean a(double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2;
        double d8 = d3;
        double d9 = d4;
        double d10 = d5;
        double d11 = (double) (this.f22782b / 2);
        Double.isNaN(d11);
        double d12 = d11 * d9;
        double d13 = (double) (this.f22783c / 2);
        Double.isNaN(d13);
        double d14 = d13 * d10;
        double d15 = d7 - d12;
        double d16 = d8 - d14;
        double d17 = d12 + d7;
        double d18 = d14 + d8;
        f fVar = this.h;
        if (fVar != null) {
            b.a a2 = fVar.a();
            if (a2 != null) {
                a2.f22766a = d7;
            }
        }
        f fVar2 = this.h;
        if (fVar2 != null) {
            b.a a3 = fVar2.a();
            if (a3 != null) {
                a3.f22767b = d8;
            }
        }
        f fVar3 = this.h;
        if (fVar3 != null) {
            b.a a4 = fVar3.a();
            if (a4 != null) {
                a4.f22768c = d9;
            }
        }
        f fVar4 = this.h;
        if (fVar4 != null) {
            b.a a5 = fVar4.a();
            if (a5 != null) {
                a5.f22769d = d10;
            }
        }
        f fVar5 = this.h;
        if (fVar5 != null) {
            b.a a6 = fVar5.a();
            if (a6 != null) {
                a6.f22770e = d6;
            }
        }
        this.f22784d = Double.valueOf(d15);
        this.f22786f = Double.valueOf(d16);
        this.f22785e = Double.valueOf(d17);
        this.f22787g = Double.valueOf(d18);
        return true;
    }
}
