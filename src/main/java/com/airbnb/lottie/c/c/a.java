package com.airbnb.lottie.c.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.d;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.g;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.b.g;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.c.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class a implements d, a.C0069a, f {

    /* renamed from: a  reason: collision with root package name */
    final Matrix f3605a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    final com.airbnb.lottie.f f3606b;

    /* renamed from: c  reason: collision with root package name */
    final d f3607c;

    /* renamed from: d  reason: collision with root package name */
    final o f3608d;

    /* renamed from: e  reason: collision with root package name */
    private final Path f3609e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f3610f = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    private final Paint f3611g = new Paint(1);
    private final Paint h = new Paint(1);
    private final Paint i = new Paint(1);
    private final Paint j = new Paint(1);
    private final Paint k = new Paint();
    private final RectF l = new RectF();
    private final RectF m = new RectF();
    private final RectF n = new RectF();
    private final RectF o = new RectF();
    private final String p;
    private g q;
    private a r;
    private a s;
    private List<a> t;
    private final List<com.airbnb.lottie.a.b.a<?, ?>> u = new ArrayList();
    private boolean v = true;

    public void a(List<b> list, List<b> list2) {
    }

    /* access modifiers changed from: package-private */
    public abstract void b(Canvas canvas, Matrix matrix, int i2);

    /* access modifiers changed from: package-private */
    public void b(e eVar, int i2, List<e> list, e eVar2) {
    }

    static a a(d dVar, com.airbnb.lottie.f fVar, com.airbnb.lottie.d dVar2) {
        switch (dVar.k()) {
            case Shape:
                return new f(fVar, dVar);
            case PreComp:
                return new b(fVar, dVar, dVar2.b(dVar.g()), dVar2);
            case Solid:
                return new g(fVar, dVar);
            case Image:
                return new c(fVar, dVar);
            case Null:
                return new e(fVar, dVar);
            case Text:
                return new h(fVar, dVar);
            default:
                c.b("Unknown layer type " + dVar.k());
                return null;
        }
    }

    a(com.airbnb.lottie.f fVar, d dVar) {
        this.f3606b = fVar;
        this.f3607c = dVar;
        this.p = dVar.f() + "#draw";
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (dVar.l() == d.b.Invert) {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.f3608d = dVar.o().h();
        this.f3608d.a((a.C0069a) this);
        if (dVar.j() != null && !dVar.j().isEmpty()) {
            this.q = new g(dVar.j());
            for (com.airbnb.lottie.a.b.a<l, Path> a2 : this.q.b()) {
                a2.a((a.C0069a) this);
            }
            for (com.airbnb.lottie.a.b.a next : this.q.c()) {
                a((com.airbnb.lottie.a.b.a<?, ?>) next);
                next.a((a.C0069a) this);
            }
        }
        f();
    }

    public void a() {
        g();
    }

    /* access modifiers changed from: package-private */
    public d c() {
        return this.f3607c;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.r = aVar;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.r != null;
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.s = aVar;
    }

    private void f() {
        boolean z = true;
        if (!this.f3607c.d().isEmpty()) {
            final com.airbnb.lottie.a.b.c cVar = new com.airbnb.lottie.a.b.c(this.f3607c.d());
            cVar.a();
            cVar.a((a.C0069a) new a.C0069a() {
                public void a() {
                    a.this.a(((Float) cVar.e()).floatValue() == 1.0f);
                }
            });
            if (((Float) cVar.e()).floatValue() != 1.0f) {
                z = false;
            }
            a(z);
            a((com.airbnb.lottie.a.b.a<?, ?>) cVar);
            return;
        }
        a(true);
    }

    private void g() {
        this.f3606b.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.u.add(aVar);
    }

    public void a(RectF rectF, Matrix matrix) {
        this.f3605a.set(matrix);
        this.f3605a.preConcat(this.f3608d.d());
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        c.c(this.p);
        if (!this.v) {
            c.d(this.p);
            return;
        }
        h();
        c.c("Layer#parentMatrix");
        this.f3610f.reset();
        this.f3610f.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.f3610f.preConcat(this.t.get(size).f3608d.d());
        }
        c.d("Layer#parentMatrix");
        int intValue = (int) ((((((float) i2) / 255.0f) * ((float) this.f3608d.a().e().intValue())) / 100.0f) * 255.0f);
        if (d() || e()) {
            c.c("Layer#computeBounds");
            this.l.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            a(this.l, this.f3610f);
            c(this.l, this.f3610f);
            this.f3610f.preConcat(this.f3608d.d());
            b(this.l, this.f3610f);
            this.l.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) canvas.getWidth(), (float) canvas.getHeight());
            c.d("Layer#computeBounds");
            c.c("Layer#saveLayer");
            a(canvas, this.l, this.f3611g, true);
            c.d("Layer#saveLayer");
            a(canvas);
            c.c("Layer#drawLayer");
            b(canvas, this.f3610f, intValue);
            c.d("Layer#drawLayer");
            if (e()) {
                a(canvas, this.f3610f);
            }
            if (d()) {
                c.c("Layer#drawMatte");
                c.c("Layer#saveLayer");
                a(canvas, this.l, this.j, false);
                c.d("Layer#saveLayer");
                a(canvas);
                this.r.a(canvas, matrix, intValue);
                c.c("Layer#restoreLayer");
                canvas.restore();
                c.d("Layer#restoreLayer");
                c.d("Layer#drawMatte");
            }
            c.c("Layer#restoreLayer");
            canvas.restore();
            c.d("Layer#restoreLayer");
            b(c.d(this.p));
            return;
        }
        this.f3610f.preConcat(this.f3608d.d());
        c.c("Layer#drawLayer");
        b(canvas, this.f3610f, intValue);
        c.d("Layer#drawLayer");
        b(c.d(this.p));
    }

    private void b(float f2) {
        this.f3606b.r().a().a(this.f3607c.f(), f2);
    }

    private void a(Canvas canvas) {
        c.c("Layer#clearLayer");
        canvas.drawRect(this.l.left - 1.0f, this.l.top - 1.0f, this.l.right + 1.0f, this.l.bottom + 1.0f, this.k);
        c.d("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.m.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        if (e()) {
            int size = this.q.a().size();
            int i2 = 0;
            while (i2 < size) {
                this.f3609e.set((Path) this.q.b().get(i2).e());
                this.f3609e.transform(matrix);
                int i3 = AnonymousClass2.f3615b[this.q.a().get(i2).a().ordinal()];
                if (i3 != 1 && i3 != 2) {
                    this.f3609e.computeBounds(this.o, false);
                    if (i2 == 0) {
                        this.m.set(this.o);
                    } else {
                        RectF rectF2 = this.m;
                        rectF2.set(Math.min(rectF2.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
                    }
                    i2++;
                } else {
                    return;
                }
            }
            rectF.set(Math.max(rectF.left, this.m.left), Math.max(rectF.top, this.m.top), Math.min(rectF.right, this.m.right), Math.min(rectF.bottom, this.m.bottom));
        }
    }

    /* renamed from: com.airbnb.lottie.c.c.a$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3615b = new int[g.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0072 */
        static {
            /*
                com.airbnb.lottie.c.b.g$a[] r0 = com.airbnb.lottie.c.b.g.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3615b = r0
                r0 = 1
                int[] r1 = f3615b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.g$a r2 = com.airbnb.lottie.c.b.g.a.MaskModeSubtract     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f3615b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.g$a r3 = com.airbnb.lottie.c.b.g.a.MaskModeIntersect     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f3615b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b.g$a r4 = com.airbnb.lottie.c.b.g.a.MaskModeAdd     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.airbnb.lottie.c.c.d$a[] r3 = com.airbnb.lottie.c.c.d.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3614a = r3
                int[] r3 = f3614a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.airbnb.lottie.c.c.d$a r4 = com.airbnb.lottie.c.c.d.a.Shape     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f3614a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.airbnb.lottie.c.c.d$a r3 = com.airbnb.lottie.c.c.d.a.PreComp     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f3614a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.Solid     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r0 = f3614a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.Image     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f3614a     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.Null     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = f3614a     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.Text     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f3614a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.Unknown     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.a.AnonymousClass2.<clinit>():void");
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (d() && this.f3607c.l() != d.b.Invert) {
            this.r.a(this.n, matrix);
            rectF.set(Math.max(rectF.left, this.n.left), Math.max(rectF.top, this.n.top), Math.min(rectF.right, this.n.right), Math.min(rectF.bottom, this.n.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, g.a.MaskModeAdd);
        a(canvas, matrix, g.a.MaskModeIntersect);
        a(canvas, matrix, g.a.MaskModeSubtract);
    }

    private void a(Canvas canvas, Matrix matrix, g.a aVar) {
        Paint paint;
        boolean z = true;
        if (AnonymousClass2.f3615b[aVar.ordinal()] != 1) {
            paint = this.h;
        } else {
            paint = this.i;
        }
        int size = this.q.a().size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = false;
                break;
            } else if (this.q.a().get(i2).a() == aVar) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            c.c("Layer#drawMask");
            c.c("Layer#saveLayer");
            a(canvas, this.l, paint, false);
            c.d("Layer#saveLayer");
            a(canvas);
            for (int i3 = 0; i3 < size; i3++) {
                if (this.q.a().get(i3).a() == aVar) {
                    this.f3609e.set((Path) this.q.b().get(i3).e());
                    this.f3609e.transform(matrix);
                    int alpha = this.f3611g.getAlpha();
                    this.f3611g.setAlpha((int) (((float) ((Integer) this.q.c().get(i3).e()).intValue()) * 2.55f));
                    canvas.drawPath(this.f3609e, this.f3611g);
                    this.f3611g.setAlpha(alpha);
                }
            }
            c.c("Layer#restoreLayer");
            canvas.restore();
            c.d("Layer#restoreLayer");
            c.d("Layer#drawMask");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        com.airbnb.lottie.a.b.g gVar = this.q;
        return gVar != null && !gVar.b().isEmpty();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z != this.v) {
            this.v = z;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.f3608d.a(f2);
        if (this.q != null) {
            for (int i2 = 0; i2 < this.q.b().size(); i2++) {
                this.q.b().get(i2).a(f2);
            }
        }
        if (this.f3607c.b() != BitmapDescriptorFactory.HUE_RED) {
            f2 /= this.f3607c.b();
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.a(aVar.f3607c.b() * f2);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).a(f2);
        }
    }

    private void h() {
        if (this.t == null) {
            if (this.s == null) {
                this.t = Collections.emptyList();
                return;
            }
            this.t = new ArrayList();
            for (a aVar = this.s; aVar != null; aVar = aVar.s) {
                this.t.add(aVar);
            }
        }
    }

    public String b() {
        return this.f3607c.f();
    }

    public void a(e eVar, int i2, List<e> list, e eVar2) {
        if (eVar.a(b(), i2)) {
            if (!"__container".equals(b())) {
                eVar2 = eVar2.a(b());
                if (eVar.c(b(), i2)) {
                    list.add(eVar2.a((f) this));
                }
            }
            if (eVar.d(b(), i2)) {
                b(eVar, i2 + eVar.b(b(), i2), list, eVar2);
            }
        }
    }

    public <T> void a(T t2, com.airbnb.lottie.g.c<T> cVar) {
        this.f3608d.a(t2, cVar);
    }
}
