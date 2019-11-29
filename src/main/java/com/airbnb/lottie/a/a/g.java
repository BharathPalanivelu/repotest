package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.b.d;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.c.b.f;
import com.airbnb.lottie.f.e;
import com.airbnb.lottie.j;
import java.util.ArrayList;
import java.util.List;

public class g implements d, j, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    private final String f3405a;

    /* renamed from: b  reason: collision with root package name */
    private final com.airbnb.lottie.c.c.a f3406b;

    /* renamed from: c  reason: collision with root package name */
    private final d<LinearGradient> f3407c = new d<>();

    /* renamed from: d  reason: collision with root package name */
    private final d<RadialGradient> f3408d = new d<>();

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f3409e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private final Path f3410f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final Paint f3411g = new Paint(1);
    private final RectF h = new RectF();
    private final List<l> i = new ArrayList();
    private final f j;
    private final a<c, c> k;
    private final a<Integer, Integer> l;
    private final a<PointF, PointF> m;
    private final a<PointF, PointF> n;
    private a<ColorFilter, ColorFilter> o;
    private final com.airbnb.lottie.f p;
    private final int q;

    public g(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, com.airbnb.lottie.c.b.d dVar) {
        this.f3406b = aVar;
        this.f3405a = dVar.a();
        this.p = fVar;
        this.j = dVar.b();
        this.f3410f.setFillType(dVar.c());
        this.q = (int) (fVar.r().c() / 32.0f);
        this.k = dVar.d().a();
        this.k.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.k);
        this.l = dVar.e().a();
        this.l.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.l);
        this.m = dVar.f().a();
        this.m.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.m);
        this.n = dVar.g().a();
        this.n.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.n);
    }

    public void a() {
        this.p.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            b bVar = list2.get(i2);
            if (bVar instanceof l) {
                this.i.add((l) bVar);
            }
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        com.airbnb.lottie.c.c("GradientFillContent#draw");
        this.f3410f.reset();
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            this.f3410f.addPath(this.i.get(i3).e(), matrix);
        }
        this.f3410f.computeBounds(this.h, false);
        if (this.j == f.Linear) {
            shader = c();
        } else {
            shader = d();
        }
        this.f3409e.set(matrix);
        shader.setLocalMatrix(this.f3409e);
        this.f3411g.setShader(shader);
        a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f3411g.setColorFilter(aVar.e());
        }
        this.f3411g.setAlpha(e.a((int) ((((((float) i2) / 255.0f) * ((float) this.l.e().intValue())) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f3410f, this.f3411g);
        com.airbnb.lottie.c.d("GradientFillContent#draw");
    }

    public void a(RectF rectF, Matrix matrix) {
        this.f3410f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f3410f.addPath(this.i.get(i2).e(), matrix);
        }
        this.f3410f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public String b() {
        return this.f3405a;
    }

    private LinearGradient c() {
        long e2 = (long) e();
        LinearGradient a2 = this.f3407c.a(e2);
        if (a2 != null) {
            return a2;
        }
        PointF e3 = this.m.e();
        PointF e4 = this.n.e();
        c e5 = this.k.e();
        LinearGradient linearGradient = new LinearGradient(e3.x, e3.y, e4.x, e4.y, e5.b(), e5.a(), Shader.TileMode.CLAMP);
        this.f3407c.b(e2, linearGradient);
        return linearGradient;
    }

    private RadialGradient d() {
        long e2 = (long) e();
        RadialGradient a2 = this.f3408d.a(e2);
        if (a2 != null) {
            return a2;
        }
        PointF e3 = this.m.e();
        PointF e4 = this.n.e();
        c e5 = this.k.e();
        int[] b2 = e5.b();
        float[] a3 = e5.a();
        float f2 = e3.x;
        float f3 = e3.y;
        RadialGradient radialGradient = new RadialGradient(f2, f3, (float) Math.hypot((double) (e4.x - f2), (double) (e4.y - f3)), b2, a3, Shader.TileMode.CLAMP);
        this.f3408d.b(e2, radialGradient);
        return radialGradient;
    }

    private int e() {
        int round = Math.round(this.m.f() * ((float) this.q));
        int round2 = Math.round(this.n.f() * ((float) this.q));
        int round3 = Math.round(this.k.f() * ((float) this.q));
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    public void a(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        e.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t != j.x) {
            return;
        }
        if (cVar == null) {
            this.o = null;
            return;
        }
        this.o = new p(cVar);
        this.o.a((a.C0069a) this);
        this.f3406b.a((a<?, ?>) this.o);
    }
}
