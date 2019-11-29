package com.shopee.app.ui.image.bound;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.ui.image.bound.b;
import d.d.b.j;

public final class d extends g {

    /* renamed from: b  reason: collision with root package name */
    private final int f22771b;

    /* renamed from: c  reason: collision with root package name */
    private final Drawable f22772c;

    /* renamed from: d  reason: collision with root package name */
    private final Drawable f22773d;

    /* renamed from: e  reason: collision with root package name */
    private final Drawable f22774e;

    /* renamed from: f  reason: collision with root package name */
    private final Drawable f22775f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f22776g = new Rect();
    private View h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r10, com.shopee.app.ui.image.bound.f r11, android.view.View r12) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            d.d.b.j.b(r10, r0)
            java.lang.String r0 = "view"
            d.d.b.j.b(r12, r0)
            r9.<init>(r10, r11)
            r0 = 35
            int r0 = com.shopee.app.ui.image.editor.d.d.a(r0, r10)
            r9.f22771b = r0
            android.content.res.Resources r0 = r10.getResources()
            r1 = 2131230880(0x7f0800a0, float:1.8077825E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
            r9.f22772c = r0
            android.content.res.Resources r0 = r10.getResources()
            r1 = 2131230881(0x7f0800a1, float:1.8077827E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
            r9.f22773d = r0
            android.content.res.Resources r0 = r10.getResources()
            r1 = 2131230883(0x7f0800a3, float:1.8077831E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
            r9.f22774e = r0
            android.content.res.Resources r10 = r10.getResources()
            r0 = 2131230882(0x7f0800a2, float:1.807783E38)
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r0)
            r9.f22775f = r10
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            r9.f22776g = r10
            r9.h = r12
            r10 = 0
            if (r11 == 0) goto L_0x0062
            com.shopee.app.ui.image.bound.b$a r12 = r11.a()
            if (r12 == 0) goto L_0x0062
            double r0 = r12.f22766a
            java.lang.Double r12 = java.lang.Double.valueOf(r0)
            goto L_0x0063
        L_0x0062:
            r12 = r10
        L_0x0063:
            if (r11 == 0) goto L_0x0071
            com.shopee.app.ui.image.bound.b$a r11 = r11.a()
            if (r11 == 0) goto L_0x0071
            double r10 = r11.f22767b
            java.lang.Double r10 = java.lang.Double.valueOf(r10)
        L_0x0071:
            if (r12 != 0) goto L_0x0076
            d.d.b.j.a()
        L_0x0076:
            double r1 = r12.doubleValue()
            if (r10 != 0) goto L_0x007f
            d.d.b.j.a()
        L_0x007f:
            double r3 = r10.doubleValue()
            r10 = 1
            double r7 = (double) r10
            r0 = r9
            r5 = r7
            r0.b(r1, r3, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.d.<init>(android.content.Context, com.shopee.app.ui.image.bound.f, android.view.View):void");
    }

    public final Rect f() {
        f i = i();
        b.a a2 = i != null ? i.a() : null;
        if (a2 == null) {
            return null;
        }
        double d2 = a2.f22768c;
        double g2 = (double) g();
        Double.isNaN(g2);
        double d3 = d2 * g2;
        double d4 = a2.f22769d;
        double h2 = (double) h();
        Double.isNaN(h2);
        double d5 = d4 * h2;
        double a3 = a();
        double d6 = (double) 2;
        Double.isNaN(d6);
        double d7 = d3 / d6;
        double b2 = b();
        Double.isNaN(d6);
        double d8 = d5 / d6;
        return new Rect((int) (a3 - d7), (int) (b2 - d8), (int) (a() + d7), (int) (b() + d8));
    }

    public final void a(double d2, double d3, double d4, double d5) {
        a((int) d2);
        b((int) d3);
        double d6 = (double) 1;
        a(d4, d5, d6, d6, (double) 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Canvas r4, android.graphics.Rect r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0005
            r4.save()
        L_0x0005:
            com.shopee.app.ui.image.bound.f r0 = r3.i()
            if (r0 == 0) goto L_0x001b
            android.graphics.drawable.Drawable r0 = r0.b()
            if (r0 == 0) goto L_0x001b
            if (r5 == 0) goto L_0x0014
            goto L_0x0018
        L_0x0014:
            android.graphics.Rect r5 = r3.j()
        L_0x0018:
            r0.setBounds(r5)
        L_0x001b:
            r5 = 0
            if (r4 == 0) goto L_0x005d
            com.shopee.app.ui.image.bound.f r0 = r3.i()
            if (r0 == 0) goto L_0x0031
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x0031
            double r0 = r0.f22766a
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x0032
        L_0x0031:
            r0 = r5
        L_0x0032:
            if (r0 != 0) goto L_0x0037
            d.d.b.j.a()
        L_0x0037:
            double r0 = r0.doubleValue()
            float r0 = (float) r0
            com.shopee.app.ui.image.bound.f r1 = r3.i()
            if (r1 == 0) goto L_0x004f
            com.shopee.app.ui.image.bound.b$a r1 = r1.a()
            if (r1 == 0) goto L_0x004f
            double r1 = r1.f22767b
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            goto L_0x0050
        L_0x004f:
            r1 = r5
        L_0x0050:
            if (r1 != 0) goto L_0x0055
            d.d.b.j.a()
        L_0x0055:
            double r1 = r1.doubleValue()
            float r1 = (float) r1
            r4.translate(r0, r1)
        L_0x005d:
            if (r4 == 0) goto L_0x009e
            com.shopee.app.ui.image.bound.f r0 = r3.i()
            if (r0 == 0) goto L_0x0072
            com.shopee.app.ui.image.bound.b$a r0 = r0.a()
            if (r0 == 0) goto L_0x0072
            double r0 = r0.f22766a
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            goto L_0x0073
        L_0x0072:
            r0 = r5
        L_0x0073:
            if (r0 != 0) goto L_0x0078
            d.d.b.j.a()
        L_0x0078:
            double r0 = r0.doubleValue()
            float r0 = (float) r0
            float r0 = -r0
            com.shopee.app.ui.image.bound.f r1 = r3.i()
            if (r1 == 0) goto L_0x0090
            com.shopee.app.ui.image.bound.b$a r1 = r1.a()
            if (r1 == 0) goto L_0x0090
            double r1 = r1.f22767b
            java.lang.Double r5 = java.lang.Double.valueOf(r1)
        L_0x0090:
            if (r5 != 0) goto L_0x0095
            d.d.b.j.a()
        L_0x0095:
            double r1 = r5.doubleValue()
            float r5 = (float) r1
            float r5 = -r5
            r4.translate(r0, r5)
        L_0x009e:
            com.shopee.app.ui.image.bound.f r5 = r3.i()
            if (r5 == 0) goto L_0x00ad
            android.graphics.drawable.Drawable r5 = r5.b()
            if (r5 == 0) goto L_0x00ad
            r5.draw(r4)
        L_0x00ad:
            android.graphics.drawable.Drawable r5 = r3.f22772c
            if (r5 == 0) goto L_0x00b4
            r5.draw(r4)
        L_0x00b4:
            android.graphics.drawable.Drawable r5 = r3.f22773d
            if (r5 == 0) goto L_0x00bb
            r5.draw(r4)
        L_0x00bb:
            android.graphics.drawable.Drawable r5 = r3.f22775f
            if (r5 == 0) goto L_0x00c2
            r5.draw(r4)
        L_0x00c2:
            android.graphics.drawable.Drawable r5 = r3.f22774e
            if (r5 == 0) goto L_0x00c9
            r5.draw(r4)
        L_0x00c9:
            if (r4 == 0) goto L_0x00ce
            r4.restore()
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.d.a(android.graphics.Canvas, android.graphics.Rect):void");
    }

    /* access modifiers changed from: protected */
    public boolean a(double d2, double d3, double d4, double d5, double d6) {
        double d7;
        double d8;
        double d9;
        double d10;
        double g2 = (double) g();
        Double.isNaN(g2);
        double d11 = g2 * d4;
        double h2 = (double) h();
        Double.isNaN(h2);
        double d12 = h2 * d5;
        double d13 = (double) 2;
        Double.isNaN(d13);
        double d14 = d2 - (d11 / d13);
        Double.isNaN(d13);
        double d15 = d3 + (d12 / d13);
        Rect rect = new Rect((int) d14, (int) (d15 - d12), (int) (d11 + d14), (int) d15);
        View view = this.h;
        if (view != null) {
            view.getLocalVisibleRect(this.f22776g);
        }
        int i = b.a.f7690a;
        if (this.h != null && !this.f22776g.contains(rect)) {
            Rect rect2 = this.f22776g;
            if (rect2 == null) {
                j.a();
            }
            if (rect2.bottom - i < rect.bottom) {
                a.a("setPos too low", new Object[0]);
                Rect rect3 = this.f22776g;
                if (rect3 == null) {
                    j.a();
                }
                rect.bottom = rect3.bottom - i;
            }
            Rect rect4 = this.f22776g;
            if (rect4 == null) {
                j.a();
            }
            if (rect4.top + i > rect.top) {
                a.a("setPos too high", new Object[0]);
                Rect rect5 = this.f22776g;
                if (rect5 == null) {
                    j.a();
                }
                rect.top = rect5.top + i;
            }
            Rect rect6 = this.f22776g;
            if (rect6 == null) {
                j.a();
            }
            if (rect6.right - i < rect.right) {
                a.a("setPos too right", new Object[0]);
                Rect rect7 = this.f22776g;
                if (rect7 == null) {
                    j.a();
                }
                rect.right = rect7.right - i;
            }
            Rect rect8 = this.f22776g;
            if (rect8 == null) {
                j.a();
            }
            if (rect8.left + i > rect.left) {
                a.a("setPos too left", new Object[0]);
                Rect rect9 = this.f22776g;
                if (rect9 == null) {
                    j.a();
                }
                rect.left = rect9.left + i;
            }
        }
        double centerX = (double) rect.centerX();
        double centerY = (double) rect.centerY();
        double width = (double) rect.width();
        double g3 = (double) g();
        Double.isNaN(width);
        Double.isNaN(g3);
        double d16 = width / g3;
        double height = (double) rect.height();
        double h3 = (double) h();
        Double.isNaN(height);
        Double.isNaN(h3);
        double d17 = height / h3;
        double width2 = (double) rect.width();
        double height2 = (double) rect.height();
        double d18 = centerX;
        if (width2 < ((double) b.a.t)) {
            a.a("bound preview scaledWidth < dp70", new Object[0]);
            double d19 = (double) b.a.t;
            double g4 = (double) g();
            Double.isNaN(d19);
            Double.isNaN(g4);
            double d20 = d19 / g4;
            int i2 = this.f22771b;
            double d21 = d18 < ((double) i2) ? (double) (i2 + i) : d18;
            if (d21 > ((double) ((this.f22776g.width() - this.f22771b) - i))) {
                d21 = (double) ((this.f22776g.width() - this.f22771b) - i);
            }
            d7 = d20;
            d8 = d21;
        } else {
            d8 = d18;
            d7 = d16;
        }
        if (height2 < ((double) b.a.t)) {
            a.a("bound preview scaledWidth < dp70", new Object[0]);
            double d22 = (double) b.a.t;
            double h4 = (double) h();
            Double.isNaN(d22);
            Double.isNaN(h4);
            double d23 = d22 / h4;
            if (centerY < ((double) (this.f22776g.top + this.f22771b + i))) {
                centerY = (double) (this.f22776g.top + this.f22771b + i);
            }
            if (centerY > ((double) ((this.f22776g.bottom - this.f22771b) - i))) {
                d9 = d23;
                d10 = (double) ((this.f22776g.bottom - this.f22771b) - i);
                super.a(d8, d10, d7, d9, d6);
                b(d8, d10, d7, d9);
                return true;
            }
            d9 = d23;
        } else {
            d9 = d17;
        }
        d10 = centerY;
        super.a(d8, d10, d7, d9, d6);
        b(d8, d10, d7, d9);
        return true;
    }

    private final void b(double d2, double d3, double d4, double d5) {
        double g2 = (double) g();
        Double.isNaN(g2);
        double d6 = g2 * d4;
        double h2 = (double) h();
        Double.isNaN(h2);
        double d7 = h2 * d5;
        double d8 = (double) 2;
        Double.isNaN(d8);
        double d9 = d2 - (d6 / d8);
        double d10 = d6 + d9;
        Double.isNaN(d8);
        double d11 = d3 + (d7 / d8);
        double d12 = d11 - d7;
        Drawable drawable = this.f22772c;
        if (drawable != null) {
            int i = this.f22771b;
            double d13 = (double) i;
            Double.isNaN(d13);
            double d14 = (double) i;
            Double.isNaN(d14);
            drawable.setBounds((int) d9, (int) (d11 - d13), (int) (d14 + d9), (int) d11);
        }
        Drawable drawable2 = this.f22773d;
        if (drawable2 != null) {
            int i2 = this.f22771b;
            double d15 = (double) i2;
            Double.isNaN(d15);
            double d16 = (double) i2;
            Double.isNaN(d16);
            drawable2.setBounds((int) (d10 - d15), (int) (d11 - d16), (int) d10, (int) d11);
        }
        Drawable drawable3 = this.f22774e;
        if (drawable3 != null) {
            int i3 = this.f22771b;
            double d17 = (double) i3;
            Double.isNaN(d17);
            double d18 = (double) i3;
            Double.isNaN(d18);
            drawable3.setBounds((int) (d10 - d17), (int) d12, (int) d10, (int) (d18 + d12));
        }
        Drawable drawable4 = this.f22775f;
        if (drawable4 != null) {
            int i4 = this.f22771b;
            double d19 = (double) i4;
            Double.isNaN(d19);
            double d20 = (double) i4;
            Double.isNaN(d20);
            drawable4.setBounds((int) d9, (int) d12, (int) (d9 + d19), (int) (d12 + d20));
        }
    }
}
